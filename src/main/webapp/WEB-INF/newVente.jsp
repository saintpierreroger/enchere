<%--
  Created by IntelliJ IDEA.
  User: LAROGE
  Date: 07/07/2022
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>

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
        <input type="number" min="1" step="1" name="miseAprix">
    </p>
    <p>
        Début de l'enchère : <input type="date" name="debut" size="20">
        <br>
        Fin de l'enchère : <input type="date" name="fin" size="20">
    </p>
    <p>
    <fieldset>
        <legend>Retrait</legend>
        <div>
            <label for="article">Rue : </label>
            <input type="text" name="article" id="rue">
        </div>
        <div>
            <label for="article">Code postal : </label>
            <input type="number" name="article" id="codePostal">
        </div>
        <div>
            <label for="article">Ville : </label>
            <input type="text" name="article" id="ville">
        </div>
    </fieldset>
    </p>
    <a href="">Enregistrer</a>
    <a href="${pageContext.request.contextPath}/index">annuler</a>

</form>
</div>

</body>
</html>