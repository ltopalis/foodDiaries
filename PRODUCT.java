
import java.io.File;

public class PRODUCT {

    private int idProduct;
    private String product_name;
    private double price;
    private int numberOfItems;
    private String description;
    private File image;
    private ADMIN addFrom;
    private String category;

    public PRODUCT(int idProduct, String product_name, double price, int numberOfItems, String description, File image, ADMIN addFrom, String category) {
        this.idProduct = idProduct;
        this.product_name = product_name;
        this.price = price;
        this.numberOfItems = numberOfItems;
        this.description = description;
        this.image = image;
        this.addFrom = addFrom;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public ADMIN getAddFrom() {
        return addFrom;
    }

    public void setAddFrom(ADMIN addFrom) {
        this.addFrom = addFrom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
