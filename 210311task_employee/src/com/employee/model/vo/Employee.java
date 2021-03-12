package com.employee.model.vo;

import java.util.Date;

public class Employee {
	private String empId, empName, empNo, email, phone,deptCode,jobCode,salLevel;
	private int salary, bonus;
	private String managerId;
	private Date hireDate, entDate;
	private String entYn;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, int bonus, String managerId, Date hireDate, Date entDate,
			String entYn) {
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getJobCode() {
		return jobCode;
	}


	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}


	public String getSalLevel() {
		return salLevel;
	}


	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public Date getEntDate() {
		return entDate;
	}


	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}


	public String getEntYn() {
		return entYn;
	}


	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}
	
	

	
	
	
	
	

}
