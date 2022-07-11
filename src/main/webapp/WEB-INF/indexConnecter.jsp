<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Liste des enchères</h1>

/// <a href="${pageContext.request.contextPath}/index">Enchères</a>
/// <a href="${pageContext.request.contextPath}/NewVente">Vendre un article</a>
/// <a href="${pageContext.request.contextPath}/">Mon profil</a>
/// <a href="${pageContext.request.contextPath}/index">Déconnexion</a>

<div class="container-fluid">
    <h2>Filtres :</h2>
    <form action="${pageContext.request.contextPath}/index" method="post" class="d-flex" role="search">
        <input class="form-control me-2" type="search" name="name" placeholder="Le nom de l'article contient">

        <div>
            <label for="filter">Catégorie : </label>
            <select name="filter" id="filter">
                <option value="1">Informatique</option>
                <option value="2">Ameublement</option>
                <option value="3">Vêtement</option>
                <option value="4">Sport&Loisirs</option>
            </select>
        </div>
        <div>
            <form name="" action="" method="post">
                <fieldset>
                    <legend>
                        <input type="radio" name="mode">Achats<br>
                        <input type="checkbox" name="ouvertes">enchères ouvertes<br>
                        <input type="checkbox" name="en cours">mes enchères en cours<br>
                        <input type="checkbox" name="reportées">mes enchères remportées<br>
                    </legend>
                </fieldset>
                <fieldset>
                    <legend>
                        <input type="radio" name="mode">Mes ventes<br>
                        <input type="checkbox" name="ouvertes">mes ventes en cours<br>
                        <input type="checkbox" name="en cours">mes ventes non débutées<br>
                        <input type="checkbox" name="reportées">ventes terminées<br>
                    </legend>
                </fieldset>
            </form>
        </div>
        <button class="btn btn-outline-success" type="submit">Rechercher</button>
    </form>
</div>

</body>
</html>
