import java.io.File;
public class Admin extends PERSON{
protected Product product;



public Admin(String name, String lastname, String Email, String Password, String phone_number, int id, float amount, int idWallet,Product product){
super( name,  lastname,  Email, Password,  phone_number, id,  amount, idWallet);
this.product = new product(idProduct, product_name, price, numberOfItems, description, image,addFrom );
}

public void createProduct(Product product){
this.product=product;
P.add(product);
System.out.println(P);
}

            }
            
 

