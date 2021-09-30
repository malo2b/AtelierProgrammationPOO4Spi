/**
 * Personnage
 */
abstract class Personnage {

    protected String nom; // Nom du personnage
    protected int age; // Age du personnage
    protected int position; // Entier representant la position du personnage dans le jeu
    protected Joueur proprietaire; // Reference a l'objet propriétaire du joueur

    // Constructeur de la classe Personnage
    public Personnage(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Affecte au personnage l'adresse de son propriétaire
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode correspondant a un déplacement du personnage
    public void deplacer(int destination, int gain) {
        this.position = destination; // Modification de la position
        this.proprietaire.modifierPoints(gain); // Modification du nombre de points du Joueur
    }

    // diminue le nombre de points de son joueur propriétaire
    // de la valeur du paramètre penalite, Penalité positif
    public void penalise(int penalite) {
        this.proprietaire.modifierPoints(-penalite);
    }

    // Retourne le nom du personnage
    @Override
    public String toString() {
        return this.nom;
    }

    public abstract int positionSouhaitee();

    public int getPosition() {
        return position;
    }

}
