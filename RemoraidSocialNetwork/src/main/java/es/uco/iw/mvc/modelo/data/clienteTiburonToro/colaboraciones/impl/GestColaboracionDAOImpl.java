package es.uco.iw.mvc.modelo.data.clienteTiburonToro.colaboraciones.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Properties;

import es.uco.iw.mvc.modelo.data.clienteTiburonToro.colaboraciones.GestColaboracionDAO;
import es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;

public class GestColaboracionDAOImpl implements GestColaboracionDAO
{
	private Connection conexionBBDD;
	private Properties pSQL;
	
	public GestColaboracionDAOImpl()
	{
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
	
	public void registrarSolicitud(Integer idProyecto, String mailRemoraEmisora)
	{
		PreparedStatement registrarSolicitud = null;
		try
		{
			registrarSolicitud=conexionBBDD.prepareStatement(pSQL.getProperty("registrarSolicitud"));
			registrarSolicitud.setInt(1, idProyecto);
			registrarSolicitud.setString(2, mailRemoraEmisora);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Hashtable <String, Integer> mostrarSolicitudesRecibidas(String mailRemoraReceptora)
	{
		//En esta tabla hash, almacenamos el mail del solicitante y el id del proyecto sobre el que se quiere solicitar colaboracion
		Hashtable <String, Integer> solicitudes = new Hashtable <String, Integer>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			ps = conexionBBDD.prepareStatement(pSQL.getProperty("mostrarSolicitudesRecibidas"));
			ps.setString(1, mailRemoraReceptora);
			rs = ps.executeQuery();
			while (rs.next())
			{
				solicitudes.put(rs.getString(1), rs.getInt(2));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return solicitudes;
	}

	public void aceptarSolicitud(String mailRemoraAceptante, Integer idProyecto)
	{
		PreparedStatement aceptarSolicitud = null;
		try
		{
			aceptarSolicitud=conexionBBDD.prepareStatement(pSQL.getProperty("aceptarSolicitud"));
			aceptarSolicitud.setInt(1, idProyecto);
			aceptarSolicitud.setString(2, mailRemoraAceptante);
			aceptarSolicitud.executeQuery();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void denegarSolicitud(Integer idSolicitud)
	{
		PreparedStatement denegarSolicitud = null;
		try
		{
			denegarSolicitud=conexionBBDD.prepareStatement(pSQL.getProperty("eliminarSolicitud"));
			denegarSolicitud.setInt(1, idSolicitud);
			denegarSolicitud.executeQuery();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
