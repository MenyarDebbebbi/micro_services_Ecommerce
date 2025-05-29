package dev.ms.maven;
public class MonApp {
public static void main(String[] args) {
if (args.length<2)
{
System.out.println("Veuillez saisir deux nombres..");
System.exit(0);
}
double a = Double.parseDouble(args[0]);
double b = Double.parseDouble(args[1]);
CalculMetier cm =new CalculMetier();
double s =cm.somme(a, b);
double p = cm.produit(a, b);
System.out.println("La somme de "+a+ "et "+b+ "est: "+s);
System.out.println("Le produit de "+a+ "et "+b+ "est: "+p);
}
}
