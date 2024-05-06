import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args){
        try(Connection conn = connectDB.getConnection()){
            System.out.println("Connected");
        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
