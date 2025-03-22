import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Commande
public class Commande {
    private int id;
    private Date dateCommande;
    private String statut;
    private List<Menu> menus = new ArrayList<>();

    public Commande(int id, Date dateCommande, String statut) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.statut = statut;
    }

    public void ajouterMenu(Menu menu) {
        menus.add(menu);
    }

    public double calculerTotal() {
        double total = 0;
        for (Menu menu : menus) {
            total += menu.getTotalPrix();
        }
        return total;
    }

    public void changerStatut(String nouveauStatut) {
        this.statut = nouveauStatut;
        System.out.println("✅ Statut de la commande mis à jour en : " + nouveauStatut);
    }
    public int getId() {
        return this.id;
    }

    public Date getDateCommande() {
        return this.dateCommande;
    }

    public String getStatut() {
        return this.statut;
    }
}