package es.uco.iw.mvc.modelo.business;

import java.util.Vector;

public class ProyectoDTO {
    
    private String titulo;
	private String descripcion;
	private Vector <String> skills;
	private Vector <String> tematicas;
    private String propietario;

    public ProyectoDTO (String titulo, String descripcion, Vector <String> skills, 
								Vector <String> tematicas, String propietario)
	{
		setTitulo(titulo);
		setDescripcion(descripcion);
		setSkills(new Vector <String>());
		setSkills(skills);
        setTematicas(new Vector <String>());
		setTematicas(tematicas);
		setPropietario(propietario);
	}

    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    public Vector <String> getSkills() {
		return skills;
	}

	public void setSkills(Vector <String> skills) {
		this.skills = skills;
	}

    public Vector <String> getTematicas() {
		return tematicas;
	}

	public void setTematicas(Vector <String> tematicas) {
		this.tematicas = tematicas;
	}

    public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
}
