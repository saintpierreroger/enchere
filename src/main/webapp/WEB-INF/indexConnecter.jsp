<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<a href="indexConnecter"><img src="media/img/logoEnchere.png" alt="logo" class="logoIndex"></a>
<div class="menu">
    <a href="${pageContext.request.contextPath}/indexConnecter">Enchères</a>
    <a href="${pageContext.request.contextPath}/NewVente">Vendre un article</a>
    <a href="${pageContext.request.contextPath}/profilutilisateur">Mon profil</a>
    <a href="${pageContext.request.contextPath}/index">Déconnexion</a>
</div>
<h1 class="title">Liste des enchères</h1>


<div class="container-fluid">
    <div class="row">
        <div class="col-12 col-sm-3 d-flex justify-content-center">
            <div class="col-3 col-sm-3">
                <h2>Filtres :</h2>
                <form action="${pageContext.request.contextPath}/indexConnecter" method="post" role="search"
                      class="recherche">
                    <input class="form-control" type="search" name="name" placeholder="Le nom de l'article contient"
                           aria-label="Le nom de l'article contient">
                    <label for="filter" class="category">Catégorie :</label>
                    <select name="no_categorie" id="filter" class="category">
                        <option value="1">Informatique</option>
                        <option value="2">Ameublement</option>
                        <option value="3">Vêtement</option>
                        <option value="4">Sport&Loisirs</option>
                    </select>
                    <button class="btn btn-outline-success btn-sm" type="submit">Rechercher</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="trade">

    <legend>
        <div>
            <input type="radio" id="buy" name="buy" class="titreTrade">
            <label for="buy">Mes achats</label>
        </div>
        <div>
            <input type="checkbox" name="opened" id="opened">
            <label for="opened">Enchères ouvertes</label>
        </div>
        <div>
            <input type="checkbox" name="ongoing" id="ongoing">
            <label for="ongoing">Mes enchères en cours</label>
        </div>
        <div>
            <input type="checkbox" name="pushedBack" id="pushedBack">
            <label for="pushedBack">Mes enchères remportées</label>
        </div>
    </legend>
    <legend>
        <div>
            <input type="radio" name="buy" id="sell" class="titreTrade">
            <label for="sell">Mes ventes</label>
        </div>
        <div>
            <input type="checkbox" name="openedS" id="openedS">
            <label for="openedS">Ventes en cours</label>
        </div>
        <div>
            <input type="checkbox" name="ongoingS" id="ongoingS">
            <label for="ongoingS">Ventes non débutées</label>
        </div>
        <div>
            <input type="checkbox" name="pushedBackS" id="pushedBackS">
            <label for="pushedBackS">ventes terminées</label>
        </div>
    </legend>
</div>


<div>
    <c:forEach var="article" items="${articles}">
        <div class="card" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${article.nom_article}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${article.prix_vente}</li>
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
