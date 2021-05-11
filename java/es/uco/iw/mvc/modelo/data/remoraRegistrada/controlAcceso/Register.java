package es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso;

import es.uco.iw.mvc.modelo.business.AdministradorTiburonBlanco;
import es.uco.iw.mvc.modelo.business.ClienteTiburonToro;

public interface Register {
	
	public void registrar(ClienteTiburonToro newCliente);
	public void registrar(AdministradorTiburonBlanco newATB);

}
