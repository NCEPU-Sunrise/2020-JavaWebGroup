package demo3;/*
 *
 *
 *
 */

class person {
    private String name;
    private int age;
    private char sex = '男';

    void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("名字无效");
            return;
        }
        this.name = name;
    }

    void setAge(int age) {
        if (age < 0 || age > 100) {
            System.out.println("年龄无效");
            return;
        }
        this.age = age;
    }

    void setSex(char sex) {
        if (sex == '男' || sex == '女') {
            this.sex = sex;

        }
       else System.out.println("性别无效");
    }
    String getInfo(){
        String info;
        info = "姓名为：" + name + "年龄为："+ age + "性别为："  + sex;
        return info;
    }

    void setInfo(String name, int age) {
        setName(name);
        setAge(age);
    }

    void setInfo(String name, int age, char sex) {
        setName(name);
        setAge(age);
        setSex(sex);
    }
}

public class demo32 {
    public static void main(String[] args) {
        person per1 = new person();
        person per2 = new person();
        per1.setInfo("Tom" , 12);
        per2.setInfo("Sally" , 20 , '女');
        System.out.println(per1.getInfo());
        System.out.println(per2.getInfo());


    }
}



