package es.uco.iw.mvc.modelo.data.remoraRegistrada.impl;

import es.uco.iw.mvc.modelo.data.remoraRegistrada.GestInformacionRemora.GestRemora;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletContext;

import es.uco.iw.mvc.modelo.business.EstadoRemora;
import es.uco.iw.mvc.modelo.business.RemoraRegistradaDTO;
import es.uco.iw.mvc.modelo.business.TipoRemora;
import  es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;



public class GestRemoraImpl  implements GestRemora
{
	private Connection con;
	private Properties pSQL;
	
	
	public GestRemoraImpl(ServletContext contextoServlet)
	{
		DBconnect dbConnect = new DBconnectImpl();
		con = dbConnect.getConnection();
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
	
	public int register(RemoraRegistradaDTO remoraRegistrada)
	{
		PreparedStatement registrarRemora = null;
		int status = 0;

		try
		{
			registrarRemora=con.prepareStatement(pSQL.getProperty("registrarRemora"));
			registrarRemora.setString(1, remoraRegistrada.getMail());
			registrarRemora.setString(2, remoraRegistrada.getApellidos());
			registrarRemora.setInt(3, remoraRegistrada.getTelefono());
			registrarRemora.setString(4, remoraRegistrada.getTipoRemora().toString());
			registrarRemora.setString(5, remoraRegistrada.getPassword());
			registrarRemora.setString(6, remoraRegistrada.getSaltPassword());
			status = registrarRemora.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	
	}
	
	

	public int updateRemora(RemoraRegistradaDTO remoraRegistrada)
	{
		PreparedStatement registrarRemora = null;
		int status = 0;

		try
		{
			registrarRemora=con.prepareStatement(pSQL.getProperty("updateRemora"));
			registrarRemora.setString(1, remoraRegistrada.getMail());
			registrarRemora.setString(2, remoraRegistrada.getApellidos());
			registrarRemora.setInt(3, remoraRegistrada.getTelefono());
			registrarRemora.setString(4, remoraRegistrada.getTipoRemora().toString());
			registrarRemora.setString(5, remoraRegistrada.getPassword());
			registrarRemora.setString(6, remoraRegistrada.getSaltPassword());
			status = registrarRemora.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	
	}
	
	public int deleteRemora(String mail)
	{
		PreparedStatement registrarRemora = null;
		int status = 0;

		try
		{
			registrarRemora=con.prepareStatement(pSQL.getProperty("delete"));
			registrarRemora.setString(1, mail);
			status = registrarRemora.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	

	
	public RemoraRegistradaDTO  buscarRemora(String mail)
	{
		ResultSet rs = null;
		PreparedStatement ps = null;
		RemoraRegistradaDTO remoraRegistrada = null;
		
		try
		{
			ps = con.prepareStatement(pSQL.getProperty("buscarRemora"));
			ps.setString(1, mail);
		    rs = ps.executeQuery();
			if (!rs.wasNull())
			{
				remoraRegistrada = new RemoraRegistradaDTO(rs.getString(1), rs.getString(2),
															rs.getString(3), rs.getString(4), 
															rs.getString(5),  rs.getInt(6), 
															 TipoRemora.valueOf(rs.getString(7)), 
															 EstadoRemora.valueOf(rs.getString(8)));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return remoraRegistrada;
	}
	
	public boolean existsRemora(String mail)
	{
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try
		{
			ps = con.prepareStatement(pSQL.getProperty("existsRemora"));
			ps.setString(1, mail);
		    rs = ps.executeQuery();
			if (!rs.wasNull())
			{
				return true;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}
	
	public EstadoRemora getEstadoRemora(String mail)
	{
		
		String estadoRemora = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try
		{
			ps = con.prepareStatement(pSQL.getProperty("getEstadoRemora"));
			ps.setString(1, mail);
		    rs = ps.executeQuery();
			if (!rs.wasNull())
			{
				estadoRemora = rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return EstadoRemora.valueOf(estadoRemora);
	}
}

















