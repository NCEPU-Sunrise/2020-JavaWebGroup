import java.util.Scanner;

class Caurse{
    String name;
    boolean bixiu;
    String teacher;
    int time;
    float score;
    Caurse(String name,boolean bixiu,String teacher,int time,float score){
        this.name=name;
        this.bixiu=bixiu;
        this.teacher=teacher;
        this.time=time;
        this.score=score;
    }

}
class C{
    Caurse caurse[]=new Caurse[100];
    static  int number=0;
    Scanner sc=new Scanner(System.in);
    public void add(){
        if(number<caurse.length) {
            System.out.println("输入课程名称：");
            String s=sc.next();
            System.out.println("输入是否必修课：");
            boolean b=sc.nextBoolean();
            System.out.println("输入授课老师：");
            String t=sc.next();
            System.out.println("输入学时：");
            int ti=sc.nextInt();
            System.out.println("输入学分：");
            float sco=sc.nextFloat();
            caurse[number]=new Caurse(s,b,t,ti,sco);
            number++;
        }
        else{
            System.out.println("已满");
        }

    }
    public void todelete() {
        System.out.println("输入要删除的课程：");
        String n = sc.next();
        if (number != 0) {
            for (int i = 0; i < number; i++) {
                if (caurse[i].name.equals(n)) {
                    if (i != number - 1) {
                        for (int j = i; j < number; j++) {
                            caurse[j] = caurse[j + 1];
                        }

                    }
                    number--;
                    System.out.println(number);
                }
            }
        }
        if (number == 0) {
            System.out.println("系统里已无记录！");

        }
    }
    public void search(){
        System.out.println("选择（1.按课程名2.是否必修课3.授课老师）方式查询");
        int num=sc.nextInt();
        switch(num){
            case 1:
                System.out.println("输入课程名：");
                String name=sc.next();
                for(int i=0;i<number;i++){
                    if((caurse[i].name).equals(name)){
                        System.out.println("课程名："+caurse[i].name+"\n"+"必修课："+caurse[i].bixiu+"\n"+
                                "授课老师："+caurse[i].teacher+"\n"+"学分："+caurse[i].score+"\n"+"学时："+caurse[i].time);
                    }
                }
                break;
            case 2:
                System.out.println("选择是否必修：");
                boolean b=sc.nextBoolean();
                for(int i=0;i<number;i++){
                    if(caurse[i].bixiu==b){
                        System.out.println("课程名："+caurse[i].name+"\n"+"必修课："+caurse[i].bixiu+"\n"+
                                "授课老师："+caurse[i].teacher+"\n"+"学分："+caurse[i].score+"\n"+"学时："+caurse[i].time);
                    }
                }
                break;
            case 3:
                System.out.println("选择授课老师：");
                String teachar=sc.next();
                for(int i=0;i<number;i++){
                    if(caurse[i].teacher.equals(teachar)){
                        System.out.println("课程名："+caurse[i].name+"\n"+"必修课："+caurse[i].bixiu+"\n"+
                                "授课老师："+caurse[i].teacher+"\n"+"学分："+caurse[i].score+"\n"+"学时："+caurse[i].time);
                    }
                }
                break;

        }
                
    }
    public void change() {
        System.out.println("输入要修改的课程：");
        String kecheng=sc.next();
        for(int i=0;i<number;i++){
            if(kecheng.equals(caurse[i].name)){
                System.out.println("输入课程信息：");
                System.out.println("输入课程名称：");
                String s=sc.next();
                System.out.println("输入是否必修课：");
                boolean b=sc.nextBoolean();
                System.out.println("输入授课老师：");
                String t=sc.next();
                System.out.println("输入学时：");
                int ti=sc.nextInt();
                System.out.println("输入学分：");
                float sco=sc.nextFloat();
                caurse[i].name=s;
                caurse[i].bixiu=b;
                caurse[i].teacher=t;
                caurse[i].score=sco;
                caurse[i].time=ti;
                break;
            }

            System.out.println(i);
                if(i==number-1){
                    System.out.println("查无此课程");
            }

        }


    }

}

public class javahomework_2{
    public static void main(String[] args) {
        C c=new C();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("选择：(1.添加2.删除3.修改4.查询.5退出)");
            int num=sc.nextInt();
            switch (num)
            {   case 1:
                c.add();
                break;
                case 2:
                    c.todelete();
                    break;
                case 3:
                    c.change();
                    break;
                case 4:
                    c.search();
                    break;
                case 5:
                    System.exit(0);
            }

        }
    }
}
