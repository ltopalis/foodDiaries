
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class createProductControllers implements Initializable {

    @FXML
    private Pane addProductPane;

    @FXML
    private TextField amountTextField;

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private Button choosePhotoButton;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Pane eshopChoicesPane;

    @FXML
    private Button exitButton;

    @FXML
    private Pane firstScreen;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label photoNameLabel;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button shopButton;

    private PRODUCTS allProducts = new PRODUCTS();
    private FileChooser fileChooser = new FileChooser();
    private File photo;
    private ADMIN admin;

    @FXML
    void eshopButtonPressed(ActionEvent event) {
        firstScreen.setVisible(false);
        eshopChoicesPane.setVisible(true);
        addProductPane.setVisible(false);
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
    void addProductButtonPressed(ActionEvent event) {
        firstScreen.setVisible(false);
        eshopChoicesPane.setVisible(false);
        addProductPane.setVisible(true);

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM product";

            Statement st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                double price = result.getDouble("price");
                String added_by = result.getString("added_by");
                String category;

                if (result.getString("category").equals("Γυμναστική")) {
                    category = "GYM"; 
                }else {
                    category = "FOODS";
                }

                ADMIN added = new ADMIN(null, null, added_by, null, null);
                PRODUCT prod = new PRODUCT(id, name, price, id, description, null, added, category);
                this.allProducts.addProduct(prod);
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
    void createProductButtonPressed(ActionEvent event) {
        try {
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int amount = Integer.parseInt(amountTextField.getText());
            String description = descriptionTextArea.getText();
            String category;

            if (categoryChoiceBox.getValue().equals("Γυμναστική")) {
                category = "GYM"; 
            }else {
                category = "FOODS";
            }

            PRODUCT product = new PRODUCT(amount, name, price, amount, description, photo, this.admin, category);
            this.allProducts.addProduct(product);

            try (Connection conn = connectDB.getConnection()) {

                String query = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, allProducts.getProducts().size());
                stmt.setString(2, product.getProduct_name());
                stmt.setString(3, product.getDescription());
                stmt.setDouble(4, product.getPrice());
                stmt.setString(5, product.getAddFrom().getEmail());
                stmt.setBinaryStream(6, new FileInputStream(product.getImage()));
                stmt.setString(7, product.getCategory());

                stmt.executeUpdate();

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Επιβεβαίωση");
                alert.setHeaderText("Επιτυχής Εγγραφή");
                alert.setContentText("Τα δεδομένα αποθηκεύτηκαν με επιτυχία");
                alert.show();

            } catch (SQLException e) {

                System.err.println(e);

            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    void photoChooserButtonPressed(ActionEvent event) {
        try {
            photo = fileChooser.showOpenDialog(new Stage());
            photoNameLabel.setText(photo.getName());
        } catch (NullPointerException e) {
            photoNameLabel.setText(null);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstScreen.setVisible(true);
        eshopChoicesPane.setVisible(false);
        addProductPane.setVisible(false);

        String[] categories = {"Γυμναστική", "Διατροφή"};
        categoryChoiceBox.getItems().addAll(categories);

        fileChooser.setInitialDirectory(null);

        try (Connection conn = connectDB.getConnection()) {
            String query = "SELECT * FROM person WHERE email = 'dimitris@gmail.com'";

            Statement st = conn.createStatement();

            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                this.admin = new ADMIN(result.getString("name"), result.getString("lastname"), result.getString("email"), result.getString("password"), result.getString("phone_number"));
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
