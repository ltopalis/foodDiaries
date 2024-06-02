
import java.awt.Button;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;

public class buyProductCotrollers implements Initializable {

    @FXML
    private ComboBox<ADDRESS> addressesComboBox;

    @FXML
    private Pane allProductPane;

    @FXML
    private Button buyProductsButton;

    @FXML
    private Pane cartPane;

    @FXML
    private Pane categoriesPane;

    @FXML
    private Button chartButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button exitButton;

    @FXML
    private Pane firstScreenPane;

    @FXML
    private Button gymButton;

    @FXML
    private TextField lastnameTaxtField1;

    @FXML
    private TextField nameTaxtField;

    @FXML
    private Button nextButton;

    @FXML
    private Button nutritionButton;

    @FXML
    private Pane personalDetailsPane;

    @FXML
    private TextField phoneTextField;

    @FXML
    private GridPane productsGridPane;

    @FXML
    private ListView<PRODUCT> productsListCartListView;

    @FXML
    private Button shopButton;

    private PRODUCTS warehouse;

    @FXML
    void buyProductsButtonPressed(ActionEvent event) {

    }

    @FXML
    void chertButtonPressed(ActionEvent event) {
        firstScreenPane.setVisible(false);
        categoriesPane.setVisible(false);
        allProductPane.setVisible(false);
        cartPane.setVisible(true);
        personalDetailsPane.setVisible(false);
    }

    @FXML
    void eshopButtonPressed(ActionEvent event) {
        firstScreenPane.setVisible(false);
        categoriesPane.setVisible(true);
        allProductPane.setVisible(false);
        cartPane.setVisible(false);
        personalDetailsPane.setVisible(false);
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
    void gymButtonPressed(ActionEvent event) {

        try (Connection conn = connectDB.getConnection()) {

            String query = "SELECT * FROM `product` JOIN warehouse on product.id = warehouse.product_id WHERE category = 'GYM';";

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();

            this.warehouse = new PRODUCTS();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                double price = result.getFloat("price");
                BufferedImage image = ImageIO.read(result.getBlob("image").getBinaryStream());
                int value = result.getInt("value");

                PRODUCT pr = new PRODUCT(id, name, price, value, description, null, null, "GYM");
                warehouse.addProduct(pr);
            }

            // for (PRODUCT pr : this.warehouse.getProducts()) {
            //     Pane newPane = new Pane();
            //     // Circle circle = new Circle(50,Color.BLUE);
            //     // newPane.getChildren().add(circle);

            //     // productsGridPane.add(newPane, 0, 0);

            //     firstScreenPane.setVisible(false);
            //     categoriesPane.setVisible(false);
            //     allProductPane.setVisible(true);
            //     cartPane.setVisible(false);
            //     personalDetailsPane.setVisible(false);
            // }

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την αναζήτηση των δεδομένων. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά. " + e);
            alert.show();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    @FXML
    void nextButtonPressed(ActionEvent event) {

    }

    @FXML
    void nutritionButtonPressed(ActionEvent event) {

        try (Connection conn = connectDB.getConnection()) {

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Σφάλμα");
            alert.setHeaderText("Σφάλμα");
            alert.setContentText(
                    "Προέκυψε σφάλμα κατά την αποθήκευση των δεδομένων σας. Παρακαλώ προσπαθήστε ξανά σε λίγα λεπτά.");
            alert.show();
        }

    }

    @FXML
    void productButtonPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstScreenPane.setVisible(true);
        categoriesPane.setVisible(false);
        allProductPane.setVisible(false);
        cartPane.setVisible(false);
        personalDetailsPane.setVisible(false);
    }

}
