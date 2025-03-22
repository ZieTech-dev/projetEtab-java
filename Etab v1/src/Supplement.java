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
    // Getters et Setters
    public int getId() {
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    public void setStock(int stock) {
        this.stock = stock;
    }

    // Optionnel : Méthodes pour afficher les informations
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }



    public int getStock() {
        return stock;
    }
}