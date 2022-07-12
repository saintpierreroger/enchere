<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detailVente</title>
</head>
<body>
<h1>Détail vente</h1>
<form action="${pageContext.request.contextPath}/DetailVente" method="post">
    <img src="" alt="">
    <p>${detailsVente.nom_article}</p>
    <label aria-label="Description : ">${detailsVente.description}</label>
    <label aria-label="Catégorie : ">${detailsVente.libelle}</label>
    <label aria-label="Meilleure offre : ">${detailsVente.prix_vente}</label>
    <label aria-label="Mise à prix : ">${detailsVente.prix_initial}</label>
    <label aria-label="Fin de l'enchère : ">${detailsVente.date_fin_encheres}</label>
    <label aria-label="Retrait : ">
        
    </label>
    <label aria-label="Vendeur : ">${detailsVente.nom_article}</label>
</form>
</body>
</html>
