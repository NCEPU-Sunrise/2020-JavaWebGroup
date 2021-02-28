package practice;/*
 *
 *
 *
 */
class person{
    private String name;
    private int age;
    private char sex;
    void setName(String name){
        if(name == null || name.isEmpty() ){
            System.out.println("名字无效");
            return;
        }
        this.name = name;
    }
    void setAge(int age){
        if(age <0 || age >100 ){
            System.out.println("年龄无效");
            return;
        }
        this.age = age;
    }
    void setSex(char sex){
        if(sex == '男' || sex == '女' ){
            this.sex = sex ;
            return;
        }
        System.out.println("性别无效");
    }
    String getInfo() {
        String info;
        info = "姓名为" + name + "年龄为" + age + "性别为" + sex;
        return info;
    }

}



public class demo21 {
    public static void main(String[] args) {
        person per = new person();
        System.out.println(per.getInfo());
        per.setName ("张三");
        per.setAge (12);
        per.setSex ('女');
        System.out.println(per.getInfo());

    }
}
