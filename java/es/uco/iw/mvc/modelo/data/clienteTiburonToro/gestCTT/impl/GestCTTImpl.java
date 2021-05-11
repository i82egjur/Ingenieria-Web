package es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.impl;


import java.util.Vector;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.servlet.ServletContext;

import es.uco.iw.mvc.modelo.business.AdministradorTiburonBlanco;
import es.uco.iw.mvc.modelo.business.ClienteTiburonToro;
import es.uco.iw.mvc.modelo.business.EstadoRemora;
import es.uco.iw.mvc.modelo.business.PromocionRemoraDTO;
import es.uco.iw.mvc.modelo.business.RemoraRegistradaDTO;
import es.uco.iw.mvc.modelo.business.TipoRemora;
import es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.GestCTT;
import es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.GestSkillCtt;
import es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.PromocionarUsuario;
import es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.GestInformacionRemora.GestRemora;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso.Register;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.impl.GestRemoraImpl;


public class GestCTTImpl  implements PromocionarUsuario, GestCTT, Register  
{
	private GestRemora gestorRemora;
	private GestSkillCtt gestorSkills;
	private Connection conexionBBDD;
	private Properties pSQL;
	 
	 public GestCTTImpl(ServletContext contextoServlet)
	 {
	      gestorSkills = new GestSkillCTTImpl();
		  gestorRemora = new GestRemoraImpl(contextoServlet);
		  DBconnect dbConnect = new DBconnectImpl();
		  conexionBBDD = dbConnect.getConnection();
		  pSQL = new Properties();
		  conexionBBDD = dbConnect.getConnection();
		  try
		  {
				
			String path = this.getClass().getResource("../../../../sql.properties").toURI().getPath();
			System.out.println(path);
			pSQL.load(new FileInputStream(path));
		  }
		  catch (Exception e)
		  {
			 e.printStackTrace();
		  }
		
	 }
	 
	@Override
	public void registrar(ClienteTiburonToro newCliente)
	{
		gestorRemora.register(new RemoraRegistradaDTO(newCliente.getNombreRemora(), newCliente.getApellidos(),
													newCliente.getMail(), newCliente.getPassword(),
													newCliente.getSaltPassword(), newCliente.getTelefono(),
													TipoRemora.ClienteTiburonToro, EstadoRemora.Permitido));
		gestorSkills.addSkill(newCliente.getMail(), newCliente.getSkills());
		
	}
	
	
	public void updateCTT(ClienteTiburonToro updateCliente)
	{
		gestorRemora.updateRemora(new RemoraRegistradaDTO(updateCliente.getNombreRemora(), updateCliente.getApellidos(),
														updateCliente.getMail(), updateCliente.getPassword(),
														updateCliente.getSaltPassword(), updateCliente.getTelefono(),
														TipoRemora.ClienteTiburonToro, updateCliente.getEstado()));
		gestorSkills.addSkill(updateCliente.getMail(), updateCliente.getSkills());
												
	}
	
	public void eraseCTT(String mail)
	{
		gestorRemora.deleteRemora(mail);
	}
	
	
	public ClienteTiburonToro searchCTT(String mail)
	{
		RemoraRegistradaDTO remoraBuscada = gestorRemora.buscarRemora(mail);
		Vector <String> skillsRemoraBuscada = gestorSkills.getSkillsRemora(mail);
		
		ClienteTiburonToro clienteBuscado = new ClienteTiburonToro(remoraBuscada.getNombreRemora(), remoraBuscada.getApellidos(),
																remoraBuscada.getMail(), remoraBuscada.getPassword(),
																remoraBuscada.getSaltPassword(), remoraBuscada.getTelefono(),
																skillsRemoraBuscada, remoraBuscada.getEstado());
		return clienteBuscado;
	}

	public void promocionarUsuario(PromocionRemoraDTO promocionRemora)
	{
		PreparedStatement promocionarUsuarioStatement = null;
	
		try
		{
			promocionarUsuarioStatement=conexionBBDD.prepareStatement(pSQL.getProperty("promocionarUsuario"));
			promocionarUsuarioStatement.setString(1, promocionRemora.getCorreoRemoraPromocionada());
			promocionarUsuarioStatement.setString(2, promocionRemora.getDescripcionPromocion());
			promocionarUsuarioStatement.setDate(3, promocionRemora.getFechaFinal());
			promocionarUsuarioStatement.setDate(4, promocionRemora.getFechaInicio());
			promocionarUsuarioStatement.executeUpdate();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	@Override
	public void registrar(AdministradorTiburonBlanco newATB) {
		
	}	
}
