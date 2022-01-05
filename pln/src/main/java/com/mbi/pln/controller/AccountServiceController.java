package com.mbi.pln.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbi.pln.models.AccountInformation;
import com.mbi.pln.models.AccountInformationRequest;
import com.mbi.pln.models.AccountInformationResponse;

import com.mbi.pln.models.AccountStatementToday;
import com.mbi.pln.models.AccountStatementTodayRequest;
import com.mbi.pln.models.AccountStatementTodayResponse;
import com.mbi.pln.models.Body;
import com.mbi.pln.models.ChannelHeader;
import com.mbi.pln.services.IAccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@RefreshScope
@RestController
@RequestMapping(value = "/accountservice")
@Component
public class AccountServiceController {

  @Autowired
	private IAccountService accountService;
  
  @Autowired
  private ApplicationProps myConfig;

  private static final Logger LOGGER=LoggerFactory.getLogger(AccountServiceController.class);
  
  
  @RequestMapping(value = "/inquiryaccount", method = RequestMethod.POST,consumes = "application/xml" , produces = "application/json")
	public String inquiryAccount(@RequestBody String requestPayload,HttpServletRequest request) throws JAXBException, IOException, SOAPException {
		String result = null;
		//XMLStreamReader xMLStreamReader = null;
		try {
			/*String oauthToken = request.getHeader(ApplicationConstants.AUTH_HEADER);
			if(oauthToken!=null) {
				oauthToken = oauthToken.replace("Bearer ", "");
			}*/
			result = accountService.inquiryAccountPLN( requestPayload);
			//xMLStreamReader = accountService.inquiryAccountPLNxml( requestPayload);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SOAPMessage message = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(result.getBytes()));
		
		//XmlMapper xmlMapper = new XmlMapper();
		JAXBContext jAXBContext =  JAXBContext.newInstance(Body.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		//StringReader reader = new StringReader(message);
		AccountInformationResponse account = new AccountInformationResponse();
		account = (AccountInformationResponse) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
		
		/*
		
		try {
			account = xmlMapper.readValue(result, Body.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(account);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return json;
		//return result;
	}
  
  
  @RequestMapping(value = "/inquiryaccountjson", method = RequestMethod.POST,consumes = "application/json" , produces = "application/json")
	public String inquiryAccountJson(@RequestBody String requestPayload,HttpServletRequest request) throws JAXBException, IOException, SOAPException {
	  List<String> accnos = myConfig.getAccountno();
	  LocalDateTime localDateTime = LocalDateTime.now();
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      String formatDateTime = localDateTime.format(formatter);

      System.out.println("After : " + formatDateTime);
      
	  LOGGER.info("--Balance Inquiry--  {} /n",formatDateTime );
	  LOGGER.info("================================================================== /n /n");
	  localDateTime = LocalDateTime.now();
	  formatDateTime = localDateTime.format(formatter);
	  LOGGER.info("{} - Payload : /n {} /n",formatDateTime, requestPayload );
	  //LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	  AccountInformation ai = new AccountInformation();
	  
	  String result = null;
		try {
			JSONObject _json = new JSONObject(requestPayload);
			 ai = fromJsonToAccountInfoModel(_json);
			 if(!accnos.contains(ai.getAccountInformationRequest().getAccountNo())) {
				 ObjectMapper map = new ObjectMapper();
	 				String errjson = "Account Number, not registered";
	 				String errmapjson = map.writeValueAsString(errjson);
	 				 return errmapjson;
	 			 }	 
			String wsdl = fromAccountInfotoSoap(ai);
			LOGGER.info("{} - Request wsdl : /n {} /n",formatDateTime, wsdl );
			result = accountService.inquiryAccountPLN( wsdl);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SOAPMessage message = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(result.getBytes()));
		
		//XmlMapper xmlMapper = new XmlMapper();
		JAXBContext jAXBContext =  JAXBContext.newInstance(Body.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		//StringReader reader = new StringReader(message);
		AccountInformationResponse account = new AccountInformationResponse();
		account = (AccountInformationResponse) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(account);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		LOGGER.info("--------------------------------------------------------------- /n" );
 		localDateTime = LocalDateTime.now();
 		formatDateTime = localDateTime.format(formatter);
 		LOGGER.info("{} - Response : /n {} /n",localDateTime, json );
 		LOGGER.info("================================================================== /n /n");

		return json;
		//return result;
	}

  
  @RequestMapping(value = "/accountstatementjson", method = RequestMethod.POST,consumes = "application/json" , produces = "application/json")
 	public String AccountStatementJson(@RequestBody String requestPayload,HttpServletRequest request) throws JAXBException, IOException, SOAPException {
	  List<String> accnos = myConfig.getAccountno();
	  
	  LocalDateTime localDateTime = LocalDateTime.now();
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      String formatDateTime = localDateTime.format(formatter);

      LOGGER.info("--Account Statement--  {} /n",formatDateTime );
	  LOGGER.info("================================================================== /n /n");
	  localDateTime = LocalDateTime.now();
	  formatDateTime = localDateTime.format(formatter);
	  LOGGER.info("{} - Payload : /n {} /n",formatDateTime, requestPayload );
	  
	  AccountStatementToday as = new AccountStatementToday();
 	  String result = null;
 		try {
 			JSONObject _json = new JSONObject(requestPayload);
 			 as = fromJsonToAccountStateModel(_json);
 			 if(!accnos.contains(as.getAccountInformationRequest().getAccountNo())) {
 				ObjectMapper map = new ObjectMapper();
 				String errjson = "Account Number, not registered";
 				String errmapjson = map.writeValueAsString(errjson);
 				 return errmapjson;
 			 }
 			 //as.getAccountInformationRequest().getAccountNo()
 			String wsdl = fromAccountStatetoSoap(as);
 			LOGGER.info("{} - Request wsdl : /n {} /n",formatDateTime, wsdl );
 			result = accountService.inquiryAccountPLN( wsdl);
 		} 
 		catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		SOAPMessage message = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(result.getBytes()));
 		
 		//XmlMapper xmlMapper = new XmlMapper();
 		JAXBContext jAXBContext =  JAXBContext.newInstance(AccountStatementTodayResponse.class);
 		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
 		//StringReader reader = new StringReader(message);
 		AccountStatementTodayResponse account = new AccountStatementTodayResponse();
 		account = (AccountStatementTodayResponse) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
 		
 		
 		ObjectMapper mapper = new ObjectMapper();
 		String json="";
 		try {
 			json = mapper.writeValueAsString(account);
 		} catch (JsonProcessingException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		LOGGER.info("--------------------------------------------------------------- /n" );
 		localDateTime = LocalDateTime.now();
 		formatDateTime = localDateTime.format(formatter);
 		LOGGER.info("{} - Response : /n {} /n",localDateTime, json );
 		LOGGER.info("================================================================== /n /n");


 		return json;
 		//return result;
 	}

  
  public static String fromAccountInfotoSoap(AccountInformation ai) throws JAXBException {
	  //AccountInformationResponse air = new AccountInformationResponse();
	  String soapEnvelope =
		        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:acc=\"http://www.bankbii.com/AccountServices/\">" +
		                "<soapenv:Header /><soapenv:Body>%s</soapenv:Body></soapenv:Envelope>";
		Marshaller marshaller = JAXBContext.newInstance(AccountInformation.class).createMarshaller();
		marshaller.setProperty("jaxb.fragment", Boolean.TRUE); // required to stop <?xml ... being added ?>
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(ai, outputStream);
		String payload = new String(outputStream.toByteArray());
		String output = String.format(soapEnvelope, payload);
		return output;
  }
  
  public static String fromAccountStatetoSoap(AccountStatementToday as) throws JAXBException {
	  //AccountInformationResponse air = new AccountInformationResponse();
	  String soapEnvelope =
		        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:acc=\"http://www.bankbii.com/AccountServices/\">" +
		                "<soapenv:Header /><soapenv:Body>%s</soapenv:Body></soapenv:Envelope>";
		Marshaller marshaller = JAXBContext.newInstance(AccountStatementToday.class).createMarshaller();
		marshaller.setProperty("jaxb.fragment", Boolean.TRUE); // required to stop <?xml ... being added ?>
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(as, outputStream);
		String payload = new String(outputStream.toByteArray());
		String output = String.format(soapEnvelope, payload);
		return output;
  }
	
  public AccountInformation fromJsonToAccountInfoModel(JSONObject jsonObject) throws JSONException {
  ApplicationProps appProps = new ApplicationProps();
  LocalDateTime localDateTime = LocalDateTime.now();
  DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  String formatDate = localDateTime.format(dateformatter);
  
  DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
  String formatTime = localDateTime.format(timeformatter);
  //LocalTime time= LocalTime.parse(LocalTime.now().toString(), DateTimeFormatter.ofPattern("H:mm:ss"));
 
	  List<String> accnos = myConfig.getAccountno(); //appProps.getAccountno();
	  String curr = myConfig.getCurrencyCode();//appProps.getAccountCurrency();
	
	  AccountInformation ai = new AccountInformation();
	  ChannelHeader ch = new ChannelHeader();
	  AccountInformationRequest air = new AccountInformationRequest();
	  JSONObject accountinfo =  new JSONObject(jsonObject.getString("AccountInformation"));
	  //JSONObject channelheader =  new JSONObject(accountinfo.getString("ChannelHeader"));
	  JSONObject accountinforeq =  new JSONObject(accountinfo.getString("AccountInformationRequest"));
	  //try {
	  		ch.setMessageID(myConfig.getMessageID());//channelheader.getString("messageID"));
	  		ch.setBranchCode(myConfig.getBranchCode());//channelheader.getString();//"branchCode"));
	  		ch.setChannelID(myConfig.getChannelID());//channelheader.getString());//"channelID"));
	  		ch.setClientSupervisorID(myConfig.getClientSupervisorID());//channelheader.getString());//"clientSupervisorID"));
	  		ch.setClientUserID(myConfig.getClientUserID());//channelheader.getString());//"clientUserID"));
	  		ch.setReference(myConfig.getReference());//channelheader.getString());//"reference"));
	  		ch.setSequenceno(myConfig.getSequenceno());//channelheader.getString());//"sequenceno"));
	  		ch.setTransactiondate(formatDate);//(channelheader.getString("transactiondate"));
	  		ch.setTransactiontime(formatTime);//(channelheader.getString("transactiontime"));
	        	
	        /*} catch (JSONException e) {
	            e.printStackTrace();
	            return null;
	        }*/
	  try {
	  		air.setAccountNo(accountinforeq.getString("accountNo"));
	  		air.setAccountBranchCode(accountinforeq.getString("accountBranchCode"));
	  		air.setAccountCurrency(myConfig.getCurrencyCode().split("-")[1]);//(myConfig.getAccountCurrency());//accountinforeq.getString("accountCurrency"));
	  			
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return null;
	        }
	  	ai.setChannelHeader(ch);
			ai.setAccountInformationRequest(air);
	  	// Return new object
	  	return ai;
	  }

  public  AccountStatementToday fromJsonToAccountStateModel(JSONObject jsonObject) throws JSONException {
	  ApplicationProps appProps = new ApplicationProps();
	  LocalDateTime localDateTime = LocalDateTime.now();
	  DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  String formatDate = localDateTime.format(dateformatter);
	  
	  DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	  String formatTime = localDateTime.format(timeformatter);
	  //LocalTime time= LocalTime.parse(LocalTime.now().toString(), DateTimeFormatter.ofPattern("H:mm:ss"));
	 
	  List<String> accnos = myConfig.getAccountno();//appProps.getAccountno();
	  //String curr = myConfig.getAccountCurrency(); //appProps.getAccountCurrency();
	  
	  
	  AccountStatementToday as = new AccountStatementToday();
	  ChannelHeader ch = new ChannelHeader();
	  AccountStatementTodayRequest astr = new AccountStatementTodayRequest();
	  JSONObject accountstate =  new JSONObject(jsonObject.getString("AccountStatementToday"));
	  //JSONObject channelheader =  new JSONObject(accountstate.getString("ChannelHeader"));
	  JSONObject accountstatereq =  new JSONObject(accountstate.getString("AccountStatementTodayRequest"));
	  //try {
		  ch.setMessageID(myConfig.getMessageID());//ch.setMessageID(channelheader.getString("messageID"));
		  ch.setBranchCode(myConfig.getBranchCode());//ch.setBranchCode(channelheader.getString("branchCode"));
		  ch.setChannelID(myConfig.getChannelID());//ch.setChannelID(channelheader.getString("channelID"));
		  ch.setClientSupervisorID(myConfig.getClientSupervisorID());//ch.setClientSupervisorID(channelheader.getString("clientSupervisorID"));
		  ch.setClientUserID(myConfig.getClientUserID());//ch.setClientUserID(channelheader.getString("clientUserID"));
		  ch.setReference(myConfig.getReference());//ch.setReference(channelheader.getString("reference"));
		  ch.setSequenceno(myConfig.getSequenceno());//ch.setSequenceno(channelheader.getString("sequenceno"));
	  		ch.setTransactiondate(formatDate);//(channelheader.getString("transactiondate"));
	  		ch.setTransactiontime(formatTime);//(channelheader.getString("transactiontime"));
	        	
	        /*} catch (JSONException e) {
	            e.printStackTrace();
	            return null;
	        }*/
	  try {
		  astr.setAccountNo(accountstatereq.getString("accountNo"));
		  astr.setAccountBranchCode(accountstatereq.getString("accountBranchCode"));
		  astr.setAccountCurrency(myConfig.getCurrencyCode().split("-")[1]);//(accountstatereq.getString("accountCurrency"));
		  	 if(accountstatereq.getString("accountNo").charAt(0)=='2') {
		  		astr.setRecordNum("3");
		  	 }
		  	 else {
		  		astr.setRecordNum("13"); 
		  	 }
		  	 if(accountstatereq.has("dbkey1")) {
			  	if(accountstatereq.getString("dbkey1")!="") {
			  		astr.setDbkey1(accountstatereq.getString("dbkey1"));
			  		astr.setDbkey2(accountstatereq.getString("dbkey2"));
			  	}
			  	
		  	}
		  	if(accountstatereq.has("dbkey3")) {
		  		if(accountstatereq.getString("dbkey3")!="") {
			  		astr.setDbkey3(accountstatereq.getString("dbkey3"));
			  		
			  	}
		  	} 
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
	  	as.setChannelHeader(ch);
			as.setAccountStatementTodayRequest(astr);
	  	// Return new object
	  	return as;
	  }

  
}