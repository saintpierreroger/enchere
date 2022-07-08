<%--
  Created by IntelliJ IDEA.
  User: Adrien
  Date: 07/07/2022
  Time: 11:11
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
    <title>reinitialiser mdp</title>
</head>
<body>
<form action="lostpassword" method="post">
    <div>
        <label for="username">Pseudo :</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="mail">Email</label>
        <input type="text" name="mail" id="mail">
    </div>
    <div>
        <label for="newpassword">Nouveau mot de passe</label>
        <input type="password" name="lostPW" id="newpassword">
    </div>
    <div>
        <label for="confirm newPW">Confirmer le nouveau mot de passe</label>
        <input type="password" name="confirmLostPW" id="confirm newPW">
    </div>
    <input type="submit" value="Reinitialiser !">
</form>

</body>
</html>
