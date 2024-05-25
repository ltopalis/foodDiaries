
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.*; 

public class TRAINER extends EXPERT {

    protected ADDRESS address;

    public TRAINER(String name, String lastname, String Email, String Password, String phone_number) {
        super(name, lastname, Email, Password, phone_number, 0, 0, null, null, null, null, 0, null, 0, null, null, null, null);

    }

    public TRAINER(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, double salary, File degreeFile, ADMIN acceptedBy, USERS users, MESSAGES messages, ADDRESS address) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name, salary, degreeFile, acceptedBy, users, messages);
        this.address = address;
    }

    public TRAINER(String email, String name, String lastname) {
        super(email, name, lastname);
    }

    public ADDRESS getAddress() {
        return address;
    }

    public void setAddress(ADDRESS address) {
        this.address = address;
    }

    public void createProgram(USER user, String breakfast, String lunch, String dinner) {
        PROGRAM newProgram = new PROGRAM(user, this, LocalDateTime.now(), breakfast, lunch, dinner);

        try(Connection conn = connectDB.getConnection()) {

            newProgram.save(conn);

        } catch(SQLException e) {
            System.err.println(e);
        }

    }
}
