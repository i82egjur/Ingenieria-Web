<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Remoraid</title>
        <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/loginCSS.css">

    <link rel="shortcut icon" type="image/png" href="img/remoraid_logo.png"/>


    <script src="js/login.js"></script>
</head>

<body>

        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <img id="foto" src="img/remoraid_logo.png">

                    <h1 style="color: navy;">Login</h1>
                </div>
    
                <div class="login-form">
                    <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="mail" id="login-name">
                    <label class="login-field-icon fui-user" for="login-name"></label>
                    </div>
    
                    <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="contrase&ntilde;a" id="login-pass">
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                    </div>
    
                    <a class="btn btn-primary btn-large btn-block" href="#">INICIAR SESION</a>
                    <a class="login-link" href="#">¿Ha perdido su password?</a>
                </div>
            </div>
        </div>


 
</body>
</html>