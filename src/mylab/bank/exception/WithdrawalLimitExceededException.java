package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException{
	//출금 한도를 초과할 때 
	public WithdrawalLimitExceededException(String message) {
		super(message);
	}
}
