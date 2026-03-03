package workshop.account.entity;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		//Account 객체생성 (Account의 생성자(constructor) 호출)
		Account account = new Account();
		//고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
		account.SetCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("고객번호 : " + account.getCustId());
		System.out.println("계좌번호 : " + account.getAcctId());
		System.out.println("잔액 : " + account.getBalance());
	}
}
