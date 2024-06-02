
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javax.print.DocFlavor;

public class shareAdviceControllers implements Initializable {

    @FXML
    private ComboBox<String> chooseExpertComboBox;

    @FXML
    private ComboBox<String> chosenUserComboBox;

    @FXML
    private Label dieticianNameLabel;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Pane firstScreenPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Pane sendAdvicePane;

    @FXML
    private Pane userProfilePane;

    @FXML
    private Pane usersPane;

    @FXML
    private Label fileNameLabel;

    @FXML
    private TextArea adviceTextArea;

    private DOCTOR doctor;
    private USER chosenUser;

    @FXML
    void chosenUserButtonPressed(ActionEvent event) {
        firstScreenPane.setVisible(false);
        sendAdvicePane.setVisible(false);
        userProfilePane.setVisible(true);
        usersPane.setVisible(false);

        for (USER user : this.doctor.getUsers().getUsers()) {
            if ((user.getName() + " " + user.getLastname()).equals(chosenUserComboBox.getValue())) {
                this.chosenUser = user;
            }
        }

        nameLabel.setText(this.chosenUser.getName() + " " + this.chosenUser.getLastname());
        emailLabel.setText(this.chosenUser.getEmail());
        phoneNumberLabel.setText(this.chosenUser.getPhone_number());

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM person WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.chosenUser.getDIETICIAN().getEmail());

            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String name = results.getString("name");
                String lastname = results.getString("lastname");
                String phoneNumber = results.getString("phone_number");

                dieticianNameLabel.setText(name + " " + lastname);

                this.chosenUser.getDIETICIAN().setName(name);
                this.chosenUser.getDIETICIAN().setLastname(lastname);
                this.chosenUser.getDIETICIAN().setPhone_number(phoneNumber);
            }

            stmt = conn.prepareStatement(query);
            stmt.setString(1, this.chosenUser.getTRAINER().getEmail());

            results = stmt.executeQuery();

            while (results.next()) {
                String name = results.getString("name");
                String lastname = results.getString("lastname");
                String phoneNumber = results.getString("phone_number");

                doctorNameLabel.setText(name + " " + lastname);

                this.chosenUser.getTRAINER().setName(name);
                this.chosenUser.getTRAINER().setLastname(lastname);
                this.chosenUser.getTRAINER().setPhone_number(phoneNumber);
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
    void sendAdviceButtonPressed(ActionEvent event) {

        ADVICE advice;

        if ((this.chosenUser.getTRAINER().getName() + " " + this.chosenUser.getTRAINER().getLastname()).equals(chooseExpertComboBox.getValue())) {
            advice = new ADVICE(0, chosenUser.getTRAINER(), adviceTextArea.getText(), chosenUser, doctor); 
        }else {
            advice = new ADVICE(0, chosenUser.getDIETICIAN(), adviceTextArea.getText(), chosenUser, doctor);
        }

        try (Connection conn = connectDB.getConnection()) {
            String query = "INSERT INTO advice VALUES(null, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, advice.getFromDoctor().getEmail());
            stmt.setString(2, advice.getToExpert().getEmail());
            stmt.setString(3, advice.getForUser().getEmail());
            stmt.setString(4, adviceTextArea.getText());

            stmt.executeUpdate();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Επιβεβαίωση");
            alert.setHeaderText("Επιτυχής Εγγραφή");
            alert.setContentText("Τα δεδομένα αποθηκεύτηκαν με επιτυχία");
            alert.show();

            adviceTextArea.setText("");

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την επικοινωνία με την βάση. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά.");
            alert.show();
        }

    }

    @FXML
    void shareAdviceButtonPressed(ActionEvent event) {
        firstScreenPane.setVisible(false);
        sendAdvicePane.setVisible(true);
        userProfilePane.setVisible(false);
        usersPane.setVisible(false);

        chooseExpertComboBox.getItems().add(this.chosenUser.getDIETICIAN().getName() + " " + this.chosenUser.getDIETICIAN().getLastname());
        chooseExpertComboBox.getItems().add(this.chosenUser.getTRAINER().getName() + " " + this.chosenUser.getTRAINER().getLastname());
    }

    @FXML
    void usersButtonPressed(ActionEvent event) {

        firstScreenPane.setVisible(false);
        sendAdvicePane.setVisible(false);
        userProfilePane.setVisible(false);
        usersPane.setVisible(true);

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM user JOIN person ON user.user_email = person.email WHERE doctor = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.doctor.getEmail());

            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String email = results.getString("email");
                String name = results.getString("name");
                String lastname = results.getString("lastname");
                String phoneNumber = results.getString("phone_number");
                String nutritionGoal = results.getString("nutritioan_goal");
                String trainingGoal = results.getString("training_goal");
                String trainer = results.getString("trainer");
                String nutritionist = results.getString("nutritionist");

                USER user = new USER(name, lastname, email, null, phoneNumber);
                user.setNutrition_goal(nutritionGoal);
                user.setTraining_goal(trainingGoal);
                user.setTRAINER(new TRAINER(trainer, null, null));
                user.setDIETICIAN(new DIETICIAN(nutritionist, null, null));

                this.doctor.getUsers().getUsers().add(user);
            }

            for (USER user : this.doctor.getUsers().getUsers()) {
                chosenUserComboBox.getItems().add(user.getName() + " " + user.getLastname());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstScreenPane.setVisible(true);
        sendAdvicePane.setVisible(false);
        userProfilePane.setVisible(false);
        usersPane.setVisible(false);

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM person WHERE email = 'lucifer@gmail.com'";

            Statement st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                this.doctor = new DOCTOR(result.getString("name"), result.getString("lastname"), result.getString("email"), result.getString("password"), result.getString("phone_number"));
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
