<%-- 
    Document   : login
    Created on : Mar 8, 2020, 1:46:03 PM
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        
    </head>
    <body id="mainBody">
        
        <div id="wrapper">
            <div id="contents">
                <div class="title">Inicio de sesión</div>
                <div class="form">
                    <form action="../api/login/tryLogin" method="POST">
                        <div class="wrapper-inputs">
                            <input type="text" class="username-input" placeholder="Usuario/ID" name="username"/>
                            <input type="password" class="password-input" placeholder="Contraseña" name="password" />
                        </div>
                        <div id="wrapper-submit-btn">
                            <input type="submit" class="submit-btn" value="Ingresar" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
