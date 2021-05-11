package es.uco.iw.mvc.modelo.data.remoraRegistrada.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.servlet.ServletContext;

import  es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso.Login;
import es.uco.iw.mvc.modelo.business.EstadoRemora;
import  es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.GestInformacionRemora.GestRemora;



public class LoginRemoraDAO implements Login
{
	private Connection con;
	private Properties pSQL;
	private GestRemora gestorRemora;
	
	public LoginRemoraDAO(ServletContext contextoServlet)
	{
		gestorRemora = new GestRemoraImpl(contextoServlet);
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

	private String getSalt(String mail)
	{
		String salt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try
		{
			ps = con.prepareStatement(pSQL.getProperty("getSalt"));
			ps.setString(1, mail);
		    rs = ps.executeQuery();
			if (!rs.wasNull())
			{
				salt = rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return salt;
	}

	
	private String getPasswdEncript(String mail)
	{
		String remoraPasswd = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try
		{
			ps = con.prepareStatement(pSQL.getProperty("getPasswdEncript"));
			ps.setString(1, mail);
		    rs = ps.executeQuery();
			if (!rs.wasNull())
			{
				remoraPasswd = rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return remoraPasswd;
	}
	
	private String encriptarCadena (String CadenaAencriptar)
	{
		String cadenaEncriptada = "";
		/*
		 * HAY QUE BUSCAR COMO ENCRIPTAR Y QUE SE QUEDE IGUAL
		 */
		return cadenaEncriptada;
		
	}

	public boolean login(String mail, String PasswdEncriptada)
	{
		String saltRemora = getSalt(mail);
		String passwdAlmacenada = getPasswdEncript(mail);
		String passwdAComparar = encriptarCadena(saltRemora + passwdAlmacenada);
		if (gestorRemora.existsRemora(mail))
		{
			if (gestorRemora.getEstadoRemora(mail).equals(EstadoRemora.Permitido))
			{
				if (passwdAlmacenada.equals(passwdAComparar))
				{
					return true;
				}	
			}
		}	
		return false;
		
	}
	

	
}
