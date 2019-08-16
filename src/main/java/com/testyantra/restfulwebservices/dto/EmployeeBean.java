package com.testyantra.restfulwebservices.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeBean {
	@XmlAttribute
	private String id;

	private String name;

	@XmlElement(name = "age")
	private int age;

	private String gender;

	private double salary;

	@XmlElement(name = "phone-num")
	private long phoneNum;

	@XmlElement(name = "email")
	private String emailId;

	private String designation;

	private long accountNumber;
	
	@XmlElement(name = "company")
	private String companyName;

}