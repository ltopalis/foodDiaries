import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class expertSignupControllers implements Initializable {

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
    private MenuButton specializationMenuButton;

    @FXML
    private Button userInfoButton;

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
        String specialization = specializationMenuButton.getText();

        if (name.isBlank() | surname.isBlank() | email.isBlank() | phone.isBlank() | password.isBlank()
                | password.isBlank() | checkPassword.isBlank() | specialization.isBlank()) {
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
        } else if (specialization.equals("Ειδικότητα")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Επιλέξτε την ειδικότητα σας");
            alert.show();
        } else {
            try (Connection conn = connectDB.getConnection()) {

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    void checkEmailAddress(String email) {
        String match = "[a-zA-Z0-9]{4,}@[a-zA-Z]{3,}.[a-zA-Z]{2,}";

        if (!email.matches(match)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText("Ελέξτε το email που δώσατε");
            alert.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailTextFiled.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                checkEmailAddress(emailTextFiled.getText());
        });
    }

}
