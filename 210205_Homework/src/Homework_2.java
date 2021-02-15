import java.io.*;

class Student implements Serializable{
    String name;
    int age;
    String yuanxi;
    float score;
    Student(String name,int age,float score,String yuanxi){
        this.age=age;
        this.name=name;
        this.score=score;
        this.yuanxi=yuanxi;
    }
    String getName()
    {
        return this.name;
    }
    int getAge(){
        return this.age;
    }
    float getScore(){
        return this.score;
    }

    String getYuanxi(){
        return this.yuanxi;
    }

}

public class Homework_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student[]=new Student[3];
        student[0]=new Student("clp",18,100,"kj");
        student[1]=new Student("hkd",21,100,"kj");
        student[2]=new Student("ccc",30,80,"kj");
        File sourceFile=new File("E:\\Javawenjian\\third.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(sourceFile));
        for(int i=0;i<3;i++){
        objectOutputStream.writeObject(student[i]);}
        objectOutputStream.close();
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(sourceFile));
        Student s[]=new Student[3];
        for(int i=0;i<3;i++){
        s[i] = (Student) objectInputStream.readObject();
        }
        objectInputStream.close();
        for(int i=0;i<3;i++)
        {
            System.out.println(s[i].getName()+"  "+s[i].getAge()+"  "+s[i].getScore()+"  "+s[i].getYuanxi());
        }
        }
    }

