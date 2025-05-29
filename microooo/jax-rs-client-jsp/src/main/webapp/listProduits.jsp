<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h2>Liste des Produits</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.nom}</td>
                    <td>${produit.description}</td>
                    <td>${produit.prix}</td>
                    <td>
                        <a href="ListProduitsAction?action=editer&id=${produit.id}">Editer</a> |
                        <a href="ListProduitsAction?action=supprimer&id=${produit.id}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
