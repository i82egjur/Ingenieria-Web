package es.uco.iw.mvc.modelo.data.administradorTiburonBlanco.gestATB.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletContext;

import es.uco.iw.mvc.modelo.business.AdministradorTiburonBlanco;
import es.uco.iw.mvc.modelo.business.ClienteTiburonToro;
import es.uco.iw.mvc.modelo.business.EstadoRemora;
import es.uco.iw.mvc.modelo.business.RemoraRegistradaDTO;
import es.uco.iw.mvc.modelo.business.TipoRemora;
import es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.GestInformacionRemora.GestRemora;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso.Register;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.impl.GestRemoraImpl;

public class GestATBImpl implements Register 
{
	private GestRemora gestorRemora;
	Connection conexionBBDD;
	private Properties pSQL;

	public GestATBImpl(ServletContext contextoServlet)
	{
		gestorRemora = new GestRemoraImpl(contextoServlet);
		DBconnect dbConnect = new DBconnectImpl();
		conexionBBDD = dbConnect.getConnection();
		pSQL = new Properties();
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
	public void registrar(AdministradorTiburonBlanco newATB)
	{
		gestorRemora.register(new RemoraRegistradaDTO(newATB.getNombreRemora(), newATB.getApellidos(),
														newATB.getMail(), newATB.getPassword(),
														newATB.getSaltPassword(), newATB.getTelefono(),
														TipoRemora.AdministradorTiburonBlanco, EstadoRemora.Permitido));
	}
	
	
	public void updateATB(AdministradorTiburonBlanco updateATB)
	{
		gestorRemora.updateRemora(new RemoraRegistradaDTO(updateATB.getNombreRemora(), updateATB.getApellidos(),
															updateATB.getMail(), updateATB.getPassword(),
															updateATB.getSaltPassword(), updateATB.getTelefono(),
															TipoRemora.AdministradorTiburonBlanco, updateATB.getEstado()));
	}
	
	public void eraseATB(String mail)
	{
		gestorRemora.deleteRemora(mail);

	}
	
	
	public AdministradorTiburonBlanco searchATB(String mail)
	{
		RemoraRegistradaDTO remoraBuscada = gestorRemora.buscarRemora(mail);
		AdministradorTiburonBlanco adminBuscado = 
								new AdministradorTiburonBlanco(remoraBuscada.getNombreRemora(), remoraBuscada.getApellidos(),
																remoraBuscada.getMail(), remoraBuscada.getPassword(),
																remoraBuscada.getSaltPassword(), remoraBuscada.getTelefono(), remoraBuscada.getEstado());
		return adminBuscado;
	}

	@Override
	public void registrar(ClienteTiburonToro newCliente) {
		
	}


}
