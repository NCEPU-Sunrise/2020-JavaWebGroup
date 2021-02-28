package homework_one;
import java.util.Vector ;
import java.util.Scanner ;
public class homework2 {
    public static void main(String[] args) {
        Vector className = new Vector();
        Vector Must = new Vector();
        Vector teacherName = new Vector();
        Vector lessonTime = new Vector();
        Vector lessonScore = new Vector();
        int m, n ;
        float k ;
        String s ;
        boolean a;
        Course lesson = new Course();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入教务查询系统");
        System.out.println("请创建课程信息：   ");
        for (n = 0; ; n++) {
            System.out.println("请输入课程名称");
            lesson.name = sc.next();
            className.add(lesson.name);

            System.out.println("请输入是否为必修课程（true/false）");
            lesson.must = sc.nextBoolean();
            Must.add(lesson.must);

            System.out.println("请输入授课老师姓名");
            lesson.teacher = sc.next();
            teacherName.add(lesson.teacher);

            System.out.println("请输入课程学时");
            lesson.time = sc.nextInt();
            lessonTime.add(lesson.time);

            System.out.println("请输入课程学分");
            lesson.score = sc.nextFloat();
            lessonScore.add(lesson.score);
            System.out.println("是否继续创建课程(true（是）/false（否）)");
            a = sc.nextBoolean();
            if(!a)
                break;
        }
        System.out.println("是否添加课程（true/false）");
        a = sc.nextBoolean();
        if (a) {
            System.out.println("请输入课程名称");
            lesson.name = sc.next();
            className.add(lesson.name);

            System.out.println("请输入是否为必修课程（true/false）");
            lesson.must = sc.nextBoolean();
            Must.add(lesson.must);

            System.out.println("请输入授课老师姓名");
            lesson.teacher = sc.next();
            teacherName.add(lesson.teacher);

            System.out.println("请输入课程学时");
            lesson.time = sc.nextInt();
            lessonTime.add(lesson.time);

            System.out.println("请输入课程学分");
            lesson.score = sc.nextFloat();
            lessonScore.add(lesson.score);

            System.out.println("是否继续添加课程（true/false）");
            for (; ; ) {
                a = sc.nextBoolean();
                if (!a)
                    break;
                System.out.println("请输入课程名称");
                lesson.name = sc.next();
                className.add(lesson.name);

                System.out.println("请输入是否为必修课程（true/false）");
                lesson.must = sc.nextBoolean();
                Must.add(lesson.must);

                System.out.println("请输入授课老师姓名");
                lesson.teacher = sc.next();
                teacherName.add(lesson.teacher);

                System.out.println("请输入课程学时");
                lesson.time = sc.nextInt();
                lessonTime.add(lesson.time);

                System.out.println("请输入课程学分");
                lesson.score = sc.nextFloat();
                lessonScore.add(lesson.score);
                System.out.println("是否继续添加课程（true（是）/false（否））");
            }
        }
        System.out.println("是否删除课程（true（是）/false（否））");
        a = sc.nextBoolean();
        for (; ; ) {
            if(!a)
                break ;
            System.out.println("请输入想要删除的课程名称");
           s = sc.next() ;
           m = className.indexOf(s) ;
           className.remove(m) ;
           Must.remove(m) ;
           teacherName.remove(m) ;
           lessonScore.remove(m) ;
           lessonTime.remove(m) ;
            System.out.println("是否继续删除课程(true（是）/false（否）)");
            a = sc.nextBoolean();
        }
        System.out.println("是否修改课程(true（是）/false（否）)");
        a = sc.nextBoolean();
        if (a)
        {
            System.out.println("请输入修改课程名称");
            s = sc.next() ;
            m = className.indexOf(s) ;
            System.out.println("是否修改授课老师(true（是）/false（否）)");
            a = sc.nextBoolean();
            for (;;)
            {if (a)
            {
                {
                    System.out.println("请输入新的授课老师姓名");
                    s = sc.next() ;
                    teacherName.set( m , s ) ;
                }
                System.out.println("是否修改是否为必修课程(true（是）/false（否）)");
                a = sc.nextBoolean();
                if (a)
                {
                    System.out.println("请输入是否必修(true（是）/false（否）)");
                    a = sc.nextBoolean() ;
                    Must.set( m , a ) ;
                }
                System.out.println("是否修改课程学时(true（是）/false（否）)");
                a = sc.nextBoolean();
                if (a)
                {
                    System.out.println("请输入新的课程学时");
                    n = sc.nextInt() ;
                    lessonTime.set( m , n ) ;
                }
                System.out.println("是否修改课程学分(true（是）/false（否）)");
                a = sc.nextBoolean();
                if (a)
                {
                    System.out.println("请输入新的课程学分");
                    k = sc.nextFloat() ;
                    lessonScore.set( m , k ) ;
                }
                System.out.println("是否继续修改课程(true（是）/false（否）)");
                a = sc.nextBoolean();
            }
                else
                    break ;
            }
        }
        System.out.println("是否查询课程(true（是）/false（否）)") ;
        for (;;){
            a = sc.nextBoolean();
            if (!a)
                break ;
            System.out.println("是否查询全部课程(true（是）/false（否）)");
            a = sc.nextBoolean();
            if(a)
            {   System.out.println("课程名称："+className);
                System.out.println("是否必修："+Must);
                System.out.println("教师姓名："+teacherName);
                System.out.println("课程学分："+lessonScore);
                System.out.println("课程学时："+lessonTime);}
            else
            {  System.out.println("请输入想要查询的课程名称");
                s = sc.next() ;
                m = className.indexOf(s) ;
                if (m!=-1)
                {   System.out.println("课程名称："+className.get(m));
                    System.out.println("是否必修："+Must.get(m));
                    System.out.println("教师姓名："+teacherName.get(m));
                    System.out.println("课程学分："+lessonScore.get(m));
                    System.out.println("课程学时："+lessonTime.get(m));}
                else
                    System.out.println("该课程不存在");
              }
            System.out.println("是否继续查询(true（是）/false（否）)");
        }
        System.out.println("查询结束，欢迎再次使用！");
    }
}

