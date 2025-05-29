<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Produit</title>
</head>
<body>
    <h1>Formulaire d'ajout de produit</h1>
    <form action="FormProduitAction" method="POST">
        <label for="nom">Nom : </label>
        <input type="text" name="nom" id="nom" required /><br><br>

        <label for="description">Description : </label>
        <input type="text" name="description" id="description" required /><br><br>

        <label for="prix">Prix : </label>
        <input type="text" name="prix" id="prix" required /><br><br>

        <button type="submit">Ajouter Produit</button>
    </form>
</body>
</html>
