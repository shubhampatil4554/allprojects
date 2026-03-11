package api03.pojoClass;

import org.testng.annotations.Test;

public class Example2 {
	String name;
	public int empID;
	private double salary;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public void setEmpID(int empID) {
		this.empID=empID;
	}
	public int getEmpID() {
		return empID;
	}
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public double getSalary() {
		return salary;
	}
}
class Driver2{
	@Test
	public void testPojo() {
		Example2 ex=new Example2();
		ex.setName("Shubham");
		ex.setEmpID(101);
		ex.setSalary(150000.50);
		System.out.println(ex.getName());
		System.out.println(ex.getEmpID());
		System.out.println(ex.getSalary());
	}
}
