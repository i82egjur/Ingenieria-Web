package es.uco.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
	private static Connection conn;
    
	/*Co	
	/**
	 * Metodo que conecta a nuestra base de datos, con los datos del properties
	 */
	public static void conectar()
	{
		try 
    	{
			
			
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = (Connection) DriverManager.getConnection(
							"jdbc:mysql://remoraid.ddns.net:3306/remoraid?characterEncoding=utf8",
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
	 */
	public static Connection getConnection ()
	{
		
		if (conn == null)
		{
			conectar();
		}
		return conn;
		
	}


   	
	 public static void main(String[] args) throws SQLException
	 {
		 conectar();
		 PreparedStatement ps = null;
		 ps=conn.prepareStatement("INSERT INTO `Remora-Registrada` (`Correo`, `Clave`, `Nombre`, `Apellidos`, `Telefono`, `TipoRemora`) VALUES ('asasdasddasd', '241', 'asdad', 'asdasd', '555555555', 'asdasd'); ");
		 ps.execute();
		 System.out.println("asdasdasd");
		 	
	 }
	

}
