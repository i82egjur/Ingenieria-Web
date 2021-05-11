package es.uco.iw.mvc.modelo.data.remoraRegistrada.GestInformacionRemora;

import es.uco.iw.mvc.modelo.business.EstadoRemora;
import es.uco.iw.mvc.modelo.business.RemoraRegistradaDTO;

public interface GestRemora
{
	public int register(RemoraRegistradaDTO remoraRegistrada);
	
	public int updateRemora(RemoraRegistradaDTO remoraRegistrada);
	
	public int deleteRemora(String mail);

	public RemoraRegistradaDTO  buscarRemora(String mail);

	public boolean existsRemora(String mail);
	
	public EstadoRemora getEstadoRemora(String mail);


}
