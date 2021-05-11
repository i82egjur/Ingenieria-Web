package es.uco.iw.mvc.modelo.data.remoraRegistrada.impl;

import java.sql.PreparedStatement;

import java.util.Properties;

import javax.servlet.ServletContext;

import es.uco.iw.mvc.modelo.business.RemoraRegistradaDTO;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;

import java.io.FileInputStream;

import java.sql.Connection;


public class RemoraDAO {
	
	DBconnectImpl dbConnect;
	Connection conexionBBDD;
	private Properties pSQL;

	
	public RemoraDAO(ServletContext servletContext) 
	{
		dbConnect = new DBconnectImpl();
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
	
	
	public Integer registrarRemora(RemoraRegistradaDTO remoraRegistradaDTO) 
	{
		PreparedStatement registrarRemora = null;
		int status = 0;

		try
		{
			registrarRemora=conexionBBDD.prepareStatement(pSQL.getProperty("registrarRemora"));
			registrarRemora.setString(1, remoraRegistradaDTO.getMail());
			registrarRemora.setString(2, remoraRegistradaDTO.getApellidos());
			registrarRemora.setInt(3, remoraRegistradaDTO.getTelefono());
			registrarRemora.setString(4, remoraRegistradaDTO.getTipoRemora().toString());
			
			registrarRemora.setString(5, remoraRegistradaDTO.getPassword());
			registrarRemora.setString(6, remoraRegistradaDTO.getSaltPassword());
			status = registrarRemora.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
