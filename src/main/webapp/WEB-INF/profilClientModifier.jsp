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
    <title>Document</title>
</head>
<body>
<p>Pseudo :${utilisateur.pseudo}</p>
<p>Nom : ${utilisateur.nom}</p>
<p>Prenom : ${utilisateur.prenom}</p>
<p>Email : ${utilisateur.mail}</p>
<p>Téléphone : ${utilisateur.telephone}</p>
<p>Rue : ${utilisateur.rue}</p>
<p>Code Postal : ${utilisateur.codePostal}</p>
<p>Ville : ${utilisateur.ville}</p>
<a href="${pageContext.request.contextPath}/modifierCompte">Modifier</a>
</body>
</html>
