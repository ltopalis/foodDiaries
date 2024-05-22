package classMessage;

public class MESSAGE {
	protected String message;
	protected PERSON sender;
	protected LocalDateTime time;
	
	public MESSAGE(String message, PERSON sender, LocalDateTime time) {
		this.message = message;
		this.sender = sender;
		this.time = time;
	}

	public String getMessage() {
		return this.message;
	}
	
	public void setMessage() {
		return this.message;
	}
	
	public PERSON getSender() {
		return this.sender;
	}
	
	public void setSender() {
		return this.sender;
	}
	
	public LocalDateTime getTime() {
		return this.time;
	}
	
	public void setTime() {
		return this.time;
	}
}
