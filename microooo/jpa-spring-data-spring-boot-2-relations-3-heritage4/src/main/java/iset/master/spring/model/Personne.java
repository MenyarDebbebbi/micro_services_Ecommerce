package iset.master.spring.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType; 
import jakarta.persistence.MappedSuperclass;

// pour déclarer une classe mère (non entité)
@Entity
@Inheritance(strategy = InheritanceType. TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE_PERSONNE")
@DiscriminatorValue("Personne")

public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nom;
    protected String prenom;

    public Personne(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
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

    public Personne() {
        super();
    }
}
