package iset.master.spring.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
@Entity
public class Responsable extends Personne{
private double salaire;
@OneToOne (mappedBy = "responsable")
private Stock stock;
public Responsable(String nom, String prenom, double salaire, Stock stock) {
super(nom, prenom);
this.salaire = salaire;
this.stock = stock;
}
public Responsable(String nom, String prenom, double salaire) {
super(nom, prenom);
this.salaire = salaire;
}
public Responsable(String nom, String prenom) {
super(nom, prenom);
// TODO Auto-generated constructor stub
}
public Responsable() {
	super();
	// TODO Auto-generated constructor stub
	}
	public String getNom() {
	return nom;
	}
	@Override
	public String toString() {
	return "Responsable [salaire=" + salaire + ", stock=" + stock + "]";
	}
	public double getSalaire() {
	return salaire;
	}
	public void setSalaire(double salaire) {
	this.salaire = salaire;
	}
	public void setNom(String nom) {
	this.nom = nom;
	}
	public String getPrenom() {
	return prenom;
	}
	public void setPrenom(String prenom) {
	this.prenom = prenom;
	}
	public Stock getStock() {
	return stock;
	}
	public void setStock(Stock stock) {
	this.stock = stock;
	}
	
}