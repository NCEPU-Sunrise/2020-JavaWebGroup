package Homework_02;

import java.io.Serializable;

public class Student implements Serializable{
	String name;
	String department;
	int age;
	float score;
	public Student(String name,String department,int age,float score) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.department=department;
		this.age=age;
		this.score=score;
	}
	
}
