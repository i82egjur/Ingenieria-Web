<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Remoraid</title>
        <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<link href=<%= application.getContextPath()+("/css/loginCSS.css") %> type="text/css" rel="stylesheet"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jsSHA/2.0.2/sha.js"></script>
	<script src=<%=application.getContextPath()+("/js/passwdUtilities.js")%>></script>

</head>

<body>

        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <img id="foto" src="<%= application.getContextPath()+("/img/remoraid_logo.png") %>">

                    <h1 style="color: navy;">Registro</h1>
                </div>
    
                <form class="login-form" action=<%=application.getContextPath()+"/LoginController" %> method="post">
                    <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="mail" 
                    								name="login-mail" id="login-mail">
                    </div>
    
                    <div class="control-group">
                    <input type="password" class="login-field" value="" 
                    			placeholder="contrase&ntilde;a" name="login-pass" id="loginPasswd">
                    
                    </div>
    
                    <input type="submit" class="btn btn-primary btn-large btn-block" 
                    				onclick="cifrarLoginPasswd()" value="INICIAR SESIÓN" >
                    <a class="login-link" href="#">¿Ha perdido su password?</a>
                </form>
            </div>
        </div>


 
</body>
</html>