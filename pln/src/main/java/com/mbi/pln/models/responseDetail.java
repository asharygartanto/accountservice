package com.mbi.pln.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class responseDetail {
	
	private String error_origin;
	private String response_code;
	private String response_data;
	
	
	public String getError_origin() {
		return error_origin;
	}
	public void setError_origin(String error_origin) {
		this.error_origin = error_origin;
	}
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public String getResponse_data() {
		return response_data;
	}
	public void setResponse_data(String response_data) {
		this.response_data = response_data;
	}
	

}
