package classAdvice;

public class ADVICE {
	protected int idAdvice;
	protected EXPERT toExpert;
	protected String adviceMessage;
	protected USER toUser;
	
	public ADVICE(int idAdvice, EXPERT toExpert, String adviceMessage , USER toUser) {
		this.idAdvice = idAdvice;
		this.toExpert = toExpert;
		this.adviceMessage = adviceMessage;
		this.toUser = toUser;
	}

	public int getIdAdvice() {
		return this.idAdvice;
	}
	
	public void setIdAdvice() {
		return this.idAdvice;
	}
	
	public EXPERT getToExpert() {
		return this.toExpert;
	}
	
	public void setToExpert() {
		return this.toExpert;
	}
	
	public String getAdviceMessage() {
		return this.adviceMessage;
	}
	
	public void setAdviceMessage() {
		return this.adviceMessage;
	}
	
	public USER getToUser() {
		return this.toUser;
	}
	
	public void setToUser() {
		return this.toUser;
	}
}
