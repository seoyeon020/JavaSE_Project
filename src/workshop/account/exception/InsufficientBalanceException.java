package workshop.account.exception;

/*
 * Account의 잔액(balance)이 부족할때 사용되는 사용자정의 Exception 클래스입니다. * 
 */
public class InsufficientBalanceException extends Exception {
	private int currentBalance; //에러났을 때 현재 잔액 표시 
	
	public InsufficientBalanceException(String errMessage, int currentBalance) {
		super(errMessage); //super는 부모 클래스인 Exception 클래스의 것을 가져옴 
		this.currentBalance = currentBalance;
	}
	
	public int getCurrentBalance() { //getter 메서드 
		return currentBalance;
	}
}
