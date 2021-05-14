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
import es.uco.iw.mvc.modelo.data.clienteTiburonToro.Proyecto.AnunciarProyecto;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;

public class EliminarProyectoDAO {
	
	DBconnectImpl dbConnect;
	Connection conexionBBDD;
	private Properties pSQL;
	
	public EliminarProyectoDAO(ServletContext servletContext) 
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
	
	public Integer borrarProyecto(int id) 
	{
		PreparedStatement subirProyecto = null;
		int status = 0;

		try
		{
			subirProyecto=conexionBBDD.prepareStatement(pSQL.getProperty("borrarProyecto"));
			subirProyecto.setInt(1, id);
						
			status = subirProyecto.executeUpdate();
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
