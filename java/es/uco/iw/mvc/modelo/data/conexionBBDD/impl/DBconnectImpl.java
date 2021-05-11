package es.uco.iw.mvc.modelo.data.conexionBBDD.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;


public class DBconnectImpl implements DBconnect
{
	private Connection conn;
	
	public DBconnectImpl()
	{
		conectar();
	}
    
	/*Co	
	/**
	 * Metodo que conecta a nuestra base de datos, con los datos del properties
	 */
	public void conectar()
	{
		try 
    	{
			
			
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = (Connection) DriverManager.getConnection(
							"jdbc:mysql://remoraid.ddns.net:3306/remoraid?characterEncoding=utf8&useSSL=false",
							"remoraid",
							"remoraid");  
    	} 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {        	
            e.printStackTrace();
        }
		
	}
	/**
	 * Metodo getConnection que devuelve una conexion a la base de datos
	 * @return con -> Devuelve una conexion a la BBDD
	 * @author Jesus Izquierdo Estevez
     * @author Rafael Egea Jurado
	 * @param servletContext 
	 * @return 
	 */
	public Connection getConnection ()
	{
		
		if (conn == null)
		{
			conectar();
		}
		return conn;
		
	}


   	
	
	

}
