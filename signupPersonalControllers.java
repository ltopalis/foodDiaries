
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.management.Query;

public class signupPersonalControllers implements Initializable {

    @FXML
    private DatePicker availableDateDatePicker;

    @FXML
    private TextField cityTextfield;

    @FXML
    private Pane firstScreeenPane;

    @FXML
    private Pane registrationPersonalPane;

    @FXML
    private Pane alreadyPersonalPane;

    @FXML
    private TextField timeTextfield;

    @FXML
    private TextField priceTextField;

    private TRAINER trainer;

    @FXML
    void personalButtonPressed(ActionEvent event) {

        if (this.trainer instanceof TRAINER) {
            firstScreeenPane.setVisible(false);
            registrationPersonalPane.setVisible(true);
            alreadyPersonalPane.setVisible(false);
        } else {
            firstScreeenPane.setVisible(false);
            registrationPersonalPane.setVisible(false);
            alreadyPersonalPane.setVisible(true);
        }
    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Επιβεβαίωση εξόδου");
        alert.setHeaderText("Επιβεβαίωση");
        alert.setContentText("Είστε σίγουροι ότι θέλετε να τερματίσετε την εφαρμογή;");

        ButtonType buttonTypeOK = new ButtonType("Έξοδος", ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Ακύρωση", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeCancel, buttonTypeOK);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK) {
            System.exit(0);
        }
    }

    @FXML
    void registrationButtonPressed(ActionEvent event) {
        LocalDate date = availableDateDatePicker.getValue();
        String city = cityTextfield.getText();
        String time = timeTextfield.getText();
        double price = Double.parseDouble(priceTextField.getText());

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime timeLT = LocalTime.parse(time, timeFormatter);
        LocalDateTime dateTime = LocalDateTime.of(date, timeLT);

        try (Connection conn = connectDB.getConnection()) {
            String query = "INSERT INTO personalTrainer VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.trainer.getEmail());
            stmt.setString(2, city);
            stmt.setDouble(3, price);

            stmt.executeUpdate();

            query = "UPDATE person SET role = 'PERSONAL_TRAINER' WHERE person.email = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, this.trainer.getEmail());

            stmt.executeUpdate();

            query = "INSERT INTO timetable VALUES (?, ?, 1, null, null)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, this.trainer.getEmail());
            stmt.setObject(2, dateTime);

            stmt.executeUpdate();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Επιβεβαίωση");
            alert.setHeaderText("Επιτυχής Εγγραφή");
            alert.setContentText("Τα δεδομένα αποθηκεύτηκαν με επιτυχία");
            alert.show();

            firstScreeenPane.setVisible(false);
            registrationPersonalPane.setVisible(false);
            alreadyPersonalPane.setVisible(true);

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την επικοινωνία με την βάση. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά. " + e);
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstScreeenPane.setVisible(true);
        registrationPersonalPane.setVisible(false);
        alreadyPersonalPane.setVisible(false);

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM person WHERE email = 'george@gmail.com'";

            Statement st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                this.trainer = new TRAINER(result.getString("name"), result.getString("lastname"), result.getString("email"), result.getString("password"), result.getString("phone_number"));
            }

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την επικοινωνία με την βάση. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά.");
            alert.show();
        }
    }

}
