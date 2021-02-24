package week1;

//编写并测试一个代表地址的 Address类，地址信息由国家、省份、城市、街道、邮编组成，并可以返回完整的地址信息。
class Address {
	private String countryString;
	private String provinceString;
	private String cityString;
	private String streetString;
	private int postcodeString;
	public Address(String countryString, String provinceString, String cityString, String streetString, int postcodeString) {
		// TODO Auto-generated constructor stub
		this.countryString = countryString;
		this.provinceString = provinceString;
		this.provinceString = provinceString;
		this.cityString = cityString;
		this.streetString = streetString;
		this.postcodeString = postcodeString;
	}
	/**
	 * @return the countryString
	 */
	public String getCountryString() {
		return countryString;
	}
	/**
	 * @param countryString the countryString to set
	 */
	public void setCountryString(String countryString) {
		this.countryString = countryString;
	}
	/**
	 * @return the provinceString
	 */
	public String getProvinceString() {
		return provinceString;
	}
	/**
	 * @param provinceString the provinceString to set
	 */
	public void setProvinceString(String provinceString) {
		this.provinceString = provinceString;
	}
	/**
	 * @return the cityString
	 */
	public String getCityString() {
		return cityString;
	}
	/**
	 * @param cityString the cityString to set
	 */
	public void setCityString(String cityString) {
		this.cityString = cityString;
	}
	/**
	 * @return the streetString
	 */
	public String getStreetString() {
		return streetString;
	}
	/**
	 * @param streetString the streetString to set
	 */
	public void setStreetString(String streetString) {
		this.streetString = streetString;
	}
	/**
	 * @return the postcodeString
	 */
	public int getPostcodeString() {
		return postcodeString;
	}
	/**
	 * @param postcodeString the postcodeString to set
	 */
	public void setPostcodeString(int postcodeString) {
		this.postcodeString = postcodeString;
	}
	public void print() {
		
		System.out.println(this.countryString+" "+this.provinceString+" "+this.cityString+" "+this.streetString+" "+this.postcodeString);
	}
}

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Address address1 = new Address("中国","湖北省","武汉市","光谷大道",123);
        Address address2 = new Address("中国","湖南省","长沙市","解放西路",456);
        address1.print();
        address2.print();
	}

}
