import java.time.LocalDateTime;
import java.util.*;
import java.time.*;
import java.util.List;

public class PERSONAL_TRAINER extends TRAINER {
    protected int per_id;
    protected List<LocalDateTime> dates;
    protected List<APPOINTMENT> appointments;

    public PERSONAL_TRAINER(String city, String address, Boolean personal, int per_id,List<LocalDateTime> dates,List<APPOINTMENT> appointments) {
        super(city, address, personal);
        this.city = city;
        this.address = address;
        this.personal = personal;
        this.per_id = per_id;
        this.dates = dates;
        this.appointments = appointments;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public List<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(List<LocalDateTime> dates) {
        this.dates = dates;
    }

    public List<APPOINTMENT> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<APPOINTMENT> appointments) {
        this.appointments = appointments;
    }
}
