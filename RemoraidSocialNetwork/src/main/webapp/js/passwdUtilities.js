function generarCadenaAleatoria()
{
   var result           = '';
   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
   var charactersLength = characters.length;
   for ( var i = 0; i < 6; i++ ) 
	{
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
   }
   return result;
};


function encriptarCadena(cadena)
{
	  var cadenaEncriptada;
	  var objetoHash = new jsSHA("SHA-512", "TEXT", {numRounds: 1});
	  objetoHash.update(cadena);
	  cadenaEncriptada = objetoHash.getHash("HEX");
  

	  return cadenaEncriptada;
};


function validarFormularioRegistroUsuario() {

  var saltHTML = document.getElementById('salt');
  var saltSinEncriptar = generarCadenaAleatoria();
  var saltEncriptado = encriptarCadena(saltSinEncriptar);
  saltHTML.value = saltEncriptado;
	
  var passwd = document.getElementById('password');
  var passwdEncriptado = encriptarCadena(passwd.value);

  var passwdFinal = passwdEncriptado.concat('', saltEncriptado);

  passwdFinal = encriptarCadena(passwdFinal);


  passwd.value = passwdFinal;
  return true;
};

function cifrarLoginPasswd()
{
	var loginPasswdSinFormato = document.getElementById('loginPasswd');
	var loginPasswdEncriptada = encriptarCadena(loginPasswdSinFormato.value);
	loginPasswdSinFormato.value = loginPasswdEncriptada;

}
