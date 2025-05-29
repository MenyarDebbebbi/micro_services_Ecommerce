package ws.rest.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet("/ListProduitsAction")
public class ListProduitsAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if ("supprimer".equals(action) && id != null) {
            supprimerProduit(id);
        }

        if ("editer".equals(action) && id != null) {
            // Redirection vers la page d'édition (à implémenter)
            response.sendRedirect("editProduit.jsp?id=" + id);
            return;
        }

        // Après suppression, recharger la liste des produits
        request.setAttribute("produits", getProduits());
        request.getRequestDispatcher("listProduits.jsp").forward(request, response);
    }

    private void supprimerProduit(String id) throws IOException {
        URL url = new URL("http://localhost:8080/produits/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.connect();
        connection.disconnect();
    }

    private List<Produit> getProduits() throws IOException {
        URL url = new URL("http://localhost:8080/produits");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonResponse = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonResponse.append(line);
        }
        reader.close();
        connection.disconnect();

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse.toString(), List.class);
    }
}
