import java.util.List;


abstract class Order{
    
    protected int idOrder;
    protected String dateOrder;
    protected String dateDelivery;
    protected String city;
    protected String address;
    protected long priceOfTheOrder;
    protected List<Product> P;
    protected String state;
    protected User receiver;
    protected Product pr; 
    
    
    Order(int idOrder, String dateOrder, String dateDelivery, long priceOfTheOrder, List<Product> P, String state, 
    String city, String address,User receiver, Product pr){
        this.idOrder=idOrder;
        this.dateOrder=dateOrder;
        this.dateDelivery=dateDelivery;
        this.priceOfTheOrder=priceOfTheOrder;
        this.P=P;
        this.state=state;
        this.city=city;
        this.address=address;
        
        this.receiver=receiver;
    }
    
    public void setAddresFromReceiver(){
        
        this.city=receiver.city;
        this.address=receiver.address;
        
        
    }
    
    public String getState(){
        return this.state;
    
    }
    
    public String setState(String state){
        this.state=state;
    
    }
    public void addProduct(){
        List<Product> P = new List<>();
        List.add(pr);
    }
    public void cancelOrder() { 
        cancelled = true;  
    }
    
   




}