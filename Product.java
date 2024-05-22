
abstract class Product {
    protected int idProduct;
    protected String product_name;
    protected double price;
    protected int numberOfItems;
    protected String description;
    protected String image; 
    protected Admin addFrom;
     
    public Product(int idProduct, String product_name, double price, int numberOfItems, String description, String image, Admin addFrom){
        this.idProduct= idProduct;
        this.product_name=product_name;
        this.price=price;
        this.numberOfItems= numberOfItems;
        this.description=description;
        this.image=image;
        this.addFrom= new Admin(name,  lastname,  Email, Password,  phone_number, id,  amount, idWallet);
    }
public String getProduct_name(){
return this.product_name;

}

public String setProduct_name(String product_name){
this.product_name=product_name;

}

public double getPrice(){
return this.price;

}

public String setPrice(double price){
this.price=price;

}


public String getDescription(){
return this.description;

}

public String setDescription(String description){
this.description=description;

}
public int getnumberOfItems(){
return this.numberOfItems;

}

public int setnumberOfItems(int numberOfItems){
this.numberOfItems=numberOfItems;

}

}

 