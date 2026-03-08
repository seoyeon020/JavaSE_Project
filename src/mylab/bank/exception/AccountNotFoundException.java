package mylab.bank.exception;

public class AccountNotFoundException extends Exception {
	//계좌를 찾을 수 없을 때
	public AccountNotFoundException(String message) {
		super(message);
	}

}
