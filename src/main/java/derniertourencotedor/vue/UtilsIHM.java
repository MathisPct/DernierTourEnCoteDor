package derniertourencotedor.vue;

import javafx.scene.control.Alert;

public class UtilsIHM
{
    /**
     * Affiche une fenetre bloquante pour message d'erreur
     * @param message Le message d'erreur à afficher
     * @autor Mathis Poncet
     */
    public static void afficherErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur !");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
