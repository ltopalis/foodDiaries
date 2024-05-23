
import java.util.List;

public class USER extends PERSON {

    // List<String> Or = new List<>();

    private float weight;
    private float height;
    private String nutrition_goal;
    private String training_goal;
    private DOCTOR doctor;
    private DIETICIAN dietician;
    private TRAINER trainer;

    // Product pr;

    public USER(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, float weight, float height, DOCTOR doctor, DIETICIAN dietician, TRAINER trainer, String nutricion_goal, String training_goal) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name);
        this.weight = weight;
        this.height = height;
        this.doctor = doctor;
        this.dietician = dietician;
        this.trainer = trainer;
        this.nutrition_goal = nutricion_goal;
        this.training_goal = training_goal;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getNutrition_goal() {
        return nutrition_goal;
    }

    public void setNutrition_goal(String nutrition_goal) {
        this.nutrition_goal = nutrition_goal;
    }

    public String getTraining_goal() {
        return training_goal;
    }

    public void setTraining_goal(String training_goal) {
        this.training_goal = training_goal;
    }

    public DOCTOR getDOCTOR() {
        return doctor;
    }

    public void setDOCTOR(DOCTOR doctor) {
        this.doctor = doctor;
    }

    public DIETICIAN getDIETICIAN() {
        return dietician;
    }

    public void setDIETICIAN(DIETICIAN dietician) {
        this.dietician = dietician;
    }

    public TRAINER getTRAINER() {
        return trainer;
    }

    public void setTRAINER(TRAINER trainer) {
        this.trainer = trainer;
    }
}
