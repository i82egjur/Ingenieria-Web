package es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT;

import java.util.Vector;

public interface GestSkillCtt 
{
	public void addSkill(String mail, Vector <String> skill);
	
	public void deleteSkill(String mail, Vector <String> skill);
	
	public Vector <String> getSkillsRemora(String mail);

	

}
