package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//Default Constructor 기본 생성자
	public Account() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨");
	}
	
	//Constructor Overloading (중복 정의)
	public Account(String custId, String acctId, int balance) {
		setCustId(custId);
		setAcctId(acctId);
		this.balance = balance;
	}
	
	
	//setter method (멤버변수 값 변경)
//	public void setBalance(int balance) {
//		balance = balance;
//	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	

	public void SetCustId(String custId) {
		this.custId = custId;
	}
	
	//getter method (멤버변수 값 조회)
	public String getCustId() {
		return custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	
	public int getBalance() {
		return  balance;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액 부족");
		}
		this.balance -= amount;
	}

}
