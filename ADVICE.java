
public class ADVICE {

    private int idAdvice;
    private EXPERT toExpert;
    private String adviceMessage;
    private USER forUser;
	private DOCTOR fromDoctor;

    public ADVICE(int idAdvice, EXPERT toExpert, String adviceMessage, USER forUser, DOCTOR fromDoctor) {
        this.idAdvice = idAdvice;
        this.toExpert = toExpert;
        this.adviceMessage = adviceMessage;
        this.forUser = forUser;
		this.fromDoctor = fromDoctor;
    }

    public int getIdAdvice() {
        return this.idAdvice;
    }

    public void setIdAdvice(int id) {
        this.idAdvice = id;
    }

    public EXPERT getToExpert() {
        return this.toExpert;
    }

    public void setToExpert(EXPERT toExpert) {
        this.toExpert = toExpert;
    }

    public String getAdviceMessage() {
        return this.adviceMessage;
    }

    public void setAdviceMessage(String advice) {
        this.adviceMessage = advice;
    }

    public USER getForUser() {
        return this.forUser;
    }

    public void setForUser(USER forUser) {
        this.forUser = forUser;
    }

	public DOCTOR getFromDoctor() {
		return fromDoctor;
	}

	public void setFromDoctor(DOCTOR fromDoctor) {
		this.fromDoctor = fromDoctor;
	}

}
