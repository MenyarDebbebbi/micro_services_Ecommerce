package iset.master.spring.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
@Entity
@DiscriminatorValue("employe")
public class Employe extends Personne
{
 private int numero;
 private int nombreHeures;
@ManyToOne
private Stock stock;
public Employe() {
super();
// TODO Auto-generated constructor stub
}
public Employe(String nom, String prenom, int numero, int nombreHeures, Stock stock) {
super(nom, prenom);
this.numero = numero;
this.nombreHeures = nombreHeures;
this.stock = stock;
}
public Employe(String nom, String prenom, int numero, int nombreHeures) {
super(nom, prenom);
this.numero = numero;
this.nombreHeures = nombreHeures;
}
public Employe(String nom, String prenom) {
super(nom, prenom);
// TODO Auto-generated constructor stub
}
public Employe(String nom, String prenom, int numero) {
super(nom, prenom);
this.numero = numero;
}
public int getNombreHeures() {
return nombreHeures;
}
public void setNombreHeures(int nombreHeures) {
this.nombreHeures = nombreHeures;
}
@Override
public String toString() {
return "Employe [numero=" + numero + ", nombreHeures=" + nombreHeures +
", stock=" + stock + "]";
}
public int getNumero() {
return numero;
}
public void setNumero(int numero) {
this.numero = numero;
}
public Stock getStock() {
return stock;
}
public void setStock(Stock stock) {
this.stock = stock;
}
}