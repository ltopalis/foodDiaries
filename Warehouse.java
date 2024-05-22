import java.util.List;  
abstract class Warehouse{
    
protected List<Product> P;
int N;//megethos pinaka
List<Product> P = new List<Product>(N);  

Warehouse(List<Product> P){
this.P=P;
}

public void reduceProducts(){
P.remove(N-1);
   System.out.println("\nAfter removing the element the size of the List is: " + P.size());  
      // Showing all the elements in the ArrayList  
      for (String name : P) {  
         System.out.println("Name is: " + product.product_name);  
      }
}


public void increaseProducts(){
P.add(N-1);
   System.out.println("\nAfter adding the element the size of the List is: " + P.size());  
      // Showing all the elements in the ArrayList  
      for (String name : P) {  
         System.out.println("Name is: " + product.product_name);  
      }
}

}