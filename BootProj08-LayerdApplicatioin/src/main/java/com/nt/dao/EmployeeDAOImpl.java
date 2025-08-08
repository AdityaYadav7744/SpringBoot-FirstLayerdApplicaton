package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository
public class EmployeeDAOImpl implements IEmployee {
	
	@Autowired
	private DataSource ds;
	
	private static final String GET_EMPLOYEE_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(EMP_SEQ1.NEXTVAL,?,?,?,?)";
	
	@Override
	public List<Employee> getEmployeeDegs(String deg1, String deg2, String deg3) throws Exception {
		List<Employee> list=null;
		
		try (Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMPLOYEE_QUERY);
				){
			
			ps.setString(1, deg1);
			ps.setString(2, deg2);
			ps.setString(3, deg3);

			try(ResultSet rs=ps.executeQuery()){
//				System.out.println(rs.getString(1));
				list=new ArrayList<Employee>();
				while(rs.next()) {
					Employee emp= new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setDeg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					//emp.setDeptno(rs.getInt(5));	
				
					list.add(emp);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
		return list;
	}


	@Override
	public int insertEmployee(Employee e) throws Exception {
		
		int result=0;
		
		
		try (//get pooled connection object
				Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE);
				
				){
			
			ps.setString(1,e.getName());
			ps.setString(2, e.getDeg());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getEmpno());
			
			result=ps.executeUpdate();
			
		} catch (Exception e2) {
			throw e2;
		}
		
		
		
		return result;
	}

}
