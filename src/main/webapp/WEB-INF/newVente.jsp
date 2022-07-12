<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="newVente.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<h1> Nouvelle vente </h1>
<form action="NewVente" method="post">
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
    <div>
        <label for="categorie">Catégorie : </label>
        <select name="categorie" id="categorie" size="1">
            <optgroup label="categorie">
                <option value="1">Informatique</option>
                <option value="2">Ameublement</option>
                <option value="3">Vêtement</option>
                <option value="4">Sport&Loisirs</option>
            </optgroup>
        </select>
    </div>

    </p>
    <label> Photo de l'article </label>
    <input type="file" id="photo">
    <p>
        Mise à prix:
        <input type="number" min="1" step="1" name="miseAprix">
    </p>
    <p>
        Début de l'enchère : <input type="date" name="debut" size="20">
        <br>
        Fin de l'enchère : <input type="date" name="fin" size="20">
    </p>
    <p>
    <fieldset>
        <c:forEach var="adresseRetrait" items="${adresse}">
            <legend>Retrait</legend>
            <div>
                <label for="article">Rue : </label>
                <input placeholder="${adresseRetrait.rue}" aria-label="${adresseRetrait.rue}" type="text" name="article"
                       id="rue">
            </div>
            <div>
                <label for="article">Code postal : </label>
                <input placeholder="${adresseRetrait.codePostal}" aria-label="${adresseRetrait.codePostal}" type="text"
                       name="article"
                       id="codePostal">
            </div>
            <div>
                <label for="article">Ville : </label>
                <input placeholder="${adresseRetrait.ville}" aria-label="${adresseRetrait.ville}" type="text"
                       name="article"
                       id="ville">
            </div>
        </c:forEach>
    </fieldset>
    <a href="${pageContext.request.contextPath}/DetailVente">Enregistrer</a>
    <a href="${pageContext.request.contextPath}/indexConnecter">annuler</a>
</form>

</body>
</html>
