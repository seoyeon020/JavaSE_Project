package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
	protected String accountNumber; //계좌번호
	protected String ownerName; //소유자 이름 
	protected double balance; //잔액 
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//입금 메서드
	public void deposit(double amount) {
		balance += amount;
	}
	
	//출금 메서드
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("잔액이 부족합니다.");
		}
		balance -= amount;
	}
	
	@Override
	public abstract String toString();

}
