import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Commande
public class Commande {
    private int id;
    private Date dateCommande;
    private String statut;
    private List<Menu> menus = new ArrayList<>();
    private ArrayList<Repas> repasList;
    private ArrayList<Boisson> boissonList;
    private ArrayList<Supplement> supplementList;
    private ArrayList<Integer> quantitesRepas;
    private ArrayList<Integer> quantitesBoissons;

    public Commande(int id, Date dateCommande) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.statut = "En attente";
        this.repasList = new ArrayList<>();
        this.boissonList = new ArrayList<>();
        this.supplementList = new ArrayList<>();
        this.quantitesRepas = new ArrayList<>();
        this.quantitesBoissons = new ArrayList<>();
    }

    public void ajouterMenu(Repas repas, int quantite) {
        repasList.add(repas);
        quantitesRepas.add(quantite);
    }

//    public double calculerTotal() {
//        double total = 0;
//        for (Menu menu : menus) {
//            total += menu.getTotalPrix();
//        }
//        return total;
//    }

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
    public void ajouterBoisson(Boisson boisson, int quantite) {
        boissonList.add(boisson);
        quantitesBoissons.add(quantite);
    }

    public void ajouterSupplement(Supplement supplement, int quantite) {
        supplementList.add(supplement);
        // Pas besoin de liste pour la quantité des suppléments si ils sont facultatifs.
    }


    public double calculerTotal() {
        double total = 0;
        for (int i = 0; i < repasList.size(); i++) {
            total += repasList.get(i).getPrix() * quantitesRepas.get(i);
        }
        for (int i = 0; i < boissonList.size(); i++) {
            total += boissonList.get(i).getPrix() * quantitesBoissons.get(i);
        }
        for (Supplement supplement : supplementList) {
            total += supplement.getPrix();
        }
        return total;
    }

    public void afficherCommande() {
        System.out.println("Votre commande:");
        for (int i = 0; i < repasList.size(); i++) {
            System.out.println("Repas: " + repasList.get(i).getNom() + " | Quantité: " + quantitesRepas.get(i));
        }
        for (int i = 0; i < boissonList.size(); i++) {
            System.out.println("Boisson: " + boissonList.get(i).getNom() + " | Quantité: " + quantitesBoissons.get(i));
        }
        for (Supplement supplement : supplementList) {
            System.out.println("Supplément: " + supplement.getNom());
        }
        System.out.println("Total: " + calculerTotal() + "€");
    }
}