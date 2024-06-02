
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PRODUCTS {

    private ArrayList<PRODUCT> products;

    public PRODUCTS() {
        this.products = new ArrayList<>();
    }

    public ArrayList<PRODUCT> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<PRODUCT> products) {
        this.products = products;
    }

    public void addProduct(PRODUCT product) {

        for (PRODUCT pro : this.products) {
            if (product.getProduct_name().equals(pro.getProduct_name())) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Σφάλμα");
                alert.setHeaderText("Σφάλμα");
                alert.setContentText(
                        "Το προϊόν υπάρχει ήδη.");
                alert.show();
                return;
            }
        }

        this.products.add(product);
    }

    public void deleteProduct(int productId) {
        for (PRODUCT product : this.products) {
            if (product.getIdProduct() == productId) {
                this.products.remove(product);
                break;
            }
        }
    }
}
