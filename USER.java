
public class USER extends PERSON {

    private float weight;
    private float height;
    private String nutrition_goal;
    private String training_goal;
    private DOCTOR doctor;
    private DIETICIAN dietician;
    private TRAINER trainer;
    private PRODUCTS cart;
    private PROGRAM trainingProgram;
    private PROGRAM nutritionProgram;

    public USER(String name, String lastname, String Email, String Password, String phone_number) {
        super(name, lastname, Email, Password, phone_number, 0, 0, null, null, null, null, 0, null);
    }

    public USER(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int id,
            String friendly_name, float weight, float height, DOCTOR doctor, DIETICIAN dietician, TRAINER trainer, String nutricion_goal, String training_goal, PROGRAM trainingProgram, PROGRAM nutritionProgram) {
        super(name, lastname, Email, Password, phone_number, amount, idWallet, address_name, address_number, zipCode, country, id, friendly_name);
        this.weight = weight;
        this.height = height;
        this.doctor = doctor;
        this.dietician = dietician;
        this.trainer = trainer;
        this.nutrition_goal = nutricion_goal;
        this.training_goal = training_goal;
        this.cart = new PRODUCTS();
        this.trainingProgram = trainingProgram;
        this.nutritionProgram = nutritionProgram;
    }

    public USER(String email, String name, String lastname) {
        super(email, name, lastname);
    }

    public USER() {
        super(null, null, null);
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

    public PRODUCTS getCart() {
        return cart;
    }

    public void setCart(PRODUCTS cart) {
        this.cart = cart;
    }

    public PROGRAM getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(PROGRAM trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public PROGRAM getNutritionProgram() {
        return nutritionProgram;
    }

    public void setNutritionProgram(PROGRAM nutritionProgram) {
        this.nutritionProgram = nutritionProgram;
    }

}
