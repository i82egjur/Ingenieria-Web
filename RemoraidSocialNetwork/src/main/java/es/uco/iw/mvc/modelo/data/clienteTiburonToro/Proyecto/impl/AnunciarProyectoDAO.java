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

public class AnunciarProyectoDAO {

	DBconnectImpl dbConnect;
	Connection conexionBBDD;
	private Properties pSQL;
	
	public AnunciarProyectoDAO(ServletContext servletContext) 
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
	
	
	public Integer subirProyecto(ProyectoDTO proyectoDTO) 
	{
		PreparedStatement subirProyecto = null;
		int status = 0;

		try
		{
			subirProyecto=conexionBBDD.prepareStatement(pSQL.getProperty("subirProyecto"), Statement.RETURN_GENERATED_KEYS);
			subirProyecto.setString(1, proyectoDTO.getTitulo());
			subirProyecto.setString(2, proyectoDTO.getDescripcion());
			subirProyecto.setString(3, proyectoDTO.getPropietario());
			
			status = subirProyecto.executeUpdate();
			
			try (ResultSet generatedKeys = subirProyecto.getGeneratedKeys()) {

                if (generatedKeys.next()) {

                    int id;
                    id = generatedKeys.getInt(1);

                    System.out.println("ID del Proyecto: " + "<" + id + ">");          
                    
                    subirProyectoSkills(proyectoDTO, id);
                    subirProyectoTematicas(proyectoDTO, id);

                }

                else {
                    throw new SQLException("Creating proyect failed, no ID obtained.");
                }
            }
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public void subirProyectoSkills(ProyectoDTO proyectoDTO, int id) 
	{
		PreparedStatement subirProyectoSkills = null;
	
		try
		{
			for(String string : proyectoDTO.getSkills()) {
				
				subirProyectoSkills=conexionBBDD.prepareStatement(pSQL.getProperty("subirProyectoSkills"));
				subirProyectoSkills.setInt(1, id);
				subirProyectoSkills.setString(2, string);
								
				subirProyectoSkills.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void subirProyectoTematicas(ProyectoDTO proyectoDTO, int id) 
	{
		PreparedStatement subirProyectoTematicas = null;
	
		try
		{
			for(String string : proyectoDTO.getTematicas()) {
				
				subirProyectoTematicas=conexionBBDD.prepareStatement(pSQL.getProperty("subirProyectoTematicas"));
				subirProyectoTematicas.setInt(1, id);
				subirProyectoTematicas.setString(2, string);
								
				subirProyectoTematicas.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
