
import java.util.ArrayList;

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
