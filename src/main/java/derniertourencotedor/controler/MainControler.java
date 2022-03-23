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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainControler implements Initializable
{
    @FXML
    public Label champCout;
    @FXML
    public ComboBox<NomAlgoTourne> selectTourne;
    @FXML
    public ListView listVilles;
    @FXML
    public Label nomTournee;

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
            this.nomTournee.setText(this.selectTourne.getSelectionModel().getSelectedItem().getNomAlgoTourne());
            afficherVilles(tourneEffectue.getTourneesVilles());
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
}
