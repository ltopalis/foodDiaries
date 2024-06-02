
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class APPOINTMENT {

    private int idAppointment;
    private LocalDateTime dateTime;
    private boolean isfree;

    public APPOINTMENT(int idAppointment, LocalDateTime dateTime, boolean isfree) {
        this.idAppointment = idAppointment;
        this.dateTime = dateTime;
        this.isfree = isfree;
    }

    public APPOINTMENT(LocalDateTime dateTime, boolean isfree) {
        this.dateTime = dateTime;
        this.isfree = isfree;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public boolean reserveTime(Connection conn, EXPERT expert) throws SQLException {
        if (!this.isfree) { // can be reserved
            this.isfree = false;
            Random randomNumber = new Random();
            this.idAppointment = randomNumber.nextInt(LocalTime.now().getNano());

            String query = "UPDATE timetable SET isFree = false, id = ? WHERE expert = ? AND dateTime = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAppointment);
            stmt.setString(2, expert.getEmail());
            stmt.setString(3, this.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            stmt.execute();
            return true;
        } else {
            System.err.println("Cannot be reserved!"); return false;
        }
    }

    public boolean reserveTime(Connection conn, String expert) throws SQLException {
        if (!this.isfree) { // can be reserved
            this.isfree = false;
            Random randomNumber = new Random();
            this.idAppointment = randomNumber.nextInt(LocalTime.now().getNano());

            String query = "UPDATE timetable SET isFree = false, id = ? WHERE expert = ? AND dateTime = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAppointment);
            stmt.setString(2, expert);
            stmt.setString(3, this.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            stmt.execute();
            return true;
        } else {
            System.err.println("Cannot be reserved!"); return false;
        }
    }

    @Override
    public String toString() {
        return this.dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    

}
