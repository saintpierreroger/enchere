<%--
  Created by IntelliJ IDEA.
  User: LAROGE
  Date: 08/07/2022
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Document</title>
</head>
<body>
<div class="profil">
    <p class="pseudo">Pseudo : ${utilisateurs.pseudo}</p>
    <p>Nom : ${utilisateurs.nom}</p>
    <p>Prenom : ${utilisateurs.prenom}</p>
    <p>Email : ${utilisateurs.mail}</p>
    <p>Téléphone : ${utilisateurs.telephone}</p>
    <p>Rue : ${utilisateurs.rue}</p>
    <p>Code Postal : ${utilisateurs.codePostal}</p>
    <p>Ville : ${utilisateurs.ville}</p>
</div>
<a href="${pageContext.request.contextPath}/modifierCompte" class="modifier">Modifier</a>
<a href="${pageContext.request.contextPath}/indexConnecter" class="modifier">Retour</a>
</body>
</html>
