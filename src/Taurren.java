/**
 * Taurren
 */
public class Taurren extends Personnage {

    private double taille; // Taille du personnage en m

    // Constructeur taurren
    public Taurren(String nom, int age, int taille) {
        super(nom, age); // Appel du constructeur de la classe Generale
        this.taille = taille;
    }

    // Retourne la position souhaitée tel que = position + nbr aléatoire entre 1 et sa taille
    public int positionSouhaitee() {
        int randomValue = (int)(Math.random()*(taille-1)) + 1;
        if (this.position + randomValue > 50) {
                randomValue = positionSouhaitee() - this.position; // Pas opti mais blc
        }
        return this.position + randomValue;
    }

    // Retourne une chaine de la forme : "Tauren Hector"
    @Override
    public String toString() {
        return "Taurren " + this.nom;
    }

}