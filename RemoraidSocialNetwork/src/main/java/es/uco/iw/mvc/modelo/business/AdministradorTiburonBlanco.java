package es.uco.iw.mvc.modelo.business;


public class AdministradorTiburonBlanco 
{
	private String nombreRemora;
	private String apellidos;
	private String mail;
	private String password;
	private String saltPassword;
	private Integer telefono;
	private EstadoRemora estado;
	
	
	public AdministradorTiburonBlanco (String nombreRemora, String apellidos, String mail, 
							   String password, String saltPassword, Integer telefono, EstadoRemora estado)
	{
		setNombreRemora(nombreRemora);
		setApellidos(apellidos);
		setMail(mail);
		setPassword(password);
		setSaltPassword(saltPassword);
		setTelefono(telefono);
		setEstado(estado); 
	}


	public String getNombreRemora() {
		return nombreRemora;
	}


	public void setNombreRemora(String nombreRemora) {
		this.nombreRemora = nombreRemora;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSaltPassword() {
		return saltPassword;
	}


	public void setSaltPassword(String saltPassword) {
		this.saltPassword = saltPassword;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public EstadoRemora getEstado() {
		return estado;
	}


	public void setEstado(EstadoRemora estado) {
		this.estado = estado;
	}

}
