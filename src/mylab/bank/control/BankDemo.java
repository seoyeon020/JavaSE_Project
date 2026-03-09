package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		try {
			System.out.println("==== 계좌 생성 ====");
			String ac1 = bank.createSavingsAccount("홍길동", 10000, 3);
			System.out.println("저축 계좌가 생성되었습니다: " + bank.findAccount(ac1));
			String ac2 = bank.createCheckingAccount("김철수", 20000, 5000);
			System.out.println("체킹 계좌가 생성되었습니다: " + bank.findAccount(ac2));
			String ac3 = bank.createSavingsAccount("이영희", 30000, 2);
			System.out.println("저축 계좌가 생성되었습니다: " + bank.findAccount(ac3));
			
			System.out.println("\n==== 모든 계좌 목록 ====");
			bank.printAllAccounts();
			System.out.println("===================");
			
			System.out.println("\n==== 입금/출금 테스트 ===="); //홍길동 계좌
			Account hong = bank.findAccount(ac1);
			hong.deposit(5000);
			System.out.println("5000.0원이 입금되었습니다. 이름: " + hong.getOwnerName() + "  현재 잔액: " + hong.getBalance() + "원 ");
			
			Account kim = bank.findAccount(ac2); //김철수 계좌 
			kim.withdraw(3000);
			System.out.println("3000.0원이 출금되었습니다. 이름: " + kim.getOwnerName() + "  현재 잔액: " + kim.getBalance() + "원");
			
			System.out.println("\n==== 이자 적용 테스트 ====");
			((SavingsAccount) hong).applyInterest();
			
			System.out.println("\n==== 계좌 이체 테스트 ====");
			Account lee = bank.findAccount(ac3);
			bank.transfer(ac3, ac2, 5000); //
			
			System.out.println("5000.0원이 출금되었습니다. 이름: " + lee.getOwnerName() + "  현재 잔액: " + lee.getBalance() + "원");
			System.out.println("5000.0원이 입금되었습니다. 이름: " + kim.getOwnerName() + "  현재 잔액: " + kim.getBalance() + "원");
			
			System.out.println("\n==== 모든 계좌 목록 ====");
			bank.printAllAccounts();
			System.out.println("===================");
			
			//예외 발생: 김철수 계좌 5000원 한도 
			bank.findAccount(ac2).withdraw(6000);
			
		} catch (WithdrawalLimitExceededException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
		
		//예외 발생: 존재하지 않는 계좌
		try {
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
		
		
	}

}
