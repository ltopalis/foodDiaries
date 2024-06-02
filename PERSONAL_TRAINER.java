
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PERSONAL_TRAINER extends TRAINER {

    private ArrayList<APPOINTMENT> appointments = new ArrayList<>();
    private double price;
    private String city;

    public PERSONAL_TRAINER(String email, String name, String lastname, String phoneNumber, String dateTime, boolean isFree, String city, double price) {
        super(name, lastname, email, null, phoneNumber);
        this.price = price;
        this.city = city;
        appointments.add(new APPOINTMENT(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), isFree));
    }

    public PERSONAL_TRAINER(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages, ADDRESS address, ArrayList<APPOINTMENT> appointments) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name, salary, degreeFile, acceptedBy, users, messages, address);
        this.appointments = appointments;
    }

    public PERSONAL_TRAINER(String name, String lastname, String Email, String Password, String phone_number, ArrayList<APPOINTMENT> appointments) {
        super(name, lastname, Email, Password, phone_number);
        this.appointments = appointments;
    }

    public PERSONAL_TRAINER(String email, String name, String lastname) {
        super(email, name, lastname);
    }

    public ArrayList<APPOINTMENT> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<APPOINTMENT> appointments) {
        this.appointments = appointments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastname;
    }

}
