package com;

import java.util.List;

public class Employee {
    private int empID;
    private String empName;
    private List<String> programming;

   
    public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public List<String> getProgramming() {
		return programming;
	}


	public void setProgramming(List<String> programming) {
		this.programming = programming;
	}


	@Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", programming=" + programming +
                '}';
    }
}
