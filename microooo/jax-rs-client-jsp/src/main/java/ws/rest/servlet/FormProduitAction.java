package ws.rest.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet("/FormProduitAction")
public class FormProduitAction extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // a) Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String prixStr = request.getParameter("prix");
        
        // Vérification si les champs sont bien renseignés
        if (nom == null || description == null || prixStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tous les champs sont obligatoires.");
            return;
        }

        // Convertir prix en double, avec gestion des erreurs
        double prix = 0;
        try {
            prix = Double.parseDouble(prixStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Le prix doit être un nombre valide.");
            return;
        }

        // b) Créer une instance de la classe Produit
        Produit produit = new Produit(nom, description, prix);

        // c) Configurer une connexion avec la ressource "/produits" du projet "jpa-spring-boot"
        URL urlPost = new URL("http://localhost:8080/produits");
        HttpURLConnection connection = (HttpURLConnection) urlPost.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // d) Appeler le path d’ajout d’un nouveau produit avec la méthode "POST"
        Gson gson = new Gson();
        String produitJson = gson.toJson(produit);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(produitJson.getBytes());
            os.flush();
        }

        // Assurez-vous que la requête a bien été traitée
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de l'ajout du produit.");
            connection.disconnect();
            return;
        }
        connection.disconnect();

        // e) Appeler le path de récupération de tous les produits avec la méthode "GET"
        URL urlGet = new URL("http://localhost:8080/produits");
        HttpURLConnection connGet = (HttpURLConnection) urlGet.openConnection();
        connGet.setRequestMethod("GET");
        connGet.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
        StringBuilder jsonResponse = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonResponse.append(line);
        }
        reader.close();
        connGet.disconnect();

        // f) Convertir le tableau JSON en une liste d’objets Produit
        Type listType = new TypeToken<List<Produit>>() {}.getType();
        List<Produit> produits = gson.fromJson(jsonResponse.toString(), listType);

        // g) Placer cette liste comme un attribut dans la requête http
        request.setAttribute("produits", produits);

        // h) Rediriger l’affichage vers la page "listProduits.jsp"
        request.getRequestDispatcher("listProduits.jsp").forward(request, response);
    }
}
