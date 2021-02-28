public class Assignment5 {
    public static void main(String[] args) {
        Address a = new Address("中国","北京","朝阳","呼家楼",10026);
        a.print();
    }

}
class Address{
 String nation,shengfen,city,street;
 int code;
public Address(String nation,String shengfen,String city,String street,int code){
this.nation = nation;
this.shengfen = shengfen;
this.city = city;
this.street = street;
this.code = code;
    }


public void print(){
System.out.println("国家：" + nation);
System.out.println("省份：" + shengfen);
System.out.println("城市：" + city);
System.out.println("街道：" + street);
System.out.println("邮编：" + code);
}

}
