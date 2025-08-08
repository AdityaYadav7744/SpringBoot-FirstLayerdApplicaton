package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> getEmployeeByDegs(String deg1,String deg2,String deg3) throws Exception;
	
	
	public String registrtEmploee(Employee e)throws Exception;
}
