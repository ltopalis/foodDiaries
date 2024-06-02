
import java.util.ArrayList;

public class PERSONAL_TRAINERS {

    private ArrayList<PERSONAL_TRAINER> personal_trainers;

    public PERSONAL_TRAINERS() {
        this.personal_trainers = new ArrayList<>();
    }

    public ArrayList<PERSONAL_TRAINER> getPersonal_trainers() {
        return personal_trainers;
    }

    public void setPersonal_trainers(ArrayList<PERSONAL_TRAINER> personal_trainers) {
        this.personal_trainers = personal_trainers;
    }

    public PERSONAL_TRAINER getPersonalTrainer(String email) {
        for (PERSONAL_TRAINER trainer: this.personal_trainers)
            if(trainer.getEmail().equals(email))
                return trainer;

        return null;
    }

    public void add(PERSONAL_TRAINER personalTrainer) {
        for (PERSONAL_TRAINER per : this.personal_trainers) {
            if (per.getEmail().equals(personalTrainer.getEmail())) {
                per.getAppointments().add(personalTrainer.getAppointments().get(0));
                return;
            }
        }

        this.personal_trainers.add(personalTrainer);
    }
}
