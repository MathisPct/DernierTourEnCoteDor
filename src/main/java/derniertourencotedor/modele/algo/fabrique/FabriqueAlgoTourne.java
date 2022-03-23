package derniertourencotedor.modele.algo.fabrique;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.algo.AlgoTourneAleatoire;
import derniertourencotedor.modele.algo.AlgoTourneCroissante;
import derniertourencotedor.modele.algo.AlgoTournePlusProcheVoisin;
import derniertourencotedor.modele.algo.insertion.AlgoTourneInsertionLoin;
import derniertourencotedor.modele.algo.insertion.AlgoTourneInsertionProche;
import derniertourencotedor.modele.algo.rechercheLocale.echange2opt.AlgoTourneEchangeMeilleur;
import derniertourencotedor.modele.algo.rechercheLocale.echange2opt.AlgoTourneEchangePremier;
import derniertourencotedor.modele.algo.rechercheLocale.sommets.AlgoTourneRechercheSommetMeilleur;
import derniertourencotedor.modele.algo.rechercheLocale.sommets.AlgoTourneRechercheSommetPremier;
import derniertourencotedor.modele.algo.rechercheLocale.successeur.AlgoTourneRechercheSuccMeilleur;
import derniertourencotedor.modele.algo.rechercheLocale.successeur.AlgoTourneRechercheSuccPremier;

public class FabriqueAlgoTourne
{
    public static AlgoTourne fabriquerAlgoTourne(NomAlgoTourne nomAlgoTourne, VillesParser villesParser)
    {
        AlgoTourne algoTourne = null;

        switch (nomAlgoTourne)
        {
            case ALEATOIRE:
                algoTourne = new AlgoTourneAleatoire(villesParser);
                break;
            case INSERTIONLOIN:
                algoTourne = new AlgoTourneInsertionLoin(villesParser);
                break;
            case INSERTIONPROCHE:
                algoTourne = new AlgoTourneInsertionProche(villesParser);
                break;
            case CROISSANTE:
                algoTourne = new AlgoTourneCroissante(villesParser);
                break;
            case PLUSPROCHEVOISIN:
                algoTourne = new AlgoTournePlusProcheVoisin(villesParser);
                break;
            case RECHERCHESUCCPREMIER:
                algoTourne = new AlgoTourneRechercheSuccPremier(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
            case RECHERCHESUCCMEILLEUR:
                algoTourne = new AlgoTourneRechercheSuccMeilleur(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
            case RECHERCHESOMMETPREMIER:
                algoTourne = new AlgoTourneRechercheSommetPremier(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
            case RECHERCHESOMMETMEILLEUR:
                algoTourne = new AlgoTourneRechercheSommetMeilleur(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
            case RECHERCHE2OPTMEILLEUR:
                algoTourne = new AlgoTourneEchangeMeilleur(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
            case RECHERCHE2OPTPREMIER:
                algoTourne = new AlgoTourneEchangePremier(villesParser,
                        new AlgoTournePlusProcheVoisin(villesParser).effectuerTourne());
                break;
        }
        return algoTourne;
    }
}
