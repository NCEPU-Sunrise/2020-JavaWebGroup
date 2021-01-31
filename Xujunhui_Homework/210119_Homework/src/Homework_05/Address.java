package Homework_05;

public class Address {
	String country,province,city,street,postcode;
	public Address(String country,String province,String city,String street,String postcode) {
		// TODO Auto-generated constructor stub
		this.country=country;
		this.province=province;
		this.city=city;
		this.street=street;
		this.postcode=postcode;
	}
	String getInfo() {
		String str=country+" "+province+" "+city+" "+street+" 邮编："+postcode;
		return str;
	}
}
