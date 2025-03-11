import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professeur extends Personne {
    private boolean vacant;


    private static List<Professeur> professeurs = new ArrayList<>();


    public Professeur(int id, String nom, String ville, Date dateNaissance, boolean vacant) {
        super(id, nom, ville, dateNaissance);
        this.vacant = vacant;
    }


    public static void ajouterProf(Professeur professeur) {
        professeurs.add(professeur);
        System.out.println("✅ Professeur ajouté : " + professeur.nom);
    }

    public static boolean mettreAJour(Professeur professeur) {
        for (Professeur p : professeurs) {
            if (p.id == professeur.id) {
                p.nom = professeur.nom;
                p.ville = professeur.ville;
                p.dateNaissance = professeur.dateNaissance;
                p.vacant = professeur.vacant;
                System.out.println("✅ Professeur mis à jour : " + professeur.nom);
                return true;
            }
        }
        System.out.println("❌ Professeur non trouvé !");
        return false;
    }

    public static void lister() {
        if (professeurs.isEmpty()) {
            System.out.println("❌ Aucun professeur enregistré.");
            return;
        }
        System.out.println("📚 Liste des professeurs :");
        for (Professeur p : professeurs) {
            System.out.println("ID: " + p.id + ", Nom: " + p.nom + ", Ville: " + p.ville +
                    ", Âge: " + p.obtenirAge() + ", Vacant: " + (p.vacant ? "Oui" : "Non"));
        }
    }

    public static boolean supprimer(int id) {
        for (Professeur p : professeurs) {
            if (p.id == id) {
                professeurs.remove(p);
                System.out.println("🗑️ Professeur supprimé : " + p.nom);
                return true;
            }
        }
        System.out.println("❌ Professeur avec ID " + id + " non trouvé !");
        return false;
    }

    public static void main(String[] args) {
        Professeur p1 = new Professeur(1, "Dr. Koné", "Abidjan", new Date(80, 5, 10), true);
        Professeur p2 = new Professeur(2, "Mme. Coulibaly", "Yamoussoukro", new Date(75, 10, 20), false);

        ajouterProf(p1);
        ajouterProf(p2);

        lister();


        p1.vacant = false;
        mettreAJour(p1);

        lister();

        supprimer(2);

        lister();
    }
}
