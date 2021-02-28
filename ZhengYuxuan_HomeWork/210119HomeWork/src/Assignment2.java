import java.security.KeyStore;
import java.util.Scanner;

public class Assignment2 {
    String name,teacher;
    boolean bixiu = false;
    int hour;
    float credit;
    Assignment2(String name,boolean bixiu,String teacher,int hour,float credit){
        this.name = name;
        this.bixiu = bixiu;
        this.teacher = teacher;
        this.hour = hour;
        this.credit = credit;
    }
    public void addclass(){
        Scanner sc = new Scanner(System.in);
        System.out.println("将为您添加课程！");
        System.out.println("请输入课程名称");
        name = sc.nextLine();
        System.out.println("请输入是否为必修课");
        bixiu = sc.nextBoolean();
        System.out.println("请输入授课教师名称");
        teacher = sc.nextLine();
        System.out.println("请输入学时");
        hour = sc.nextInt();
        System.out.println("请输入学分");
        credit = sc.nextFloat();
    }
    public static void main(String[] args) {
        Assignment2 a = new Assignment2("高数",true,"大明",64,6.5f);
        Assignment2 b = new Assignment2("c语言",true,"小花",56,3.0f);
        Assignment2 c = new Assignment2("大学物理",true,"梅梅",64,3.5f);
        Assignment2 [] cd = new Assignment2[6];
        cd[0] = a;
        cd[1] = b;
        cd[2] = c;
        for (int i = 3; i < cd.length; i++) {
            cd[i].addclass();
        }
    }
}
