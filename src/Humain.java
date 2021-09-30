/**
 * Humain
 */
public class Humain extends Personnage {

    private int nbDeplacements = 0; // Nbr deplacement effectue par l'humain
    private int niveau = 1; // représente le niveau de l’humain qui est compris entre 1 et 3

    // Constructeur de humain
    public Humain(String nom, int age) {
        super(nom, age);
    }

    // Redefinition de deplacer pour y incrementer nbDeplacement et calculer le niveau
    public void deplacer(int destination, int gain) {
        super.deplacer(destination, gain);
        nbDeplacements++;
        // L'humain passe au niveau 2 a partir de 4 deplacements et 3 a partir de 6
        if (nbDeplacements >= 4 && niveau == 1) {
            niveau = 2;
        } else if (nbDeplacements >= 6 && niveau == 2) {
            niveau = 3;
        }
    }

    // Retourne la position shouaitée tel que = position + nbDeplacements x niveau de l'humain
    public int positionSouhaitee() {
        return this.position + (this.nbDeplacements * this.niveau) <= 50 ? this.position + (this.nbDeplacements * this.niveau) : 50; // A modifier
    }

    // Retourne une chaine de la forme : "Humain Hector"
    @Override
    public String toString() {
        return "Humain " + this.nom;
    }

}