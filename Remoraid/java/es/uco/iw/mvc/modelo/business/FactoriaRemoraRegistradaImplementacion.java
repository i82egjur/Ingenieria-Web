package es.uco.iw.mvc.modelo.business;

import java.util.Vector;

public class FactoriaRemoraRegistradaImplementacion extends FactoriaRemoraRegistrada
{
	public RemoraRegistradaDTO createRemoraRegistrada(String nombreRemora, String apellidos,  String mail, 
														String password, String saltPassword, Integer telefono, 
														TipoRemora tipoRemora, Vector <String> skills)
	{
		RemoraRegistradaDTO newRemoraRegistradaDTO = new RemoraRegistradaDTO(nombreRemora, apellidos, mail, 
																			password, saltPassword, telefono, 
																			tipoRemora, skills);
		return newRemoraRegistradaDTO;
		
	}
	
}
