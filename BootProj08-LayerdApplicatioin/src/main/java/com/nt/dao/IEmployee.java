package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployee {
	
	public List<Employee> getEmployeeDegs(String deg1,String deg2, String deg3) throws Exception;
	public int insertEmployee(Employee e)throws Exception;
	
}