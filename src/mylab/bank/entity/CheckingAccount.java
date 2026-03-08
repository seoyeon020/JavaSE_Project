package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	//체킹 계좌를 표현하는 클래스
	private double withdrawalLimit; //출금 한도 
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	//출금 시 한도 초과 검사 
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + 
				", 잔액: " + balance + "원, 출금 한도: " + withdrawalLimit + "원";
	}

}
