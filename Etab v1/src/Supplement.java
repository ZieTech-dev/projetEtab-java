// Classe Supplément
public class Supplement {
    private int id;
    private String nom;
    private double prix;
    private int stock;

    public Supplement(int id, String nom, double prix, int stock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public void mettreAJourStock(int qte) {
        this.stock += qte;
        System.out.println("📦 Stock de " + nom + " mis à jour : " + stock);
    }
}