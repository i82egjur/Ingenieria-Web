package es.uco.iw.model.DTO;

public class AdministradorTiburonBlancoDTO 
{
	String correo;
	String nombre;
	String apellido1;
	String apellido2;
	Integer telefono;
	TipoRemora tipoRemora;
	
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	public TipoRemora getTipoRemora() {
		return tipoRemora;
	}
	
	public void setTipoRemora(TipoRemora tipoRemora) {
		this.tipoRemora = tipoRemora;
	}
	
}
