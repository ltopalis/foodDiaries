import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class expertSignupMain extends Application {

    private double x;
    private double y;

    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("./Screens/expert_signup.fxml"));
            Scene scene = new Scene(root);


            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
