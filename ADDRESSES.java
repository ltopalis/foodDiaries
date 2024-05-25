import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ADDRESSES {
    
    private ArrayList<ADDRESS> addresses;

    public ADDRESSES(String email) {
        this.addresses = new ArrayList<>();
        
        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT address_name, address_number, zipCode, country, friendly_name, address_id FROM address WHERE person_id = ?;";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()) {
                String name = result.getString("address_name");
                String number = result.getString("address_number");
                String zip = result.getString("zipCode");
                String country = result.getString("country");
                String friendlyName = result.getString("friendly_name");
                int id = result.getInt("address_id");

                ADDRESS newAddress = new ADDRESS(name, number, zip, country, id, friendlyName);

                this.addresses.add(newAddress);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<ADDRESS> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<ADDRESS> addresses) {
        this.addresses = addresses;
    }

}
