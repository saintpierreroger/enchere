<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
    <title>detailVente</title>
</head>
<body>
<h1>Détail vente</h1>
<!-- form recupèrant les données du contructeur DetailVente.java et affichage des données en fonction de l'article
sur lequel on a cliqué -->
<form action="${pageContext.request.contextPath}/DetailVente" method="get">
    <img src="" alt="">
    <h2>${detailsVente.nom_article}</h2>
    <p>Description : ${detailsVente.description}</p>
    <p>Catégorie : ${detailsVente.libelle}</p>
    <p>Meilleure offre : ${detailsVente.prix_vente}</p>
    <p>Mise à prix : ${detailsVente.prix_initial}</p>
    <p>Fin de l'enchère : ${detailsVente.date_fin_encheres}</p>
    <p>Retrait : ${adresse.rue}
        ${adresse.code_postal}${adresse.ville}</p>
    <!-- Le lien affiche le nom du vendeur de l'article et il
renvoit également sur la page profil du vendeur si on clique dessus -->
    <label aria-label="Vendeur : "><a
            href="${pageContext.request.contextPath}/ProfilVendeur?id=${detailsVente.no_utilisateur}">${detailsVente.pseudo}</a>
    </label>
</form>
<!-- Cette condition permet de modifier la vente si l'id utilisateur est le même que celui du vendeur
d'enchérir si on les 2 id sont différents et si les id sont null juste de pouvoir retourner sur la page d'accueil-->
<form action="${pageContext.request.contextPath}/DetailVente" method="post">
    <c:if test="${detailsVente.no_utilisateur == noUtilisateur}">
        <a href="${pageContext.request.contextPath}/NewVente">Modifier</a>
        <a href="${pageContext.request.contextPath}/indexConnecter">Retour</a>
    </c:if>
    <c:if test="${detailsVente.no_utilisateur != noUtilisateur}">
        <c:if test="${noUtilisateur != null}">
            <input name="montant_enchere" id="encheres" type="number">
            <button class="btn btn-outline-success" type="submit">Enchérir</button>
            <a href="${pageContext.request.contextPath}/indexConnecter">Retour</a>
        </c:if>
    </c:if>
    <c:if test="${noUtilisateur == null}">
        <a href="${pageContext.request.contextPath}/index">Retour</a>
    </c:if>
</form>
</body>
</html>
