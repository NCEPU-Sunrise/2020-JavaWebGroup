package Homework_12;

public class Person {
	String name;
	int year_job;
	float salary;
	Person(String name,int year_job,float salary){
		this.name=name;
		this.year_job=year_job;
		this.salary=salary;
	}
	String getInfo() {
		String info="姓名："+name+" 工龄："+year_job+" 工资："+salary;
		return info;
	}
}
