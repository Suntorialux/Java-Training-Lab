/**
 * 
 */
package com.itsupportme.model.beans;

/**
 * @author Andrei
 *
 */
public class Employee {
	private int employeeId;
    private String employeeName;
    private double salary;
    private String deptName;
     
    /**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeId() {
        return employeeId;
    }
    
    
    /**
	 * @param employeeName
	 * @param salary
	 * @param deptName
	 */
	public Employee(String employeeName, double salary, String deptName) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.deptName = deptName;
	}


	public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
