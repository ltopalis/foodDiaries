
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ORDER {

    private int idOrder;
    private LocalDateTime date;
    private float priceOfOrder;
    private PRODUCTS products;
    private String state;
    private USER receiver;
    private ADDRESS shippingAddress;
    private LocalDate deliveryDate;

    public ORDER(int idOrder, LocalDateTime date, float priceOfOrder, PRODUCTS products, String state, USER receiver, ADDRESS shippingAddress, LocalDate deliveryDate) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOfOrder = priceOfOrder;
        this.products = products;
        this.state = state;
        this.receiver = receiver;
        this.shippingAddress = shippingAddress;
        this.deliveryDate = deliveryDate;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public ADDRESS getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ADDRESS shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public float getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setPriceOfOrder(float priceOfOrder) {
        this.priceOfOrder = priceOfOrder;
    }

    public PRODUCTS getProducts() {
        return products;
    }

    public void setProducts(PRODUCTS products) {
        this.products = products;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public USER getReceiver() {
        return receiver;
    }

    public void setReceiver(USER receiver) {
        this.receiver = receiver;
    }

    public void cancelOrder() {
        try(Connection conn = connectDB.getConnection()) {
            this.state = "canceled";

            String query = "UPDATE TABLE order SET status = ? WHERE order_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "canceled");
            stmt.setInt(2, this.idOrder);

            stmt.executeUpdate();
        } catch(SQLException e) {
            System.err.println("ERROR");
        }
    }

}
