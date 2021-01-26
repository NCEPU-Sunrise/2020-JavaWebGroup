package Homework_12;

public class Manager extends Person{

	Manager(String name, int year_job, float salary) {
		super(name, year_job, salary);
		// TODO Auto-generated constructor stub
	}
	void Add() {
		this.salary*=1.2;
	}
	String getInfo() {
		String info=super.getInfo()+" 职位：经理";
		return info;
	}
}
