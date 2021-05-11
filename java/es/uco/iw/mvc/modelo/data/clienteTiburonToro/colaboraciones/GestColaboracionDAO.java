package es.uco.iw.mvc.modelo.data.clienteTiburonToro.colaboraciones;

import java.util.Hashtable;

public interface GestColaboracionDAO 
{	
	public void registrarSolicitud(Integer idProyecto, String mailRemoraEmisora);

	public Hashtable <String, Integer> mostrarSolicitudesRecibidas(String mailRemoraReceptora);
	
	public void aceptarSolicitud(String mailRemoraAceptante, Integer idProyecto);
	
	public void denegarSolicitud(Integer idSolicitud);
	
}
