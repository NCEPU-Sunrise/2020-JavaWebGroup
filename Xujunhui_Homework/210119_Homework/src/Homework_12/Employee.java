package Homework_12;

public class Employee extends Person{
	
	Employee(String name, int year_job, float salary) {
		super(name, year_job, salary);
	}
	void Add() {
		if(this.year_job<3)
			this.salary*=1.08;
		else if(this.year_job>=3)
			this.salary*=1.1;
	}
	String getInfo() {
		String info=super.getInfo()+" 职位：普通员工";
		return info;
	}
}
