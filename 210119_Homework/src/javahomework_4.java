import java.util.Scanner;

public class javahomework_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入字符串：姓名，身份证号");
        String string=sc.next();
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

        String []the_split=string.split(",");
        String bString=the_split[1].substring(0,2);
        int yearString=Integer.valueOf(the_split[1].substring(6,10));
        int monthString=Integer.valueOf(the_split[1].substring(10,12));
        int dateString=Integer.valueOf(the_split[1].substring(12,14));
        int genderString=Integer.valueOf(the_split[1].substring(16,17));
        String gender=null;
        if (genderString%2==0){
            gender="女";
        }
        else {
            gender="男";
        }
        String province=null;
        for(int i=0;i<35;i++){
            if(codeAndCity[i][0].equals(bString)){
                province=codeAndCity[i][1];
            }
        }
        System.out.println(province);


        StringBuffer stringBuffer=new StringBuffer("");
        stringBuffer.append(the_split[0]+","+gender+"出生于"+province+"生日为"+yearString+"年"+monthString+"月"+dateString+"日");
        System.out.println(stringBuffer);


    }


}
