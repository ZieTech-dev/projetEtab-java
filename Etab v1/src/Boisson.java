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

    public void setTaille(String taille) {
        this.taille = taille;
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

    public String getTaille() {
        return taille;
    }

    public int getStock() {
        return stock;
    }
}