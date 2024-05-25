
import java.io.File;

public class DOCTOR extends EXPERT {

    public DOCTOR(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name, salary, degreeFile, acceptedBy, users, messages);
    }

    public DOCTOR(String name, String lastname, String Email, String Password, String phone_number) {
        super(name, lastname, Email, Password, phone_number, 0, 0, null, null, null, null, 0, null, 0, null, null, null, null);
    }

    public DOCTOR(String email, String name, String lastname) {
        super(email, name, lastname);
    }

}
