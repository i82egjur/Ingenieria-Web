package es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT;

import es.uco.iw.mvc.modelo.business.ClienteTiburonToro;

public interface GestCTT 
{
	public void updateCTT(ClienteTiburonToro updateCliente);
	
	public void eraseCTT(String mail);
	
	public ClienteTiburonToro searchCTT(String mail);



}
