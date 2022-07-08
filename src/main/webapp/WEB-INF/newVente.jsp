<%--
  Created by IntelliJ IDEA.
  User: LAROGE
  Date: 07/07/2022
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nouvelle vente</title>
</head>
<body>
<form action="" method="">
    <p>
        <label for="article">Article : </label>
        <input type="text" name="article" id="article">
    </p>
    <p>
        <label for="desciption">Description : </label>
        <br>
        <textarea name="description" id="desciption" rows="10" cols="30"></textarea>
    </p>
    <p>
        <label for="categorie">Catégorie : </label>
        <select name="categorie" id="categorie" size="1">
            <optgroup label="categorie>">
                <option value="">
                <option value="">
            </optgroup>
        </select>
    </p>
    <label> Photo de l'article </label>
    <input type="file" id="photo">
    <p>
        Mise à prix:
        <input type="number" min="1" step="1">
    </p>
    <p>
        Début de l'enchère : <input type="date" name="debut" size="20">
        <br>
        Fin de l'enchère : <input type="date" name="fin" size="20">
    </p>
    <p>
        <form action="" method="">
            <legend>Retrait</legend>
            <label for="article">Rue : </label>
            <input type="text" name="article" id="rue">
            <label for="article">Code postal : </label>
            <input type="number" name="article" id="codePostal">
            <label for="article">Ville : </label>
            <input type="text" name="article" id="ville">

        </form>
    </p>
    <input type="submit" value="Enregistrer" name="enregistrer">
    <input type="submit" value="Annuler" name="annuler">

</form>
</div>

</body>
</html>
