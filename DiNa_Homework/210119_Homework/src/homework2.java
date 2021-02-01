import java.util.*;
class Course {
    String name;
    boolean required;
    String teacher;
    int hour;
    float score;
    Course() {
    }
    Course(String name, boolean required, String teacher, int hour, float score) {
       this.name = name;
       this.required = required;
       this.teacher = teacher;
       this.hour = hour;
       this.score = score;
    }
    void print() {
        System.out.println("课程名："+name+"\n"+"必修课："+required+"\n"+
                "授课老师："+teacher+"\n"+"学分："+score+"\n"+"学时："+hour);
    }

}

class Coursemanage {
    Course course[]=new Course[200];
    static int num= 0;
    public void Add() {
        int num=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加课程的信息：");
        System.out.print("课程名称：");
        String n=sc.next();
        System.out.print("是否为选修课：（0/1）");
        boolean r=sc.nextBoolean();
        System.out.println("请输入授课老师：");
        String t = sc.next();
        System.out.print("请输入学时：");
       int h = sc.nextInt();
        System.out.print("请输入学分：");
        float s = sc.nextFloat();
        course[num++] = new Course(n,r,t,h,s);

    }

   public void find() {
       System.out.println("请选择查询方式：");
       System.out.println("1.课程名\t2.是否必修课\t3.老师");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        switch (no) {
            case 1:
                    System.out.print("请输入课程名：");
                    String name = sc.next();
                        for (int i = 0; i < num; i++) {
                            if (course[i].name.equals(name)) {
                                course[i].print();
                            }
                        }

                    break;
            case 2:
                    System.out.print("是否必修：（输入0/1）：");
                    boolean b=sc.nextBoolean();
                    for(int i=0;i<num;i++){
                        if(course[i].required==b){
                            course[i].print();
                        }
                    }
                    break;
            case 3:
                   System.out.print("请输入教师：");
                    String teacher = sc.next();
                for(int i=0;i<num;i++){
                    if(course[i].teacher.equals(teacher)){
                        course[i].print();
                    }
                }
                break;
            default:
                System.out.println("输入有误");
                break;
        }

    }

  public  void delete() {
      System.out.print("请输入要删除课程名称：");

      if (num != 0) {
          while (true) {
              Scanner sc = new Scanner(System.in);
              String n = sc.next();
              for (int i = 0; i < num ;i++){
                  if (course[i].name.equals(n)) {
                      for (int j = i; j < num; j++) {
                          course[j] = course[j + 1];
                      }

                      num--;
                      System.out.println("删除课程成功！");


                  }
              }
          }
      }
         else{   System.out.println("无记录！");
        }
    }


    public void change() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要修改的课程名：");
        String a = sc.next();
        int num = 0;
        int i=0;
        System.out.println("\t1.修改课程名\t       2.修改选修课类型");
        System.out.println("\t3.修改老师\t       4.修改学时");
        System.out.println("\t5.修改学分\t       6.退出程序");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("输入新的课程名：");
                course[i].name = sc.next();
                System.out.println("修改成功！");
                break;
            case 2:
                System.out.print("输入选修课类型(0/1)：");
                course[i].required = sc.nextBoolean();
                System.out.println("修改成功！");
                break;
            case 3:
                System.out.print("输入任课教师姓名：");
                course[i].teacher = sc.next();
                System.out.println("修改成功！");
                break;
            case 4:
                System.out.print("输入新的课程学时：");
                course[i].hour= sc.nextInt();
                System.out.println("修改成功！");
                break;
            case 5:
                System.out.print("输入新的课程学分：");
                course[i].score = sc.nextFloat();
                System.out.println("修改成功！");
                break;
            case 6:
                return;
            default:
                System.out.println("输入有误");
                break;

        }

        System.out.println(i);
                }
}


public class homework2 {

    public static void main(String[] args) {
        Coursemanage course=new Coursemanage();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------------欢迎进入管理系统----------------");
            System.out.println("\t1.添加课程\t       2.删除课程");
            System.out.println("\t3.修改课程\t       4.查询课程");
            System.out.println("\t5.退出程序\t");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    course.Add();
                    break;
                case 2:
                    course.delete();
                    break;
                case 3:
                    course.change();
                    break;
                case 4:
                    course.find();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }
}
