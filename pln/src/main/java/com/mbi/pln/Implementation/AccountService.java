package com.mbi.pln.Implementation;

import javax.xml.stream.XMLStreamReader;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mbi.pln.constant.ApplicationConstants;
import com.mbi.pln.services.IAccountService;

//import com.google.gson.Gson;
@Service
public class AccountService implements IAccountService {

    @Override
	public String inquiryAccountPLN( String requestPayload) throws Exception {
        String response = null;
        try {
            /*
             * TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String
             * authType) -> true;
             * 
             * SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
             * .loadTrustMaterial(null, acceptingTrustStrategy) .build();
             * 
             * SSLConnectionSocketFactory csf = new
             * SSLConnectionSocketFactory(sslContext,NoopHostnameVerifier.INSTANCE);
             * 
             * CloseableHttpClient httpClient = HttpClients.custom()
             * .setSSLSocketFactory(csf) .build();
             */
            final CloseableHttpClient httpClient = HttpClients.createDefault();

            final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);

            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            // headers.add(ApplicationConstants.AUTH_HEADER, "Bearer "+oauthToken);
            // headers.add(ApplicationConstants.API_KEY_HEADER,
            // DigitalSecurity.INQ_API_KEY);
            // headers.add(ApplicationConstants.TIMESTAMP_HEADER, timestamp);
            // headers.add(ApplicationConstants.SIGNATURE_HEADER,
            // this.calculateSignature(HttpMethod.POST.toString(), oauthToken, timestamp,
            // requestPayload,DigitalSecurity.INQ_API_SECRET));

            final HttpEntity<String> entity = new HttpEntity<String>(requestPayload, headers);
            final RestTemplate restTemplate = new RestTemplate(requestFactory);
            response = restTemplate.postForObject(ApplicationConstants.URL_INQ_PLN, entity, String.class);

        } catch (final Exception e) {
            throw e;
        }
        return response;
    }
  
    @Override
	public XMLStreamReader inquiryAccountPLNxml( String requestPayload) throws Exception {
        XMLStreamReader response = null;
        try {
            /*
             * TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String
             * authType) -> true;
             * 
             * SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
             * .loadTrustMaterial(null, acceptingTrustStrategy) .build();
             * 
             * SSLConnectionSocketFactory csf = new
             * SSLConnectionSocketFactory(sslContext,NoopHostnameVerifier.INSTANCE);
             * 
             * CloseableHttpClient httpClient = HttpClients.custom()
             * .setSSLSocketFactory(csf) .build();
             */
            final CloseableHttpClient httpClient = HttpClients.createDefault();

            final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);

            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            // headers.add(ApplicationConstants.AUTH_HEADER, "Bearer "+oauthToken);
            // headers.add(ApplicationConstants.API_KEY_HEADER,
            // DigitalSecurity.INQ_API_KEY);
            // headers.add(ApplicationConstants.TIMESTAMP_HEADER, timestamp);
            // headers.add(ApplicationConstants.SIGNATURE_HEADER,
            // this.calculateSignature(HttpMethod.POST.toString(), oauthToken, timestamp,
            // requestPayload,DigitalSecurity.INQ_API_SECRET));

            final HttpEntity<String> entity = new HttpEntity<String>(requestPayload, headers);
            final RestTemplate restTemplate = new RestTemplate(requestFactory);
            response = restTemplate.postForObject(ApplicationConstants.URL_INQ_PLN, entity, XMLStreamReader.class);

        } catch (final Exception e) {
            throw e;
        }
        return response;
    }
  
}