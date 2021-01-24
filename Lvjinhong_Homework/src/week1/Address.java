//作业5:构造地址类
package week1;

public class Address {
    String country;     //国家
    String province;    //省份
    String city;        //城市
    String street;      //街道
    String postCode;    //邮编

    public Address(){}

    public Address(String country,String province,String city,String street,String postCode){
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String getCity(){
        return city;
    }

    public String getPostCode(){
        return postCode;
    }

    public String getProvince(){
        return province;
    }

    public String getStreet(){
        return street;
    }

    public String getCountry(){
        return country;
    }

    public String infoAddress(){
        String s = country + "-" + province + "-" + city + "-" + street + "-" + postCode;
        return s;
    }
}
