import java.util.List;

public class OrderList{
    List<Order> Or;
    Product pr;
    
    OrderList(){
    P=new List<Order>();
    }
    
    OrderList (List<Order> P1, Product pr){
    P=P1;
    this.pr=pr;
    
    }
    
    
    void add(Product pr){//pr=mia paraggelia
        Or.add(pr);
    }

    List<Order> getAll(){
        return Or;
    }
    
    void del(Order Or){
        Or.remove(pr);
    }

}

