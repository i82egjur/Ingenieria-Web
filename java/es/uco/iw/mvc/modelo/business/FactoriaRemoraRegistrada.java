package es.uco.iw.mvc.modelo.business;

import java.util.Vector;

public abstract class FactoriaRemoraRegistrada 
{
	public abstract RemoraRegistradaDTO createRemoraRegistrada(String nombreRemora, String apellidos,  String mail, 
			String password, String saltPassword, Integer telefono, 
			TipoRemora tipoRemora, Vector <String> skills);

}
