package com.zensar.lambdaassignments;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD})
@interface EmployeeTest {
	int id();

	String name();

	double salary();

}

@interface getId {
	int id();
}

@interface Getter {
	String name() default "Pavan";
}

@Employee(id = 101, name = "Pavan", salary = 10000)
public class EmployeeTest {

	private int id;
	private String name;
	private double salary;

	public EmployeeTest() {
		super();
	}

	public EmployeeTest(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@getId(id = 201)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeTest [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static void main(String[] args) throws ClassNotFoundException {
		String className = args[0];
		Class c = Class.forName(className);
		Method m[] = c.getDeclaredMethods();

		Field classMemberField = ClassWithAnnotations.class.getDeclaredField("classMember");

	}

}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public Employee(int id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
