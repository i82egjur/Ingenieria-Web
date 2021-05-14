package es.uco.iw.mvc.modelo.data.clienteTiburonToro.Proyecto.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;

import es.uco.iw.mvc.modelo.business.ProyectoDTO;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;

public class ActualizarProyectoDAO {
	
	DBconnectImpl dbConnect;
	Connection conexionBBDD;
	private Properties pSQL;
	
	public ActualizarProyectoDAO(ServletContext servletContext) 
	{
		dbConnect = new DBconnectImpl(servletContext);

		pSQL = new Properties();
		conexionBBDD = dbConnect.getConnection();
		try
		{
			
			String path = this.getClass().getResource(servletContext.getInitParameter("pathProperties")).toURI().getPath();
			pSQL.load(new FileInputStream(path));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public Integer actualizarProyecto(ProyectoDTO proyectoDTO, int id) 
	{
		PreparedStatement subirProyecto = null;
		int status = 0;

		try
		{
			subirProyecto=conexionBBDD.prepareStatement(pSQL.getProperty("actualizarProyecto"));
			subirProyecto.setString(1, proyectoDTO.getTitulo());
			subirProyecto.setString(2, proyectoDTO.getDescripcion());
			subirProyecto.setInt(3, id);
			
			status = subirProyecto.executeUpdate();
			
			actualizarProyectoSkills(proyectoDTO, id);
			actualizarProyectoTematicas(proyectoDTO, id);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	private void actualizarProyectoSkills(ProyectoDTO proyectoDTO, int id) 
	{
		PreparedStatement actualizarProyectoSkills = null;
			
		try
		{
			actualizarProyectoSkills=conexionBBDD.prepareStatement(pSQL.getProperty("borrarProyectoSkills"));
			actualizarProyectoSkills.setInt(1, id);
			actualizarProyectoSkills.executeUpdate();
			
			
			for(String string : proyectoDTO.getSkills()) {
				
				actualizarProyectoSkills=conexionBBDD.prepareStatement(pSQL.getProperty("subirProyectoSkills"));
				actualizarProyectoSkills.setInt(1, id);
				actualizarProyectoSkills.setString(2, string);
								
				actualizarProyectoSkills.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void actualizarProyectoTematicas(ProyectoDTO proyectoDTO, int id) 
	{
		PreparedStatement actualizarProyectoTematicas = null;
	
		try
		{
			actualizarProyectoTematicas=conexionBBDD.prepareStatement(pSQL.getProperty("borrarProyectoTematicas"));
			actualizarProyectoTematicas.setInt(1, id);
			actualizarProyectoTematicas.executeUpdate();
			
			for(String string : proyectoDTO.getTematicas()) {
				
				actualizarProyectoTematicas=conexionBBDD.prepareStatement(pSQL.getProperty("subirProyectoTematicas"));
				actualizarProyectoTematicas.setInt(1, id);
				actualizarProyectoTematicas.setString(2, string);
								
				actualizarProyectoTematicas.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public Integer compartir(byte[] multimedia) 
	{
		PreparedStatement subirMultimedia = null;
		int status = 0;

		try
		{
			subirMultimedia=conexionBBDD.prepareStatement(pSQL.getProperty("insertarFoto"));
			subirMultimedia.setString(1, "foto");
			subirMultimedia.setBytes(2, multimedia);
	
			
			status = subirMultimedia.executeUpdate();
			              
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}	
