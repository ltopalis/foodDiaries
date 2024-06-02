
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EXPERTS {

    private ArrayList<PERSON> experts = new ArrayList<>();

    public EXPERTS() {
        try (Connection conn = connectDB.getConnection()) {

            String query = "SELECT email, name, lastname, password, phone_number, role FROM person;";

            Statement stmt = conn.createStatement();

            ResultSet person = stmt.executeQuery(query);

            while (person.next()) {

                switch (person.getString("role")) {
                    case "TRAINER" -> {
                        TRAINER newTrainer = new TRAINER(person.getString("name"), person.getString("lastname"), person.getString("email"), person.getString("password"), person.getString("phone_number"));
                        experts.add(newTrainer);
                    }
                    case "DOCTOR" -> {
                        DOCTOR newDoctor = new DOCTOR(person.getString("name"), person.getString("lastname"), person.getString("email"), person.getString("password"), person.getString("phone_number"));
                        experts.add(newDoctor);
                    }
                    case "USER" -> {
                        USER newUser = new USER(person.getString("name"), person.getString("lastname"), person.getString("email"), person.getString("password"), person.getString("phone_number"));
                        experts.add(newUser);
                    }
                    case "ADMIN" -> {
                        ADMIN newAdmin = new ADMIN(person.getString("name"), person.getString("lastname"), person.getString("email"), person.getString("password"), person.getString("phone_number"));
                        experts.add(newAdmin);
                    }
                    case "DIETICIAN" -> {
                        DIETICIAN newDietician = new DIETICIAN(person.getString("name"), person.getString("lastname"), person.getString("email"), person.getString("password"), person.getString("phone_number"));
                        experts.add(newDietician);
                    }
                    default ->
                        throw new AssertionError();
                }
            }

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την αποθήκευση των δεδομένων σας. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά. ");
            alert.show();
        }
    }

    public ArrayList<PERSON> getExperts() {
        return experts;
    }

    public void setExperts(ArrayList<PERSON> experts) {
        this.experts = experts;
    }

    public boolean checkIfExists(String email) {
        for (PERSON per : this.experts) {
            if (per.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

}
