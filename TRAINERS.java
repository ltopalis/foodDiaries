
import java.util.ArrayList;

public class TRAINERS {

    private ArrayList<TRAINER> trainers;

    public TRAINERS() {
        this.trainers = new ArrayList<>();
    }

    public ArrayList<TRAINER> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<TRAINER> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(TRAINER trainer) {
        this.trainers.add(trainer);
    }

    public boolean equals(TRAINER obj) {
        for(TRAINER tr : this.trainers) 
            if(tr.getEmail().equals(obj.getEmail()))
                return true;
        
        return false;
    }
}
