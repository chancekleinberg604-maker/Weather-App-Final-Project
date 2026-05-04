package FinalProject.FinalProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/FinalProject/WeatherViewFXML.fxml")
        );

        Scene scene = new Scene(loader.load(), 700, 600);

        primaryStage.setTitle("My Weather Lookup App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
