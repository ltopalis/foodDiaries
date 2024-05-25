
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MESSAGES {

    private ArrayList<MESSAGE> messages;

    public MESSAGES(String userEmail) {
        this.messages = new ArrayList<>();

        try (Connection conn = connectDB.getConnection()) {

            String query = "SELECT user_id, message, timestamp, person.email, person.name, person.lastname, person.role FROM chat JOIN person ON chat.sender = person.email WHERE user_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userEmail);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                String chatId = result.getString("user_id");
                String message = result.getString("message");
                String dateTime = result.getString("timestamp");
                String senderEmail = result.getString("person.email");
                String senderName = result.getString("person.name");
                String senderLastname = result.getString("person.lastname");
                String senderRole = result.getString("person.role");

                PERSON sender = new USER();

                switch (senderRole) {
                    case "USER" ->
                        sender = new USER(senderEmail, senderName, senderLastname);
                    case "DOCTOR" ->
                        sender = new DOCTOR(senderEmail, senderName, senderLastname);
                    case "DIETICIAN" ->
                        sender = new DIETICIAN(senderEmail, senderName, senderLastname);
                    case "TRAINER" ->
                        sender = new TRAINER(senderEmail, senderName, senderLastname);
                }

                this.messages.add(new MESSAGE(message, sender, LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), chatId));

            }

            Collections.sort(this.messages, new Comparator<MESSAGE>() {
                @Override
                public int compare(MESSAGE m1, MESSAGE m2) {
                    return m1.getTime().compareTo(m2.getTime());
                }
            });

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public ArrayList<MESSAGE> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MESSAGE> messages) {
        this.messages = messages;
    }

}
