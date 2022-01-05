package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
	private AccountInformationResponse Body;

	public AccountInformationResponse getBody() {
		return Body;
	}

	public void setBody(AccountInformationResponse body) {
		Body = body;
	}

}
