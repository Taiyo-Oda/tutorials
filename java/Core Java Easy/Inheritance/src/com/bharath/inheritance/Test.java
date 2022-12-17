package com.bharath.inheritance;

public class Test {
	
	public static void main(String[] args) {
		String[] projects = new String[] {"Flight Resavration", "Check In"};
		Manager manager = new Manager(1, "John", "Travel", 1000000, projects);
		System.out.println(manager.id);
		System.out.println(manager.name);
		System.out.println(manager.dept);
		System.out.println(manager.salary);
		manager.work();
		
		Developer developer = new Developer(2, "Taiyo", "Travel", 2000000, "Full Stack Java Development");
		developer.work();
	}

}
