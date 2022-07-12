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
<a href="index"><img src="media/img/logoEnchere.png" alt="logo" class="logo"></a>
<form action="connexionservlet" method="post" class="addAccount">
    <label for="username">Identifiant : </label>
    <input type="text" name="username" id="username" value="${login}">
    <label for="password">Mot de passe : </label>
    <input type="password" name="password" id="password">
    <div class="connexion">
        <input type="submit" value="Connexion" name="button" class="button">
        <div class="box">
            <input type="checkbox" name="box" id="box" checked>
            <label for="box"> Se souvenir de moi</label>
        </div>
        <a href="lostpassword" class="password"> Mot de passe oublié</a>
    </div>
</form>
<a href="compteServlet" class="creacompte">Créer un compte</a>

</body>
</html>