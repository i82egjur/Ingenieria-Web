<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Remoraid</title>
        <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href=<%= application.getContextPath()+("/css/registrar.css") %> >
    <link rel="shortcut icon" type="image/png" href=<%= application.getContextPath()+("/img/remoraid_logo.png") %> />

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jsSHA/2.0.2/sha.js"></script>
	          <script src=<%=application.getContextPath()+("/js/passwdUtilities.js")%>></script>
	

</head>

<body>

        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                
                    <img id="foto" src=<%= application.getContextPath()+("/img/remoraid_logo.png") %>>

                    <h1 style="color: navy;">Registrar usuario</h1>
                </div>
                <form name="formularioRegistro" action=<%=application.getContextPath()+"/RegistroController" %>  method="post">
	
	                <div class="login-form">
	                   <table>
	                    <tr class="control-group">
	                        <td><label for="nombre">Nombre:</label></td>
	                        <td> <input type="text" class="login-field" name="nombre" value="" placeholder="Nombre" id="nombre"></td>
	                    </tr>
	
	                
	                    <tr class="control-group">
	                        <td><label for="apellidos">Apellidos:</label></td>
	                        <td><input type="text" class="login-field" name="apellidos" value="" placeholder="Apellidos" id="apellidos"></td>
	                    </tr>
	               
	
	                    <tr class="control-group">
	                        <td><label for="password">Password:</label></td>
	                        <td><input type="password" class="login-field" name="password" value="" placeholder="contrase&ntilde;a" id="password"></td>
	                    </tr>
	                      
	                      <tr class="control-group">
	                        <td><label  for="mail">Mail:</label></td>
	                        <td><input type="email" class="login-field" name="mail" value="" placeholder="Mail" id="mail"></td>
	                    </tr>
	         
	
	                    <tr class="control-group">
	                        <td><label for="nombre">Comprobar <br>Password: </label></td>
	                        <td><input type="password" class="login-field" name="checkPassword" value="" placeholder="check" id="checkPassword"></td>
	                    </tr>
	
	                    <tr class="control-group">
	                        <td><label style="text-align: left;" for="nombre">Telefono:</label></td>
	                        <td><input type="text" class="login-field" name="telefono" value="" placeholder="Telefono" id="telefono"></td>
	                    </tr>
	         
	
	                    <tr class="control-group">
	                        <td><label for="nombre">Skills:</label></td>
	                        <td><select name="intereses" size="5" multiple>
	                            <option value=#>Programacion</option>
	                            <option value=#>Ilustracion</option>
	                            <option value=#>Novelas</option>
	
	                        </select></td>
	                    </tr>
	           
	                </table>
	                	<input type="hidden" name="salt" id="salt">
	                
	                    <h5> Seleccione varios usando la tecla Control (si su equipo es MAc use la tecla Command) </h5><br>
	                    <input type="submit" class="btn btn-primary btn-large btn-block" onclick="validarFormularioRegistroUsuario()" value="INICIAR SESION" /><br>
          		</div>
          	</form>
                
         </div>
     
         </div>

	     
                       
                  
 
</body>
</html>