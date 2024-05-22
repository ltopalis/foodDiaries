import java.util.List;

public class ProductList{
    List<Product> P;
    Product pr;
    
    ProductList(){
        P=new List<Product>();
    }
    
    ProductList (List<Product> P1, Product pr){
        P=P1;
        this.pr=pr;
        
    }
    
     
    void add(Product pr){
        P.add(pr);
    }
    
    List<Product> getAll(){
        return P;
    }
    
    void del(Product pr){
        P.remove(pr);
    }
    public void createProduct(Product pr){
        this.product=pr;
}
}