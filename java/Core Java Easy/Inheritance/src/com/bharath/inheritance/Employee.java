package com.bharath.inheritance;

public class Employee {
	
	int id;
	String name;
	String dept;
	double salary;
	
	public Employee(int id, String name, String dept, double salary) {
		System.out.println("Inside Employee constructor");
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	protected void work() {
		System.out.println("Common Work For Everyone");
	}
	
	/*
	//子クラスがこのメソッドを継承しない場合は、final修飾子を使用する。
	protected final void work() {
		System.out.println("Common Work For Everyone");
	}
	*/

}
