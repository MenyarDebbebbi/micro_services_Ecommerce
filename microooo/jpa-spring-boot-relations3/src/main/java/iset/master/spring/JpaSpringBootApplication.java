package iset.master.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import iset.master.spring.model.Categorie;
import iset.master.spring.model.Produit;
import iset.master.spring.model.Responsable;
import iset.master.spring.model.Stock;
import iset.master.spring.repository.CategorieRepository;
import iset.master.spring.repository.ProduitRepository;
import iset.master.spring.repository.ResponsableRepository;
import iset.master.spring.repository.StockRepository;

@SpringBootApplication
public class JpaSpringBootApplication {

    // Déclaration des repositories
    static ProduitRepository produitRepos;
    static CategorieRepository categorieRepos;
    static StockRepository stockRepos;
    static ResponsableRepository responsableRepos; // Déclaration de ResponsableRepository

    public static void main(String[] args) {
        // Référencer le contexte
        ApplicationContext contexte = SpringApplication.run(JpaSpringBootApplication.class, args);

        // Récupérer les implémentations des repositories par injection de dépendance
        produitRepos = contexte.getBean(ProduitRepository.class);
        categorieRepos = contexte.getBean(CategorieRepository.class);
        stockRepos = contexte.getBean(StockRepository.class);
        responsableRepos = contexte.getBean(ResponsableRepository.class);

        // Créer deux catégories
        Categorie cat1 = new Categorie("AL", "Alimentaire");
        Categorie cat2 = new Categorie("PL", "Plastique");

        // Attacher les deux catégories à la BD (insertion)
        categorieRepos.save(cat1);
        categorieRepos.save(cat2);

        // Parse les dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        java.util.Date date3 = null;
        try {
            date1 = sdf.parse("2022-04-15");
            date2 = sdf.parse("2022-02-15");
            date3 = sdf.parse("2022-05-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Créer 3 produits
        Produit p1 = new Produit("Yahourt", 0.400, 20, date1, cat1);
        Produit p2 = new Produit("Chocolat", 2000.0, 5, date2, cat1);
        Produit p3 = new Produit("Panier", 1.200, 30, date3, cat2);
        Produit p4 = new Produit("PIZZA", 1.200, 30, date3, cat2);

        // Créer deux stocks
        Stock s1 = new Stock("1", "Sfax");
        Stock s2 = new Stock("2", "Tunis");

        // Ajouter le produit p1 aux deux stocks s1 et s2
        p1.getStocks().add(s1);
        p1.getStocks().add(s2);

        // Enregistrement dans la BD en utilisant "produitRepository"
        produitRepos.save(p1);
        produitRepos.save(p2);
        produitRepos.save(p3);

        // Afficher la liste des produits
        afficherTousLesProduits();

        // Affecter les stocks aux produits et les enregistrer
        p2.getStocks().add(s1);
        p3.getStocks().add(s2);
        produitRepos.save(p2);
        produitRepos.save(p3);

        // Supprimer un stock
        stockRepos.deleteById(s1.getId());

        // Créer un responsable
        Responsable r1 = new Responsable("Ben Saleh", "Ali");
        Responsable r3 = new Responsable ("Sallemi", "Samira");
        Stock s3 = new Stock("3", "Sfax",r3);
        stockRepos.save(s3);
        // Créer un nouveau stock avec le responsable
        Stock s11 = new Stock("1", "Tunis", r1);
        stockRepos.save(s11);
    }

    // Afficher tous les produits
    static void afficherTousLesProduits() {
        System.out.println("***************************************");
        // Lister l'ensemble des produits
        System.out.println("Afficher tous les produits...");
        List<Produit> lp = produitRepos.findAll();
        for (Produit p : lp) {
            System.out.println(p);
        }
        System.out.println("***************************************");
    }

    // Afficher tous les produits d'une catégorie donnée
    static void afficherTousLesProduitsDeLaCategorie(Long id) {
        System.out.println("***************************************");
        // Récupérer l'entité "Catégorie" ayant l'id en paramètres
        Categorie cD = categorieRepos.findById(id).orElse(null); // Utilisation de findById
        if (cD != null) {
            // Lister l'ensemble des produits
            System.out.println("Afficher tous les produits de la catégorie [" + id + "]");
            Collection<Produit> lC = cD.getProduits();
            for (Produit p : lC) {
                System.out.println(p);
            }
        } else {
            System.out.println("Catégorie non existante...");
        }
        System.out.println("***************************************");
    }
}
