package com.testyantra.restfulwebservices.dao;

import java.util.HashSet;
import java.util.Set;

import com.testyantra.restfulwebservices.dto.EmployeeBean;

public class EmployeeDAO {
	private static Set<EmployeeBean> employeeBeans = new HashSet<EmployeeBean>();
	
	public EmployeeDAO() {
		EmployeeBean bean = new EmployeeBean();
		bean.setId("TYP023");
		bean.setName("Giridhar");
		bean.setAccountNumber(123456789012L);
		bean.setAge(28);
		bean.setCompanyName("tesTYantra");
		bean.setDesignation("Software Engeneer");
		bean.setEmailId("giridhar.mg@testyantra.com");
		bean.setPhoneNum(9876543210L);
		bean.setSalary(70000);
		bean.setGender("M");
		
		employeeBeans.add(bean);
	}
	public boolean createEmployee(EmployeeBean bean) {
		return employeeBeans.add(bean);
	}
	
	public boolean modifyEmployee(EmployeeBean bean) {
		for (EmployeeBean employeeBean : employeeBeans) {
			if(employeeBean.equals(bean)){
				employeeBean.setId(bean.getId());
				employeeBean.setAge(bean.getAge());
				employeeBean.setAccountNumber(bean.getAccountNumber());
				employeeBean.setDesignation(bean.getDesignation());
				employeeBean.setEmailId(bean.getEmailId());
				employeeBean.setGender(bean.getGender());
				employeeBean.setName(bean.getName());
				employeeBean.setPhoneNum(bean.getPhoneNum());
				employeeBean.setSalary(bean.getSalary());
				employeeBean.setCompanyName(bean.getCompanyName());
				return true;
			}
		}
		return false;
	}
	
	public EmployeeBean getEmployee(String id) {
		for (EmployeeBean employeeBean : employeeBeans) {
			if(employeeBean.getId().equals(id))
				return employeeBean;
		}
		return null;
	}
	
	public Set<EmployeeBean> getAllEmployee() {
		return employeeBeans;
	}
	
	public boolean removeEmployee(String id) {
		for (EmployeeBean employeeBean : employeeBeans) {
			if(employeeBean.getId().equals(id))
				return employeeBeans.remove(employeeBean);
			
		}
		return false;
	}
}
