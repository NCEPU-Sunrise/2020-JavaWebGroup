import java.util.Scanner;

public class Homework_4 {
    public static void main(String[] args) throws Exception {
        System.out.println("输入三角形三条边：");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        try{
            if(a+b<=c||a+c<=b||b+c<=a)
            {
                throw new Exception();
            }
            else{
                System.out.println("成功！");

            }

        }catch (Exception e){
            System.out.println("构不成三角形！");

        }
    }
}
