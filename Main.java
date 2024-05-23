
public class Main {

    public static void main(String[] args) {

        DIETICIAN myDiet = new DIETICIAN("sdf", "fsd", "fds", "dfs", "fd", 659.3f, 565, "sfd", "fd", "fd", "fs", 5, "f", 65, null, null, null, null);

        USER myUser = new USER("al", "al", "ka", "ka", "sa", 56.5f, 5, "a ", "da", "Ad", "re", 56, "dsf", 56.4f, 45.5f, null, myDiet, null, "dsa", "ds");

        System.out.println(myUser.getWallet().getAmount());
    }

}
