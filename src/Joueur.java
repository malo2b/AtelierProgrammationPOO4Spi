import java.util.ArrayList;

/**
 * Joueur
 */
public class Joueur {

    private static int nbJoueurs = 0;

    private String nom;     // Nom du joueur
    private String code;   // Forme J + id du joueur, valeur affectee automatiquement
    private int nbPoints = 0; // Sera toujours positif et initialisé a 0
    private ArrayList<Personnage> Personnages; // Tableau des personnages du joueur

    public Joueur(String nom) {
        nbJoueurs++;
        this.nom = nom;
        this.code = "J" + nbJoueurs;
        Personnages = new ArrayList<Personnage>();
    }

    // Getter de l'ArrayList Personnages
    public ArrayList<Personnage> getPersonnages() {
        return this.Personnages;
    }

    // Getter nombre points
    public int getNbPoints() {
        return nbPoints;
    }

    // Ajoute un objet personnage a la liste Personnages
    public void ajoutPersonnage(Personnage p) {
        if (p != null) {
            Personnages.add(p);
        }
        p.setProprietaire(this);
    }

    // Modifie le nombre de points
    public void modifierPoints(int nbPoints) {
        if (this.nbPoints + nbPoints <= 0) {
            this.nbPoints = 0; // nbPoints ne peut pas etre negatif
        } else {
            this.nbPoints += nbPoints;
        }
    }

    // Retourne True si le joueur possède au moins un personnage
    public boolean peutJouer() {
        return !Personnages.isEmpty();
    }

    // Retourne une chaine de caractere de la forme : "J1 Paul(15 points) avec 2 personnages "
    @Override
    public String toString() {
        return code + " " + nom + " (" + this.nbPoints + " points) avec " + Personnages.size() + " personnages";
    }

    public String getNom() {
        return nom;
    }

}