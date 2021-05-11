package es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Vector;

import es.uco.iw.mvc.modelo.data.conexionBBDD.DBconnect;
import es.uco.iw.mvc.modelo.data.conexionBBDD.impl.DBconnectImpl;

import es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.GestSkillCtt;

public class GestSkillCTTImpl implements GestSkillCtt
{
	private Connection conexionBBDD;
	private Properties pSQL;
	
	public GestSkillCTTImpl()
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

	public void addSkill(String mail, Vector <String> newSkills)
	{
		
		PreparedStatement addSkill = null;
		Vector <String> skillsRemoraExistentes = getSkillsRemora(mail);
		try
		{
			addSkill=conexionBBDD.prepareStatement(pSQL.getProperty("insertarSkillCliente"));
			for (int i=0; i < newSkills.size(); i++)
			{
				if (!skillsRemoraExistentes.contains(newSkills.get(i)))
				{
					addSkill.setString(1, newSkills.get(i));
					addSkill.executeUpdate();
				}
			
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteSkill(String mail, Vector <String> skill)
	{
		PreparedStatement addSkill = null;

		try
		{
			addSkill=conexionBBDD.prepareStatement(pSQL.getProperty("deleteSkill"));
			for (int i=0; i < skill.size(); i++)
			{
				addSkill.setString(1, mail);
				addSkill.setString(2, skill.get(i));
				addSkill.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getTotalSkills()
	{
		
	}
	
	
	public Vector <String> getSkillsRemora(String mail)
	{
		Vector <String> skills = new Vector <String>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{
			ps = conexionBBDD.prepareStatement(pSQL.getProperty("buscarSkillsRemora"));
			ps.setString(1, mail);
			rs = ps.executeQuery();
			while (rs.next())
			{
				skills.add(rs.getString(1));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return skills;
	}
}
