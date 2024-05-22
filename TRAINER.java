import java.time.*;
import java.util.List;

public class TRAINER extends EXPERT{
    protected String city;
    protected String address;
    protected Boolean personal;



    public TRAINER(String city,String address,Boolean personal)
    {
        this.city = city;
        this.address = address;
        this.personal = personal;
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getPersonal() {
        return this.personal;
    }

    public void setPersonal(Boolean personal){
        this.personal = personal;
    }

    public checkPersonal(List<LocalDateTime> dates, List<APPOINTMENT> appointments, int per_id){
        if(this.personal=true){
            PERSONAL_TRAINER pt= new PERSONAL_TRAINER(city,address, personal, per_id, dates, appointments);

        }
    }

    public createProgram(USER toUser,EXPERT from,List<LocalDateTime> date, List<String> program){
            PROGRAM pr= new PROGRAM(toUser,from,date,program);
    }

}
