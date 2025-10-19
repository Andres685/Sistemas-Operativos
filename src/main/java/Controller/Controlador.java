package Controller;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controlador {
    private double velocidad;
    @FXML
    private ImageView imagenPlanetas;

    @FXML
    private Label nombrePlaneta;

    @FXML
    private Label temporizadorPlaneta;
    
    public void cargarImagen(String imagen, double cambio){
        imagenPlanetas.setImage(new Image(getClass().getResourceAsStream("/planetas/" + imagen + ".png")));
        nombrePlaneta.setText(imagen);
        this.velocidad = cambio;
        new Thread(()->iniciarCronometro()).start();
    }
    private void iniciarCronometro() {
        int segundos = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                segundos++;
                double segundosPlaneta = segundos * velocidad;
                Platform.runLater(() -> temporizadorPlaneta.setText(String.format("%.2f s", segundosPlaneta)));
                if(segundos == 60){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}