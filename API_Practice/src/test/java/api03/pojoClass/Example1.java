package api03.pojoClass;

import org.testng.annotations.Test;

public class Example1 {
	String name;
	public int empID;
	private double salary;
	public Example1(String name,int empID,double salary) {
		this.name=name;
		this.empID=empID;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public int getEmpID() {
		return empID;
	}
	public double getSalary() {
		return salary;
	}
}

class Driver{
	@Test
	public void pojoTest() {
		Example1 ex=new Example1("Shubham",101,100000.50);
		System.out.println(ex.getName());
		System.out.println(ex.getEmpID());
		System.out.println(ex.getSalary());
	}
}
