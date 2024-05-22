import java.util.List;
public class User extends PERSON{
    List<String> Or = new List<>();
    protected String city;
    protected String address;
    protected String weight;
    protected String height;
    //protected Doctor doctor;
    //protected Dietician dietician;
    //protected Trainer trainer;
    Product pr;
    
    public User(String name, String lastname, String Email, String Password, String phone_number, int id, float amount, int idWallet, Product pr){
    super( name,  lastname,  Email, Password,  phone_number,  id,  amount, idWallet, pr);
    this.city=city;
    this.address=address;
    this.weight=weight;
    this.height=height;
    }
    public void purchaseProducts(){
     Or.add(pr);
     System.out.println(Or);
        }
    }


