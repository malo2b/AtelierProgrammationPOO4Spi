import java.util.ArrayList;
import java.util.Random;
/**
 * Jeu
 */
public class Jeu {

    private String titre;
    private final int NBJOUEURMAX = 6; // Nb jours max
    private final int NBCASES = 50; // Nb cases
    private ArrayList<Joueur> listeJoueurs; // ArrayList comprenant la liste des joueurs
    private Case [] cases; // Tableau comprenant la liste des cases
    private int nbEtapes; //nombre de déplacements à réaliser par chacun des personnages au cours du déroulement du jeu
    private int nbObstacles; // Nombre maximum d'obstacles dans le jeu
    private static int scoreMax; // Le score max obtenu sur l'ensemble des parties

    // Constructeur de Jeu
    public Jeu(String titre, int nbEtapes, int nbObstacles) {
        this.titre = titre;
        this.nbEtapes = nbEtapes;
        this.nbObstacles = nbObstacles;
        listeJoueurs = new ArrayList<Joueur>();
        initaliserCases();
    }

    // Ajoute un joueur a la liste des joueurs
    public void ajouterJoueur(Joueur j) {
        if (listeJoueurs.size() < NBJOUEURMAX) {
            listeJoueurs.add(j);
        }
    }

    // Retourne la liste de tous les personnages de tous les joueurs
    public ArrayList<Personnage> tousLesPersos() {
        ArrayList<Personnage> res = new ArrayList<Personnage>();
        listeJoueurs.forEach(   // On parcours tous les joueurs
            joueur -> joueur.getPersonnages().forEach(  // On parcours tous les perso
                personnage -> res.add(personnage)
            )
        );
        return res;
    }

    // Initialise les cases affecte le gain et ajoute des obstacles
    public void initaliserCases() {
        int nbAleatoire;
        int nbrObstacles = 0;
        Random rd = new Random();
        cases = new Case[50];
        for (int i = 0; i < NBCASES; i++) { // Pour chacun des elements du tableau
            nbAleatoire = rd.nextInt(NBCASES)+1;
            if (nbAleatoire % 5 == 0 && nbrObstacles < this.nbObstacles) { // Si on dois ajouter un obstacle
                cases[i] = new Case(nbAleatoire, new Obstacle(nbAleatoire*2));
                nbrObstacles++;
            } else { // Sinon case classique
                cases[i] = new Case(nbAleatoire);
            }
        }
    }

    // Lancement du jeu
    public void lancerJeu() {
        ArrayList<Personnage> personnages = tousLesPersos();
        int personnagesSize = personnages.size();
        int idCase = -1;
        int positionSouhaitee = 0;
        // On positionne tous les personnages sur le tableau de cases
        for (int i = 0; i < personnagesSize; i++) {
            do {
                idCase++;
            } while (!cases[idCase].estLibre());
            personnages.get(i).deplacer(idCase, 0);
        }
        // Le jeu demarre
        for (int i = 0; i < nbEtapes; i++) { // Chacun des deplacements
            for (Personnage personnage : personnages) { // Pour chacun des personnages
                positionSouhaitee = personnage.positionSouhaitee();
                if (cases[positionSouhaitee].estLibre()) { // Si position shouaitee est libre
                    cases[personnage.getPosition()].enleverPersonnage();
                    personnage.deplacer(positionSouhaitee, cases[positionSouhaitee].getGain()); // On deplace le joueur
                    cases[positionSouhaitee].placerPersonnage(personnage);
                } else if (cases[positionSouhaitee].sansObstacle() && !cases[positionSouhaitee].sansPerso()) { // SI position shouaitée est occupée par un joueur
                    personnage.deplacer(personnage.getPosition(), -cases[positionSouhaitee].getGain());
                } else { // Si obtsacle
                    personnage.deplacer(personnage.getPosition(), cases[positionSouhaitee].getPenalite());
                }
            }
        }
    }

    // Affiche les cases avec personnages et obstacles
    public void afficherCases() {
        int i = 0;
        for (Case currentCase : cases) {
            if (!currentCase.sansPerso()) {
                System.out.println("\033[31mCase " + i + " : " + currentCase);
            } else {
                System.out.println("\033[37mCase " + i + " : " + currentCase);
            }
            i++;
        }
    }

    // AFfiche la liste des participants
    public void afficherParticipants() {
        System.out.println("LISTE DES JOUEURS");
        for (Joueur currentJoueur : listeJoueurs) {
            System.out.println("--------------------------");
            System.out.println(currentJoueur);
        }
    }

    // Determine le joueur gagnant
    public Joueur getGagnant() {;
        Joueur gagnant = listeJoueurs.get(0);
        for (Joueur currentJoueur : listeJoueurs) {
            if (currentJoueur.getNbPoints() > gagnant.getNbPoints()) {
                gagnant = currentJoueur;
            }
        }
        return gagnant;
    }

    // AFfiche le resultat final
    public void afficherResultats() {
        Joueur gagnant = getGagnant();
        System.out.println("JEU AtelierPOO\n--------------------------\nRESULTATS");
        System.out.println("Le gagnant est " + gagnant.getNom() + " avec " + gagnant.getNbPoints() + " points");
    }

}