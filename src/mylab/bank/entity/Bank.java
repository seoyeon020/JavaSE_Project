package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	//은행 시스템, 계좌 생성과 관리 담당 
	private List<Account> accounts; //은행에서 관리하는 계좌 목록 
	private int nextAccountNumber = 1000; //새계좌 생성시 부여할 다음 계좌번호 
	
	public Bank() {
		this.accounts = new ArrayList<>();
	}
	
	public String createSavingsAccount(String name, double balance, double interestRate) {
		String accNum = "AC" + nextAccountNumber++;
		accounts.add(new SavingsAccount(accNum, name, balance, interestRate));
		return accNum;
	}

}
