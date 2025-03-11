import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class Personne {
    protected int id;
    protected Date dateNaissance;
    protected String ville;
    protected String nom;

    private static List<Personne> personnes = new ArrayList<>();

    public Personne(int id, String nom, String ville, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.dateNaissance = dateNaissance;

        personnes.add(this);
    }

    public static boolean supprimer(int id) {
        for (Personne p : personnes) {
            if (p.id == id) {
                personnes.remove(p);
                System.out.println("Personne avec ID " + id + " supprimée.");
                return true;
            }
        }
        System.out.println("Aucune personne trouvée avec cet ID !");
        return false;
    }

    public static void lister() {
        if (personnes.isEmpty()) {
            System.out.println("Aucune personne enregistrée.");
            return;
        }

        System.out.println("Liste des personnes :");
        for (Personne p : personnes) {
            System.out.println("ID: " + p.id + ", Nom: " + p.nom + ", Ville: " + p.ville + ", Âge: " + p.obtenirAge());
        }
    }

    public int obtenirAge() {
        if (this.dateNaissance == null) {
            return -1;
        }

        Calendar calNaissance = Calendar.getInstance();
        calNaissance.setTime(this.dateNaissance);

        Calendar calAujourdHui = Calendar.getInstance();

        int age = calAujourdHui.get(Calendar.YEAR) - calNaissance.get(Calendar.YEAR);

        if (calAujourdHui.get(Calendar.DAY_OF_YEAR) < calNaissance.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    public static void main(String[] args) {

        Personne p1 = new Personne(1, "Alice", "Abidjan", new Date(100, 5, 20));
        Personne p2 = new Personne(2, "Bob", "Yamoussoukro", new Date(90, 10, 15));

        lister();

        supprimer(1);

        lister();
    }
}
