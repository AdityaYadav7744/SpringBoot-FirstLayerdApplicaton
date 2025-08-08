package com.nt.model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	@Nonnull
	private Integer empno;
	@Nonnull
	private String name;
	@Nonnull
	private String deg;
	@Nonnull
	private double salary;
	private double grossSalary;
	private double netSalary;

}
