package iset.master.spring;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import iset.master.spring.model.Produit;
import iset.master.spring.repository.ProduitRepository;
@SpringBootApplication
public class JpaSpringBootApplication {
public static void main(String[] args) {
// référencer le contexte
ApplicationContext contexte=
SpringApplication.run(JpaSpringBootApplication.class, args);
// Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
ProduitRepository produitRepos =
contexte.getBean(ProduitRepository.class);
// Insérer 3 produits
produitRepos.save(new Produit("Yaourt", 0.400, 20));
produitRepos.save(new Produit("Farine", 1.200, 30));
produitRepos.save(new Produit("Chocolat", 2000.0, 5));
// Lister l'ensemble des produits
List<Produit> lp = produitRepos.findAll();
System.out.println("******Liste des produits****");
for (Produit p : lp)
{
System.out.print("Designation:"+ p.getDesignation()+" , ");
System.out.println("Prix:"+ p.getPrix());
}
//Lister tous les produits dont la designation contient "h"
System.out.println("******Liste des produits dont la désignation contient 'h' ****");
List<Produit> lp2 = produitRepos.findByDesignation("h");
for (Produit p : lp2)
{
System.out.print("Designation:"+ p.getDesignation()+" , ");
System.out.println("Prix:"+ p.getPrix());
}
System.out.println("-----------------------");

System.out.println("-----------------------");
//Mette à jour la désignation (Farine → Pain)
produitRepos.mettreAJourDesignation("Pain", 2L);
//Afficher le produit modifié s'il est présent
Produit pm= produitRepos.findById(2L).get();
if (pm!=null)
{
System.out.println("Désignation:"+pm.getDesignation());
}
else
{
System.out.println("Produit non existant...");
}
//Lister tous les produits ayant un prix > 1.5 en utilisant une méthode requête "
System.out.println("******Liste des produits ayant un prix > 1.5 en utilisant une méthode requête ****");
List<Produit> lp4 = produitRepos.findByPrixGreaterThan(1.5);
for (Produit p : lp4) {
System.out.print("Designation:" + p.getDesignation() + " , ");
System.out.println("Prix:" + p.getPrix());
}
System.out.println("-----------------------");
}

}