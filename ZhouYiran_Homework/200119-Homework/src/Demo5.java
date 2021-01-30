 class Demo5 {
    public static void main(String[] args) {
        Adress address = new Adress("中国","山东省","淄博市","共青团西路","0533");
        address.print_message();

    }
}
class Adress{
    String country;
    String province;
    String city;
    String street;
    String postcode;
    Adress(String country,String province,String city,String street,String postcode){
        this.country  = country;
        this.province  = province;
        this.city  = city;
        this.street = street;
        this.postcode  = postcode;
    }
    public  void print_message(){
        System.out.println(this.country+this.province+this.city+this.street+this.postcode);
    }
}
