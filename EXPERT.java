
import java.io.File;
import java.util.ArrayList;

abstract class EXPERT extends PERSON {

    protected double salary;
    protected File degreeFile;
    protected ADMIN acceptedBy;
    protected USERS users;
    protected MESSAGES messages;
    protected ArrayList<ADVICE> advice;

    public EXPERT(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages, ArrayList<ADVICE> advice) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name);
        this.salary = salary;
        this.degreeFile = degreeFile;
        this.acceptedBy = acceptedBy;
        this.users = users;
        this.messages = messages;
        this.advice = advice;
    }

    public EXPERT(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name);
        this.salary = salary;
        this.degreeFile = degreeFile;
        this.acceptedBy = acceptedBy;
        this.users = users;
        this.messages = messages;
        this.advice = new ArrayList<ADVICE>();
    }

    public EXPERT(String email, String name, String lastname) {
        super(email, name, lastname);
    }

    public EXPERT() {
        super();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public File getDegreeFile() {
        return degreeFile;
    }

    public void setDegreeFile(File degreeFile) {
        this.degreeFile = degreeFile;
    }

    public ADMIN getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(ADMIN acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public USERS getUsers() {
        return users;
    }

    public void setUsers(USERS users) {
        this.users = users;
    }

    public MESSAGES getMessages() {
        return messages;
    }

    public void setMessages(MESSAGES messages) {
        this.messages = messages;
    }

}
