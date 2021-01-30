import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        boolean flag = true;
        int i;
        String  namenum,number =null,name=null ,borncity =null;
        while(flag) {
            System.out.println("请输入姓名和身份证号（以逗号分隔）：");
            Scanner sc = new Scanner(System.in);
            namenum = sc.nextLine();
            //判断输入字符串是否含有逗号
            while (namenum.indexOf(',') == -1 && namenum.indexOf('，') == -1) {
                System.out.println("请用逗号分隔姓名和身份证号!");
                namenum = sc.nextLine();
            }
            //将都好所在位置赋值给 comma
            int comma = namenum.indexOf(',') > namenum.indexOf('，') ? namenum.indexOf(',') : namenum.indexOf('，');
            //筛选出姓名
            name = namenum.substring(0, comma);
            //筛选出身份证号
            number = namenum.substring(comma + 1).trim();
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
            String citycode = number.substring(0, 2);
            for (i = 0; i < codeAndCity.length; i++) {
                if (codeAndCity[i][0].equals(citycode)) {
                    borncity = codeAndCity[i][1];
                    break;
                }
            }
            if (i == codeAndCity.length || number.length() != 18) {
                System.out.println("身份证号不存在，请重新输入！");
            }
            else
                flag = false;
        }
            String gender;
            int gendarnum = Integer.parseInt(number.substring(16, 17));
            if (gendarnum % 2 == 0)
                gender = "女";
            else
                gender = "男";
            int year = Integer.parseInt(number.substring(6, 10));
            int month = Integer.parseInt(number.substring(10, 12));
            int day = Integer.parseInt(number.substring(12, 14));
            StringBuffer stringbuffer = new StringBuffer("姓名：" + name + "  出生地：" + borncity);
            stringbuffer.append("  出生年月日：" + year + "年" + month + "月" + day + "日");
            System.out.println(stringbuffer);
        }
    }

