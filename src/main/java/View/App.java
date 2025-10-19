package View;
import Controller.Controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Neptuno", "Urano"};
    public static String[] imagenes = {"/planetas/mercurio.png", "/planetas/venus.png", "/planetas/tierra.png", "/planetas/marte.png", "/planetas/jupiter.png", "/planetas/saturno.png", "/planetas/neptuno.png", "/planetas/urano.png"};
    public static double[] escala = {58.66,243.0,1.0,1.0416,0.41354,0.444,0.72,0.67};
    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        for (int i = 0; i < planetas.length; i++) {
            FXMLLoader loder = new FXMLLoader(getClass().getResource("/vistaPlanetas.fxml"));
            AnchorPane root = loder.load();
            Controlador control = loder.getController();
            control.cargarImagen(planetas[i], escala[i]);
            Stage stages = new Stage();                     
            stages.setTitle(planetas[i]);
            stages.setScene(new Scene(root));
            stages.show();
        }
    }
    public static void main(String[] args) {
        launch();
    }

}