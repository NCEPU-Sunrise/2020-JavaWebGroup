//作业4:解析身份证
package week1;
import java.util.Scanner;

public class stringParsing {
    public static void main(String[] args) {
        while(true){
            //录入
            //eg:吕金鸿,450922200109223134
            Scanner sc = new Scanner(System.in);
            String s;
            System.out.println("请输入字符串(格式:姓名,18位身份证号)");
            s = sc.nextLine();
            String buff[] = s.split(",");
            StringBuffer sb;
            //解析姓名
            sb = new StringBuffer(buff[0]);
            //解析身份证号
            String ID = buff[1];
            //解析出生地
            sb.append(birthplaceParsing(buff[1].substring(0,2)));
            //解析出生年月日
            sb.append(buff[1].substring(6,10)+"年"+buff[1].substring(10,12)+"月"+buff[1].substring(12,14)+"日");
            //解析性别
            System.out.println(Integer.parseInt(buff[1].substring(14)+""));
            if(Integer.parseInt(buff[1].substring(14,15)) % 2 == 1)sb.append("男");else sb.append("女");
            //打印
            System.out.println(sb.toString());
        }
    }

    //身份证号前两位解析出生地
    public static String birthplaceParsing(String s){
        String codeAndCity[][] = {{"11", "北京"}, {"12", "天津"},
                {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"},
                {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"},
                {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"},
                {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"},
                {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"},
                {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"},
                {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"},
                {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"},
                {"91", "国外"}};
        for (String[] v:codeAndCity
             ) {
            if(v[0].equals(s))return v[1];
        }
        return "有误";
    }
}
