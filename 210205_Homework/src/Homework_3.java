import java.io.*;

class Student1 {
    String name;
    int age;
    String yuanxi;
    float score;
    Student1(String name,int age,float score,String yuanxi){
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
public class Homework_3 {
    public static void main(String[] args) throws IOException {
        Student student[]=new Student[3];
        student[0]=new Student("clp",18,100,"kj");
        student[1]=new Student("hkd",21,100,"kj");
        student[2]=new Student("ccc",30,80,"kj");

        File file=new File("E:\\Javawenjian\\fourth.txt");
        DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(file));
        for(int i=0;i<3;i++) {
            dataOutputStream.writeUTF(student[i].name);
            dataOutputStream.writeInt(student[i].age);
            dataOutputStream.writeFloat(student[i].score);
            dataOutputStream.writeUTF(student[i].yuanxi);
        }
        dataOutputStream.close();

        DataInputStream dataInputStream=new DataInputStream(new FileInputStream(file));
        for(int i=0;i<3;i++) {
           System.out.println(dataInputStream.readUTF()+"  "+dataInputStream.readInt()+"  "+dataInputStream.readFloat()+"  "+dataInputStream.readUTF());
        }  }
}
