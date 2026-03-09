package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.*;

public class Bank {
	//은행 시스템, 계좌 생성과 관리 담당 
	private List<Account> accounts; //은행에서 관리하는 계좌 목록 
	private int nextAccountNumber = 1000; //새계좌 생성시 부여할 다음 계좌번호 
	
	public Bank() { //계좌를 저장할 리스트 객체 생성 
		this.accounts = new ArrayList<>();
	}
	
	//저축 계좌 생성 메서드 
	public String createSavingsAccount(String name, double balance, double interestRate) {
		String accNum = "AC" + nextAccountNumber++; //계좌번호 생성 
		accounts.add(new SavingsAccount(accNum, name, balance, interestRate));
		return accNum;
	}
	
	//체킹 계좌 생성 메서드 
	public String createCheckingAccount(String name, double balance, double limit) {
		String accNum = "AC" + nextAccountNumber++;
		accounts.add(new CheckingAccount(accNum, name, balance, limit));
		return accNum;
	}
	
	//계좌 조회 메서드 
	public Account findAccount(String accNum) throws AccountNotFoundException {
		for (Account acc : accounts) {
			//입력받은 accNum과 실제(getAccountNumber)가 같은지 확인 
			if (acc.getAccountNumber().equals(accNum)) return acc;
		}
		throw new AccountNotFoundException("계좌번호 " + accNum+ "에 해당하는 계좌를 찾을 수 없습니다.");
	}
	
	//계좌 이체 메서드 
	//fromNum: 송신 계좌번호, toNum: 수신 계좌번호 
	public void transfer(String fromNum, String toNum, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account from = findAccount(fromNum);
		Account to = findAccount(toNum);
		
		from.withdraw(amount); //출금
		to.deposit(amount); //입금
		
		System.out.println(amount + "원이 " + fromNum + "에서 " + toNum + "로 송금되었습니다.");
	}
	
	//모든 계좌 목록 
	public void printAllAccounts() {
		for (Account acc : accounts) {
			System.out.println(acc.toString());
		}
	}
}
