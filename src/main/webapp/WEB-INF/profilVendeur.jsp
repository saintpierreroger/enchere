<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profilVendeur</title>
</head>
<body>
<h1>Profil Vendeur</h1>

<p>Pseudo :${utilisateurs.pseudo}</p>
<p>Nom : ${utilisateurs.nom}</p>
<p>Prenom : ${utilisateurs.prenom}</p>
<p>Email : ${utilisateurs.mail}</p>
<p>Téléphone : ${utilisateurs.telephone}</p>
<p>Rue : ${utilisateurs.rue}</p>
<p>Code Postal : ${utilisateurs.codePostal}</p>
<p>Ville : ${utilisateurs.ville}</p>

</body>
</html>
