// Classe Boisson
public class Boisson {
    private int id;
    private String nom;
    private double prix;
    private String taille;
    private int stock;

    public Boisson(int id, String nom, double prix, String taille, int stock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
        this.stock = stock;
    }

    public void mettreAJourStock(int qte) {
        this.stock += qte;
        System.out.println("📦 Stock de " + nom + " mis à jour : " + stock);
    }
}