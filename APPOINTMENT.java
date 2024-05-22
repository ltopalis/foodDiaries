import java.time.LocalDateTime;
import java.util.List;

public class APPOINTMENT {
    protected int idAppointment;
    protected LocalDateTime date1;
    protected double price;
    protected int personal_trainer_id;
    protected int user_id;

    public APPOINTMENT(int idAppointment, LocalDateTime date1, double price, int personal_trainer_id, int user_id) {
        this.idAppointment = idAppointment;
        this.date1 = date1;
        this.price = price;
        this.personal_trainer_id = personal_trainer_id;
        this.user_id = user_id;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public void setDate(LocalDateTime date1) {
        this.date1 = date1;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPersonal_trainer_id(int personal_trainer_id) {
        this.personal_trainer_id = personal_trainer_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public double getPrice() {
        return price;
    }

    public int getPersonal_trainer_id() {
        return personal_trainer_id;
    }

    public LocalDateTime getDate() {
        return date1;
    }

    public int getUser_id() {
        return user_id;
    }


    public static ObservableList<APPOINTMENT> showAppointments(int pt_id){
        ObservableList<APPOINTMENT> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from appointment where personal_id= ?"); //
            ps.setString(1, pt_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new APPOINTMENT(Integer.parseInt(rs.getString("appointment_id")),
                        LocalDateTime.parse(rs.getString("date")),
                        Double.parseDouble(rs.getString("price")),
                        Integer.parseInt(rs.getString("personal_trainer_id")),
                        Integer.parseInt(rs.getString("user_id"))));

            }
        } catch (Exception e) {
        }
        return list;

    }
}
