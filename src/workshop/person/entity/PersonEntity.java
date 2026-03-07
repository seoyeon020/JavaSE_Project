package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn; // 주민번호
	private String address;
	private String phone;

	//default constructor 기본 생성자
	public PersonEntity() {
		
	}

	//overloaded constructor 중복 정의 
	public PersonEntity(String name, String ssn, String address, String phone) {
//		this.name = name;
//		this.ssn = ssn;
//		this.address = address;
//		this.phone = phone;
		setSsn(ssn);
		setName(name);
		setAddress(address);
		setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) { //주민번호 숫자에 따라 성별 나오게 함 
		this.ssn = ssn;
		//0508073347558
		char genderNum = ssn.charAt(6); //주민번호 6번째 자리에 따라서 
		if(genderNum == '1' || genderNum == '3') {
			//this.gender = '남';
			setGender('남');
		}else {
			setGender('여');
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
}