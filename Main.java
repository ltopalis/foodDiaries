
public class Main {

    public static void main(String[] args) {

        // USER myUser = new USER("name", "lastname", "dimitris@gmail.com", "password", "1234567890");
        // TRAINER mytrainer = new TRAINER("name", "lastname", "george@gmail.com", "password", "1234567890");

        // mytrainer.createProgram(myUser, "breakfast", "lunch", "dinner");

        MESSAGES myMessages = new MESSAGES("dimitris@gmail.com");

        for(MESSAGE mes : myMessages.getMessages())
            System.out.println(mes.getMessage() + " " + mes.getTime());
    }

}
