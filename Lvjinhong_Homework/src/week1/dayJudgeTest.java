package week1;

public class dayJudgeTest {
    public static void main(String[] args) {
        int x = new dayJudge().dayJudge(2021,1,23);
        String s;
        if(x == 0)s = "星期六";
        else if(x == 1)s = "星期天";
        else if(x == 2)s = "星期一";
        else if(x == 3)s = "星期二";
        else if(x == 4)s = "星期三";
        else if(x == 5)s = "星期四";
        else s = "星期五";
        System.out.println(s);
    }
}
