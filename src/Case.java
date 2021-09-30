/**
 * Case
 */
public class Case {

    private int gain;
    private Personnage perso = null;
    private Obstacle obs = null;

    // Constructeur Case sans obstacle
    public Case(int gain) {
        this.gain = gain;
    }

    // Getter de gain
    public int getGain() {
        return gain;
    }

    // Constructeur Case avec obstacle
    public Case(int gain, Obstacle obs) {
        this(gain);
        this.obs = obs;
    }

    // Renvoie 0 si pas obstacle, la valeur de la penalité sinon
    public int getPenalite() {
        int res = 0;
        if (obs != null) {
            res = obs.getPenalite();
        }
        return res;
    }

    // Place le personnage sur la case
    public void placerPersonnage(Personnage perso) {
        this.perso = perso;
    }

    // Place l'obstacle sur la case
    public void placerObstacle(Obstacle obs) {
        this.obs = obs;
    }

    // Enleve le personnage de la case
    public void enleverPersonnage() {
        this.perso = null;
    }

    // Retourne true si la case ne contiens ni obstacle ni autre perso
    public boolean estLibre() {
        return this.obs == null && this.perso == null;
    }

    // Retourne true si la case ne contiens pas d'obstacle
    public boolean sansObstacle() {
        return this.obs == null;
    }

    // Retourne true si la case ne contiens pas de perso
    public boolean sansPerso() {
        return this.perso == null;
    }

    // Retourne une chaine de la forme :
    // Libre (gain = 28)
    // Obstacle (penalité = -30)
    // Humain Jean(penalité = -34)
    @Override
    public String toString() {
        String res;
        if (estLibre()) {
            res = "Libre (gain = " + this.gain + ")";
        } else if (!sansObstacle()) {
            res = "Obstacle (penalite = " + this.getPenalite() + ")";
        } else {
            res = perso + " (penalite = " + this.getPenalite() + ")";
        }
        return res;
    }

}