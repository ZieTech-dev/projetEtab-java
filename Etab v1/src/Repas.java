import java.util.List;
import java.util.ArrayList;


// Classe Repas
public class Repas {
    private int id;
    private String nom;
    private String description;
    private double prix;
    private int stock;
    private List<Supplement> supplements = new ArrayList<>();

    public Repas(int id, String nom, String description, double prix, int stock) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
    }

    public void ajouterSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    public void mettreAJourStock(int qte) {
        this.stock += qte;
        System.out.println("📦 Stock de " + nom + " mis à jour : " + stock);
    }
}