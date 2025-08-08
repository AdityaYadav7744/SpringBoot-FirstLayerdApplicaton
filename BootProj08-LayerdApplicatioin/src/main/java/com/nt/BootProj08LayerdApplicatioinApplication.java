package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationController;
import com.nt.model.Employee;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootApplication
public class BootProj08LayerdApplicatioinApplication {

    private final EmployeeOperationController controler;

    BootProj08LayerdApplicatioinApplication(EmployeeOperationController controler) {
        this.controler = controler;
    }

//    private final EmployeeOperationController controler;

//    BootProj08LayerdApplicatioinApplication(EmployeeOperationController controler) {
//        this.controler = controler;
//    }	

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext ctx = SpringApplication.run(BootProj08LayerdApplicatioinApplication.class, args);
				Scanner sc=new Scanner(System.in)){
			
			EmployeeOperationController controller = ctx.getBean(EmployeeOperationController.class);
			
			
			System.out.println("**** Insert the Employee Details*******");
			System.out.println("Enter the Name::");
			String name=sc.next();
			System.out.println("Enter Desg::");
			String deg=sc.next();
			System.out.println("Enter salary::");
			double sal=sc.nextDouble();
			System.out.println("Enter Depertment Number::");
			int dep=sc.nextInt();
			//ENAME,JOB,SAL,DEPTNO
			
			
			// create EmployeBean class obj
			Employee empp=new Employee(dep,name,deg,sal);
			String processImployee = controller.processImployee(empp);
			System.out.println(processImployee);
			
			
			System.out.println("Enter The First Deg::");
			String deg1=sc.next();
			
			System.out.println("Enter The First Deg::");
			String deg2=sc.next();
			
			System.out.println("Enter The First Deg::");
			String deg3=sc.next();
			
//			String deg1="CLERK";
//			String deg2="SALESMAN";
//			String deg3="MANAGER";
			
			try {
				List<Employee>list=controller.showAllEmpByDegs(deg1, deg2, deg3);
				list.forEach(emp->
				System.out.println(emp));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
