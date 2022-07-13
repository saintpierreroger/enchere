<%--
  Created by IntelliJ IDEA.
  User: Adrien
  Date: 07/07/2022
  Time: 08:43
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
<!--formulaire d'inscription--->
<h2 class="titreProfil">Mon profil</h2>
<div class="formInscript">
    <form action="modifierCompte" method="post">
        <div>
            <label for="pseudo" class="labform">Pseudo : </label>
            <input type="text" name="pseudo" id="pseudo">
            <label for="nom" class="labform">Nom : </label>
            <input type="text" name="nom" id="nom">
        </div>
        <div>
            <label for="prenom" class="labform">Prénom :</label>
            <input type="text" name="prenom" id="prenom">
            <label for="mail" class="labform">Mail :</label>
            <input type="email" name="mail" id="mail">
        </div>
        <div>
            <label for="tel" class="labform">Téléphone : </label>
            <input type="tel" name="tel" id="tel">
            <label for="rue" class="labform">Rue : </label>
            <input type="text" name="rue" id="rue">
        </div>
        <div>
            <label for="codepostal" class="labform">Code Postal :</label>
            <input type="text" name="codepostal" id="codepostal">
            <label for="ville" class="labform">Ville :</label>
            <input type="text" name="ville" id="ville">
        </div>
        <div>
            <label for="password" class="labform">Mot de passe actuel</label>
            <input type="password" id="password" name="password">
            <label for="newPassword" class="labform">Nouveau Mot de passe :</label>
            <input type="password" name="newpassword" id="newPassword">
            <label for="confirm" class="labform">Confirmation :</label>
            <input type="password" name="confirm" id="confirm">
        </div>
        <input type="submit" value="creer" name="creer" class="buttonCreer">
    </form>
    <a href="${pageContext.request.contextPath}/supprimerCompte" class="btnSupprimer">Supprimer mon compte ⚠️</a>
</div>
<div>
    <a href="indexConnecter" class="btnAnnuler">Annuler</a>
</div>

</body>
</html>