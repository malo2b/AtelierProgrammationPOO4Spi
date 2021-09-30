public class App {
    public static void main(String[] args) throws Exception {
        // TestJeu
        Jeu AtelierPOO = new Jeu("AtelierPOO", 5, 10);

        Joueur Paul = new Joueur("Paul");
        Paul.ajoutPersonnage(new Taurren("Hector", 15, 10));
        Paul.ajoutPersonnage(new Humain("Jean", 10));

        Joueur Lucien = new Joueur("Lucien");
        Lucien.ajoutPersonnage(new Humain("Marie", 10));
        Lucien.ajoutPersonnage(new Taurren("Hercule", 20, 5));

        AtelierPOO.ajouterJoueur(Paul);
        AtelierPOO.ajouterJoueur(Lucien);

        AtelierPOO.lancerJeu();
        AtelierPOO.afficherParticipants();
        System.out.println("\n\n");
        AtelierPOO.afficherCases();
        System.out.println("\n\n");
        AtelierPOO.afficherResultats();
    }

}
