import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xnhyacinth
 * @date 2021/2/4 - 20:58
 */
public class Assignment4 {
    public static void main(String[] args) {
        System.out.println("请输入形如name-ID（18位）的字符串：");
        Scanner sc = new Scanner(System.in);
        String info = sc.next();
        String[] s = info.split("-");
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
        StringBuffer sb = new StringBuffer("姓名：" + s[0] + ",");
        Pattern p = Pattern.compile("^(\\d{2})(\\d{4})(\\d{8})(\\d{2})(\\d{1})(\\d{1})");
        Matcher m = p.matcher(s[1]);
        String a = null;
        String area = null;
        String bith = null;
        String isSex = null;
        String sex = null;
        if(m.find()){
            a = m.group(1);
            bith = m.group(3);
            isSex = m.group(5);
        }
        for (int i = 0; i < codeAndCity.length; i++) {
            if (a.equals(codeAndCity[i][0]))
                area = codeAndCity[i][1];
        }
        sb.append("出生地：" + area + ",");
        sb.append("出生年月日：" + bith + ",");
        if (Integer.parseInt(isSex) % 2 == 0)
            sex = "女";
        else
            sex = "男";
        sb.append("性别：" + sex);
        System.out.println(sb.toString());
    }
}
