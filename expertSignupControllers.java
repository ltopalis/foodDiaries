import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class expertSignupControllers implements Initializable {

    @FXML
    private Button FilechooserButton;

    @FXML
    private MenuItem DieticianMenuItem;

    @FXML
    private MenuItem TrainerMenuItem;

    @FXML
    private Pane certificationPane;

    @FXML
    private PasswordField comfirmPasswordTextFiled;

    @FXML
    private MenuItem doctorMenuItem;

    @FXML
    private TextField emailTextFiled;

    @FXML
    private Button exitButton;

    @FXML
    private Button exitButton2;

    @FXML
    private Pane first_screen;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private PasswordField passwordTextFiled;

    @FXML
    private Pane personalInfoPane;

    @FXML
    private TextField phoneNumberTextFiled;

    @FXML
    private Button signupButton;

    @FXML
    private Button signup_expert;

    @FXML
    private ChoiceBox<String> specializationChoiceBox;

    @FXML
    private Button userInfoButton;

    @FXML
    private Label fileNameLabel;

    private File certification;
    private boolean email_flag = true;
    private FileChooser fileChooser = new FileChooser();

    private void clearAllVariables() {
        comfirmPasswordTextFiled.setText(null);
        emailTextFiled.setText(null);
        firstnameTextField.setText(null);
        lastnameTextField.setText(null);
        passwordTextFiled.setText(null);
        phoneNumberTextFiled.setText(null);
        fileNameLabel.setText(null);
        certification = null;
        email_flag = true;
    }

    @FXML
    void expertSignupButtonPressed(ActionEvent event) {
        certificationPane.setVisible(false);
        personalInfoPane.setVisible(true);
        first_screen.setVisible(false);
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
        if (result.get() == buttonTypeOK)
            System.exit(0);
    }

    @FXML
    void checkUserInfo(ActionEvent event) {
        String name = firstnameTextField.getText().strip();
        String surname = lastnameTextField.getText().strip();
        String email = emailTextFiled.getText().strip();
        String phone = phoneNumberTextFiled.getText().strip();
        String password = passwordTextFiled.getText().strip();
        String checkPassword = comfirmPasswordTextFiled.getText();
        String specialization = specializationChoiceBox.getValue();

        if (name.isBlank() | surname.isBlank() | email.isBlank() | phone.isBlank() | password.isBlank()
                | password.isBlank() | checkPassword.isBlank() | specialization == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Πρέπει να συμπληρωθούν όλα τα πεδία");
            alert.show();
        } else if (!(name.matches("(\\D)+") & surname.matches("(\\D)+"))) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Το ονοματεπώνυμο πρέπει να περιέχει μόνο χαρακτήρες");
            alert.show();
        } else if (!phone.matches("(\\d){10}")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Ο αριθμός τηλεφώνου πρέπει να αποτελέιται από 10 ψηφία");
            alert.show();
        } else if (!email_flag) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Ελέξτε το email που δώσατε");
            alert.show();
        } else if (!password.matches("^[a-zA-Z0-9_]{5,20}$")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Ο κωδικός πρόσβασης πρέπει να αποτελέιται από λατινικά γράμματα, αριθμούς και το _ και το μέγεθος του να είναι από 5 εώς 20 χαρακτήρες");
            alert.show();
        } else if (!password.equals(checkPassword)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Οι κωδικοί πρόσβασης διαφέρουν");
            alert.show();
        } else {
            try (Connection conn = connectDB.getConnection()) {
                String query = "CALL checkNewPerson(?, ?)";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString(1, emailTextFiled.getText());
                stmt.registerOutParameter(2, Types.BOOLEAN);
                stmt.execute();
                boolean checkIfExists = stmt.getBoolean(2);

                if (checkIfExists) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Σφάλμα");
                    alert.setHeaderText("Σφάλμα");
                    alert.setContentText("Ο χρήστης υπάρχει. Κάντε σύνδεση");
                    alert.show();

                    certificationPane.setVisible(false);
                    personalInfoPane.setVisible(false);
                    first_screen.setVisible(true);
                    clearAllVariables();
                } else {
                    personalInfoPane.setVisible(false);
                    certificationPane.setVisible(true);
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

    }

    @FXML
    void chooseFileButtonClicked(MouseEvent event) {
        certification = fileChooser.showOpenDialog(new Stage());
        fileNameLabel.setText(certification.getName());
    }

    void checkEmailAddress(String email) {
        String match = "[a-zA-Z0-9]{4,}@[a-zA-Z]{3,}.[a-zA-Z]{2,}";

        email_flag = true;

        if (!email.matches(match)) {
            email_flag = false;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Ελέξτε το email που δώσατε");
            alert.show();
        }

    }

    @FXML
    void signupButtonClicked(MouseEvent event) {

        try (Connection conn = connectDB.getConnection()) {
            String query = "CALL addExpert(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, emailTextFiled.getText());
            stmt.setString(2, firstnameTextField.getText());
            stmt.setString(3, lastnameTextField.getText());
            stmt.setString(4, passwordTextFiled.getText());

            switch (specializationChoiceBox.getValue()) {
                case "Γυμναστής":
                    stmt.setString(5, "Trainer");
                    break;
                case "Διατροφολόγος":
                    stmt.setString(5, "DIETICIAN");
                    break;
                case "Γιατρός":
                    stmt.setString(5, "Doctor");
                    break;
            }

            stmt.setBlob(6, new FileInputStream(certification));
            stmt.execute();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Επιβεβαίωση");
            alert.setHeaderText("Επιτυχής Εγγραφή");
            alert.setContentText("Τα δεδομένα αποθηκεύτηκαν με επιτυχία");
            alert.show();

            certificationPane.setVisible(false);
            personalInfoPane.setVisible(false);
            first_screen.setVisible(true);
            clearAllVariables();

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την αποθήκευση των δεδομένων σας. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά.");
            alert.show();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Επιλέξτε αρχείο με το πιστοποιητικό σας");
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailTextFiled.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                checkEmailAddress(emailTextFiled.getText());
        });

        String[] specialization = { "Γυμναστής", "Διατροφολόγος", "Γιατρός" };
        specializationChoiceBox.getItems().addAll(specialization);

        fileChooser.setInitialDirectory(null);
    }

}
