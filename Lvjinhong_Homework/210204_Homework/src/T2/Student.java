package T2;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    String department;
    int age;
    float score;

    public Student(String name,String department,int age,float score){
        this.name = name;
        this.department = department;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public float getScore() {
        return score;
    }
}
