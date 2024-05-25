
import java.util.ArrayList;

public class USERS {
    private ArrayList<USER> users;

    public USERS() {
        this.users = new ArrayList<>();
    }

    public USERS(ArrayList<USER> users) {
        this.users = users;
    }

    public ArrayList<USER> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<USER> users) {
        this.users = users;
    }

}
