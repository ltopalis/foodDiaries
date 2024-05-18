import java.util.ArrayList;

public class USERS {

    private ArrayList<USER> usersList;

    public ArrayList<USER> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<USER> usersList) {
        this.usersList = usersList;
    }

    public Boolean checkIfUserExists(String email) {
        for (int i = 0; i < usersList.size(); i++)
            if (usersList[i].getEmail().equals(email))
                return true;

        return false;
    }

    public ArrayList<USER> getUsersGivenExpert(EXPERT expert) {

    }

}
