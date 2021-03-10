package Homework;

import java.util.Scanner;

class Address {
    private String country;
    private String province;
    private String city;
    private String street;
    private String zipcode;

    public Address(String country, String province, String city, String street, String zipcode) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getPronince(){
        return province;
    }
    public void setProvince(String province){
        this.province=province;
    }
    public String getCity(){
        return city;
    }
    public void  setCity(String city){
        this.city=city;
    }
    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
     this.street=street;
    }
    public String getZipcode(){
        return zipcode;
    }
    public void setZipcode(String zipcode){
        this.zipcode=zipcode;
    }
    public void print(){
        System.out.println("国家="+this.country);
        System.out.println("省份="+this.province);
        System.out.println("城市="+this.city);
        System.out.println("街道="+this.street);
        System.out.println("邮编="+this.zipcode);
    }

}


public class HomeWork_1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Address one=new Address("中国","云南","昆明","新城街道","655421");
        one.print();
    }
}