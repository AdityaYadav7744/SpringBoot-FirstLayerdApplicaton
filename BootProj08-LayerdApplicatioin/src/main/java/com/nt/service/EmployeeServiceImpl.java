package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.BootProj08LayerdApplicatioinApplication;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployee;
import com.nt.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeMgmtService {

   	@Autowired
	private IEmployee dao;


	@Override
	public List<Employee> getEmployeeByDegs(String deg1, String deg2, String deg3) throws Exception {
		
		
		deg1=deg1.toUpperCase();
		deg2=deg2.toUpperCase();
		deg3=deg3.toUpperCase();
		
		//use Dao
		List<Employee> list=dao.getEmployeeDegs(deg1, deg2, deg3);
		//sort the object collection
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
		
		//calculate gross salary
		list.forEach(
				emp->{
					emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.5));
					emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
				});
		
		return list;
	}


	@Override
	public String registrtEmploee(Employee e) throws Exception {
		
		int result=dao.insertEmployee(e);
		
		return result==0?"Employee not register":"Employee register sucessfully";
	}

}
