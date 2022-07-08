<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <title>index</title>
</head>
<body>
<h1>Liste des enchères</h1>
<!-- Lien pour se connecter ou s'inscrire, renvoi vers la view home -->
<a href="${pageContext.request.contextPath}/connexionservlet">S'inscire - Se connecter</a>
<!-- Recherche à partir d'un mot clé du nom de l'article et du numéro de catégorie -->
<div class="container-fluid">
    <h2>Filtres :</h2>
    <form action="${pageContext.request.contextPath}/index" method="post" class="d-flex" role="search">
        <input class="form-control me-2" type="search" name="name" placeholder="Le nom de l'article contient"
               aria-label="Le nom de l'article contient">
        <div>
            <label for="filter">Catégorie : </label>
            <select name="filter" id="filter">
                <option value="1">Informatique</option>
                <option value="2">Ameublement</option>
                <option value="3">Vêtement</option>
                <option value="4">Sport&Loisirs</option>
            </select>
        </div>
        <button class="btn btn-outline-success" type="submit">Rechercher</button>
    </form>
</div>

<div>
    <c:forEach var="article" items="${articles}">
        <div class="card" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${article.nom_article}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${article.date_fin_encheres}</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">${article.pseudo}</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>