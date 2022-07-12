<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detailVente</title>
</head>
<body>
<h1>Détail vente</h1>
<!-- from recupèrant les données du contructeur DetailVente.java et affichage des données en fonction de l'article
sur lequel on a cliqué -->
<form action="${pageContext.request.contextPath}/DetailVente" method="get">
    <img src="" alt="">
    <p>${detailsVente.nom_article}</p>
    <label aria-label="Description : ">${detailsVente.description}</label>
    <label aria-label="Catégorie : ">${detailsVente.libelle}</label>
    <label aria-label="Meilleure offre : ">${detailsVente.prix_vente}</label>
    <label aria-label="Mise à prix : ">${detailsVente.prix_initial}</label>
    <label aria-label="Fin de l'enchère : ">${detailsVente.date_fin_encheres}</label>
    <label aria-label="Retrait : ">
        ${adresse.rue}
        ${adresse.code_postale}${adresse.ville}
    </label>
    <!-- Le lien affiche le nom du vendeur de l'article et il
renvoit également sur la page profil du vendeur si on clique dessus -->
    <label aria-label="Vendeur : "><a
            href="${pageContext.request.contextPath}/ProfilVendeur?id=${detailsVente.no_utilisateur}">${detailsVente.pseudo}</a>
    </label>
</form>
<form action="${pageContext.request.contextPath}/DetailVente" method="post">
    <c:if test="${detailsVente.no_utilisateur == noUtilisateur}">
        <a href="${pageContext.request.contextPath}/NewVente">Modifier</a>
    </c:if>
    <c:if test="${detailsVente.no_utilisateur != noUtilisateur}">
        <label for="encheres">Enchérir</label>
        <input id="encheres" type="number">
    </c:if>
    <a href="${pageContext.request.contextPath}/indexConnecter">Retour</a>
</form>
</body>
</html>
