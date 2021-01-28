/*编写并测试一个代表地址的 Address类，地址信息由国家、省份、城市、街道、邮编组成，并可以返回完整的地址信息*/
class Address {
	private String country;
	private String province;
	private String city;
	private String street;
	private String postcode;

	Address(String country, String province, String city, String street, String postcode) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.postcode = postcode;
	}

	String info() {
		return country + province + city + street + postcode;
	}
}

public class HomeWork_5 {

	public static void main(String[] args) {
		Address address = new Address("中国", "北京市", "昌平区", "北农路2号", "102206");
		System.out.println(address.info());
	}

}
