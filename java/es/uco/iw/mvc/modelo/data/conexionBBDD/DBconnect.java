package es.uco.iw.mvc.modelo.data.conexionBBDD;
import java.sql.Connection;

public interface DBconnect {
	
	public void conectar();
	
	public Connection getConnection();

}
