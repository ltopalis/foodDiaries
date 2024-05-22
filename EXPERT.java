package classExpert;

public class EXPERT {
	protected double salary;
	protected String degreeFile;
	protected ADMIN acceptedBy;
	protected ArrayList<USERS> users;
	protected MESSAGES messages;
	protected USER user;
		
	public EXPERT(double salary, String degreeFile, ADMIN acceptedBy, ArrayList<USERS> users, MESSAGES messages, USER user) {
		this.salary = salary;
		this.degreeFile = degree.file;
		this.acceptedBy = acceptedBy;
		this.users = users;
		this.messages = messages;
		this.user = user;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void setSalary() {
		return this.salary;
	}
	
	public String getDegreeFile() {
		return this.degreeFile;
	}
	
	public void setDegreeFile() {
		return this.degreeFile;
	}
	
	public ADMIN getAcceptedBy() {
		return this.acceptedBy;
	}
	
	public void setAcceptedBy() {
		return this.acceptedBy;
	}
	
	public ArrayList<USERS> getUsers() {
		return this.users;
	}
	
	public void setUsers() {
		return this.users;
	}
	
	public MESSAGES getMessages() {
		return this.messages;
	}
	
	public void setMessages() {
		return this.messages;
	}
	
	public USER getUser() {
		return this.user;
	}
	
	public void setUser() {
		return this.user;
	}
	
}

