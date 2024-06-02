import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class bookPersonalTrainerMain extends Application {

    private double x;
    private double y;

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("./Screens/krathshPersonalTrainer.fxml"));
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getSceneY() - y);

                stage.setOpacity(.8);
            });

            root.setOnMouseReleased((MouseEvent event) -> {
                stage.setOpacity(1);
            });

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
