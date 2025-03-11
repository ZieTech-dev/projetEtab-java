import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Eleve extends Personne {
    private String classe;
    private static List<Eleve> eleves = new ArrayList<>();

    public Eleve(int id, String nom, String ville, Date dateNaissance, String classe) {
        super(id, nom, ville, dateNaissance);
        this.classe = classe;
    }

    // 🔹 Ajouter un élève à la liste
    public static void ajouter(Eleve eleve) {
        eleves.add(eleve);
        System.out.println("✅ Élève ajouté : " + eleve.nom + " (Classe : " + eleve.classe + ")");
    }

    // 🔹 Mettre à jour un élève existant
    public static boolean mettreAJour(Eleve eleve) {
        for (Eleve e : eleves) {
            if (e.id == eleve.id) {
                e.nom = eleve.nom;
                e.ville = eleve.ville;
                e.dateNaissance = eleve.dateNaissance;
                e.classe = eleve.classe;
                System.out.println("✅ Élève mis à jour : " + eleve.nom);
                return true;
            }
        }
        System.out.println("❌ Élève non trouvé !");
        return false;
    }

    // 🔹 Lister les élèves
    public static void lister() {
        if (eleves.isEmpty()) {
            System.out.println("❌ Aucun élève enregistré.");
            return;
        }
        System.out.println("📚 Liste des élèves :");
        for (Eleve e : eleves) {
            System.out.println("ID: " + e.id + ", Nom: " + e.nom + ", Ville: " + e.ville +
                    ", Âge: " + e.obtenirAge() + ", Classe: " + e.classe);
        }
    }

    // 🔹 Supprimer un élève par ID
    public static boolean supprimer(int id) {
        for (Eleve e : eleves) {
            if (e.id == id) {
                eleves.remove(e);
                System.out.println("🗑️ Élève supprimé : " + e.nom);
                return true;
            }
        }
        System.out.println("❌ Élève avec ID " + id + " non trouvé !");
        return false;
    }
}
