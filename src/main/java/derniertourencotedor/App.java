package derniertourencotedor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException
    {
        URL fxmlFile = new File("src/main/java/derniertourencotedor/vue/tourne.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(fxmlFile);
        Scene scene = new Scene(root);
        stage.setTitle("DernierTourEnCoteDor");
        stage.setScene(scene);
        App.stage = stage;
        stage.show();
    }

    public static void demarre(String[] args) {
        launch();
    }

    /**
     * Permet de switcher de scene
     */
    public static void switchScene(Scene scene) {
        if(App.stage != null) {
            App.stage.setScene(scene);
        }
    }

}