class Address{
    String country;
    String province;
    String city;
    String street;
    String postcode;
    Address(String country,String province, String city,
            String street, String postcode){
        this.country=country;
        this.city=city;
        this.postcode=postcode;
        this.province=province;
        this.street=street;
    }
    String getAdress(){
        return this.country+this.province+this.city+this.street+this.postcode;
    }
}
public class javahomework_5 {
    public static void main(String[] args) {
        Address address=new Address("中国","福建","三明","翠江","365400");
        System.out.println(address.getAdress());
    }
}
