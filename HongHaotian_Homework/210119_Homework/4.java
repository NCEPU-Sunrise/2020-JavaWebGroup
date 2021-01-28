import java.util.Scanner;
class homework1_4 {
    public static void main(String[] args) {
        String str2="123";
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
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            str2 = scan.nextLine();
        }
        scan.close();
        int i=0;
        for(i=0;i< str2.length();i++) if (str2.charAt(i)>='0'&&str2.charAt(i)<='9') break;
        StringBuffer sBuffer = new StringBuffer(str2.substring(0,i)+",");
        for(int j=0;j<codeAndCity.length;j++) if(codeAndCity[j][0].equals(str2.substring(i,i+2))) sBuffer.append(codeAndCity[j][1]+",");
        sBuffer.append(str2.substring(i+6,i+14)+",");
        if((str2.charAt(i+16)-48)%2==0) sBuffer.append("女");
        else sBuffer.append("男");
        System.out.println(sBuffer);
    }
}