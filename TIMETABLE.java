
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TIMETABLE {

    private ArrayList<APPOINTMENT> timetable;

    public TIMETABLE(ArrayList<APPOINTMENT> timetable) {
        this.timetable = timetable;
    }

    public ArrayList<APPOINTMENT> getTimetable() {
        return timetable;
    }

    public void setTimetable(ArrayList<APPOINTMENT> timetable) {
        this.timetable = timetable;
    }

    public boolean isfree(LocalDateTime dateTime) {
        for (APPOINTMENT d : this.timetable) {
            if (d.getDateTime().equals(dateTime)) {
                return d.isIsfree();
            }
        }

        return false;
    }

    public void reserve(APPOINTMENT appointment, PERSONAL_TRAINER personal, USER user) {
        try (Connection conn = connectDB.getConnection()) {
            if (appointment.reserveTime(conn, personal)) {
                if (user.getWallet().reduceAmount(personal.getPrice())) {
                    personal.getWallet().addAmount(personal.getPrice());
                }

                String query = "UPDATE wallet SET value = ? WHERE person_id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setDouble(1, user.getWallet().getAmount());
                stmt.setString(2, user.getEmail());
                stmt.execute();

                stmt = conn.prepareStatement(query);
                stmt.setDouble(1, personal.getWallet().getAmount());
                stmt.setString(2, personal.getEmail());
                stmt.execute();

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void reserve(String appointmentTime, PERSONAL_TRAINER personal, USER user) {

        APPOINTMENT appointment = new APPOINTMENT(null, false);
        for (APPOINTMENT ap : this.timetable)
            if(ap.getDateTime().equals(appointmentTime))
                appointment = ap;

        try (Connection conn = connectDB.getConnection()) {
            if (appointment.reserveTime(conn, personal)) {
                if (user.getWallet().reduceAmount(personal.getPrice())) {
                    personal.getWallet().addAmount(personal.getPrice());
                }

                String query = "UPDATE wallet SET value = ? WHERE person_id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setDouble(1, user.getWallet().getAmount());
                stmt.setString(2, user.getEmail());
                stmt.execute();

                stmt = conn.prepareStatement(query);
                stmt.setDouble(1, personal.getWallet().getAmount());
                stmt.setString(2, personal.getEmail());
                stmt.execute();

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
