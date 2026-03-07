package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account extends Object {
	private String custId;
	private String acctId;
	private int balance;
	//위에 extends Object는 원래 생략되어있음, 부모인 Object의 자식이 Account인 것 
	
	//Default Constructor 기본 생성자 
	public Account() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨");
	}
	
	//Constructor Overloading (중복 정의)
	public Account(String custId, String acctId) {
		setCustId(custId);
		setAcctId(acctId);
	}
	
	//setter method ( 멤버변수 값 변경, 값을 변경하는 메서드 ) -> 밑에 입금 메서드와 겹침 
//	private void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId; // 여기서 this의 acctId는 클래스 상단에 선언된 진짜 멤버 변수
		// 오른쪽 acctId는 파라미터 인자로 들어온 acctId임 
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}

	//getter method ( 멤버변수 값 조회, 값을 읽어오는 메서드 )
	public String getCustId() {
		return custId;
	}

	public String getAcctId() {
		return acctId; // 여기 acctId는 클래스 상단에 선언된 멤버 변수를 가리킴 
	}

	public int getBalance() {
		return balance;
	}
	
	//입금 
	public void deposit(int amount) {
		//this.balance = this.balance + amount;
		this.balance += amount;
	}
	
	//출금
	//AccountTest 에서 try/catch 를 하도록 위임하는 것임
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			//Exception을 강제로 발생시킴, throw 클래스 
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재잔액은 = ", balance);
		}
		this.balance -= amount;
	}

	//메서드 재정의 (Overriding) 
	//부모 클래스의 메서드 선언은 반드시 같아야 하고, 구현만 다름
	/* @Override 어노테이션 
	 * - @Target(ElementType.METHOD) 메서드위에 선언하는 어노테이션
	   - @Retention(RetentionPolicy.SOURCE) 컴파일타임에 동작하는 어노테이션
	 */
	@Override
	public String toString() {
		return "Account [고객번호 =" + custId + ", 계좌번호 =" + 
				acctId + ", 잔액 =" + balance + "]";
	}
	
	
	
}
