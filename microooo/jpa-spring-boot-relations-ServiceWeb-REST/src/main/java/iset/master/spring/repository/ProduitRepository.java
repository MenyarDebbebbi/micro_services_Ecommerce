package iset.master.spring.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import iset.master.spring.controller.*;

import iset.master.spring.model.Produit;
import jakarta.transaction.Transactional;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
@Query ("select p from Produit p where p.designation like %:x% ")
public List<Produit> findByDesignation(@Param ("x") String mc);
List<Produit> findByPrixGreaterThan(double prixMin);

@Query("update Produit p set p.designation =:designation where p.id = :id")
@Modifying
@Transactional
public int mettreAJourDesignation(
@Param("designation")String designation,
@Param("id") Long idProduit);

 }
