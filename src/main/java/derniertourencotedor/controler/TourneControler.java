package derniertourencotedor.controler;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.algo.fabrique.FabriqueAlgoTourne;
import derniertourencotedor.modele.algo.fabrique.NomAlgoTourne;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.vue.UtilsIHM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TourneControler implements Initializable
{
    @FXML
    public Label champCout;
    @FXML
    public ComboBox<NomAlgoTourne> selectTourne;
    @FXML
    public ListView listVilles;
    @FXML
    public Label nomTournee;
    @FXML
    public VBox tourneContainer;
    @FXML
    public Label tailleVilles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.selectTourne.getItems().addAll(NomAlgoTourne.values());
    }

    @FXML
    public void calculerTourner(ActionEvent actionEvent) throws Exception {
        try
        {
            verifierSiSelectionEstBonne();
            VillesParser villesParser = new VillesParser(new File("top80.txt"));
            AlgoTourne algoTourne = FabriqueAlgoTourne.fabriquerAlgoTourne(selectTourne.getValue(), villesParser);
            Tourne tourneEffectue = algoTourne.effectuerTourne();
            this.champCout.setText(String.valueOf(tourneEffectue.getCout()));
            afficherVilles(tourneEffectue.getTourneesVilles());
            this.tailleVilles.setText(String.valueOf(tourneEffectue.getTourneesVilles().size()));
        }catch (Exception e)
        {
            UtilsIHM.afficherErreur(e.getMessage());
        }
    }

    private void afficherVilles(ArrayList<Ville> villes) throws Exception {
        if(villes.isEmpty()) throw new Exception("La tournée ne contient aucune ville");
        this.listVilles.getItems().clear();
        this.listVilles.getItems().addAll(villes);
    }

    private void verifierSiSelectionEstBonne() throws Exception
    {
        if(selectTourne.getValue() == null) throw new Exception("Veuillez choisir une tournée");
    }

    /**
     * Lorsque l'user clique sur un nouvel algo dans la liste
     * @param actionEvent
     */
    public void choixAlgo(ActionEvent actionEvent)
    {
        this.champCout.setText("Non calculé");
        this.nomTournee.setText(this.selectTourne.getSelectionModel().getSelectedItem().getNomAlgoTourne());
    }
}
