
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class createProgramControllers implements Initializable {

    @FXML
    private Button createProgramButton;

    @FXML
    private Pane createProgramPane;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button finalCreateProgramButton;

    @FXML
    private Label firstLabel;

    @FXML
    private TextArea firstTextField;

    @FXML
    private Label goalLabel;

    @FXML
    private Pane listOfUserPane;

    @FXML
    private Button logoutButton;

    @FXML
    private Label nameOfUserLabel;

    @FXML
    private ImageView photoImageView;

    @FXML
    private Pane previousScreenPane;

    @FXML
    private Button profileButton;

    @FXML
    private Label secondLabel;

    @FXML
    private TextArea secondTextArea;

    @FXML
    private Label thirdLabel;

    @FXML
    private TextArea thirdTextArea;

    @FXML
    private Pane userDetailsPane;

    @FXML
    private Button usersButton;

    @FXML
    private ListView<?> usersListView;


    @FXML
    void userButtonPressed(ActionEvent event) {
    userDetailsPane.setVisible(false);
        previousScreenPane.setVisible(false);
        listOfUserPane.setVisible(true);
        createProgramPane.setVisible(false);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userDetailsPane.setVisible(false);
        previousScreenPane.setVisible(true);
        listOfUserPane.setVisible(false);
        createProgramPane.setVisible(false);

    }

}
