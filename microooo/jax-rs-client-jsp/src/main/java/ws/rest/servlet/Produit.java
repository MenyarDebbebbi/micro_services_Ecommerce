package ws.rest.servlet;

public class Produit {
    private String nom;
    private String description;
    private double prix;

    public Produit(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public double getPrix() { return prix; }
}
