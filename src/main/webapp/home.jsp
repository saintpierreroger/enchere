<%--
  Created by IntelliJ IDEA.
  User: Adrien
  Date: 07/07/2022
  Time: 08:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>Home</title>
</head>
<body>
<form action="servlet" method="get" class="addAccount">
    <label for="username">Identifiant : </label>
    <input type="text" name="username" id="username">
    <label for="password">Mot de passe : </label>
    <input type="text" name="password" id="password">
    <div>
        <input type="button" value="Connexion" name="button">
        <input type="checkbox" name="box" id="box" checked>
        <label for="box"> Se souvenir de moi</label>
        <a href="lostpassword"> Mot de passe oublié</a>
    </div>
</form>
<a href="compteServlet">Créer un compte</a>

</body>
</html>