import java.util.Scanner;
class homework1_1 {
    public static void main(String[] args) {
        int y=0,m=0,d=0,t=6;
        Scanner scan = new Scanner(System.in);
        System.out.println("请分别输入年月日:");
        if (scan.hasNextInt()) {
                y = scan.nextInt();
        }
        if (scan.hasNextInt()) {
                m = scan.nextInt();
        }
        if (scan.hasNextInt()) {
                d = scan.nextInt();
        }
        scan.close();
        int i=2000;
        while(i<y){
            if(i%4==0&&i%100!=0||i%400==0) t+=366;
            else t+=365;
            i++;
        }
        if(i%4==0&&i%100!=0||i%400==0) t++;
        switch(m){
            case 12:t+=30;
            case 11:t+=31;
            case 10:t+=30;
            case 9:t+=31;
            case 8:t+=31;
            case 7:t+=30;
            case 6:t+=31;
            case 5:t+=30;
            case 4:t+=31;
            case 3:t+=28;
            case 2:t+=31;
            case 1:break;
        }
        t+=d;
        t--;
        t=t%7;
        switch(t){
            case 0:System.out.println("星期天");break;
            case 1:System.out.println("星期一");break;
            case 2:System.out.println("星期二");break;
            case 3:System.out.println("星期三");break;
            case 4:System.out.println("星期四");break;
            case 5:System.out.println("星期五");break;
            case 6:System.out.println("星期六");break;
        }
    }
}