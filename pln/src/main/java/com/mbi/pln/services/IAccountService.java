package com.mbi.pln.services;

import javax.xml.stream.XMLStreamReader;

public interface IAccountService {

    //getaccount
    public String inquiryAccountPLN(String requestPayload) throws Exception;
    
    public XMLStreamReader inquiryAccountPLNxml(String requestPayload) throws Exception;
}
