/*��д������һ�������ַ�� Address�࣬��ַ��Ϣ�ɹ��ҡ�ʡ�ݡ����С��ֵ����ʱ���ɣ������Է��������ĵ�ַ��Ϣ*/
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
		Address address = new Address("�й�", "������", "��ƽ��", "��ũ·2��", "102206");
		System.out.println(address.info());
	}

}
