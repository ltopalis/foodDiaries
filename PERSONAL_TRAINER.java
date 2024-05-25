
import java.time.LocalDateTime;
import java.util.*;
import java.io.File;

public class PERSONAL_TRAINER extends TRAINER {

    private ArrayList<LocalDateTime> dates;
    private ArrayList<APPOINTMENT> appointments;

    public PERSONAL_TRAINER(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages, ADDRESS address, ArrayList<LocalDateTime> dates, ArrayList<APPOINTMENT> appointments) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name, salary, degreeFile, acceptedBy, users, messages, address);
        this.dates = dates;
        this.appointments = appointments;
    }

    public PERSONAL_TRAINER(String name, String lastname, String Email, String Password, String phone_number, ArrayList<LocalDateTime> dates, ArrayList<APPOINTMENT> appointments) {
        super(name, lastname, Email, Password, phone_number);
        this.dates = dates;
        this.appointments = appointments;
    }

    public ArrayList<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(ArrayList<LocalDateTime> dates) {
        this.dates = dates;
    }

    public ArrayList<APPOINTMENT> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<APPOINTMENT> appointments) {
        this.appointments = appointments;
    }

    
}
