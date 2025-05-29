package dev.ms.maven;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class CalculMetierTest {
private static CalculMetier metier;
@BeforeClass
public static void setUpBeforeClass() throws Exception {
metier = new CalculMetier();
}
@Test
public void testSomme()
{
assertTrue(metier.somme(5, 2) == 7);
}
@Test
public void testProduit()
{
assertTrue(metier.produit(5, 2) == 10);
}
}