package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("controler")
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	public List<Employee> showAllEmpByDegs(String deg1,String deg2,String deg3) throws Exception{
		
		List<Employee>list=service.getEmployeeByDegs(deg1, deg2, deg2);
		
		return list;
	}
	
	public String processImployee(Employee emp)throws Exception{
		
		String result=service.registrtEmploee(emp);
		return result;
	}
	
}
