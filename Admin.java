

public class ADMIN extends PERSON {

    public ADMIN(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name);
    }

    public ADMIN(String name, String lastname, String Email, String Password, String phone_number) {
        super(name, lastname, Email, Password, phone_number, 0, 0, null, null, null, null, 0, null);
    }
}
