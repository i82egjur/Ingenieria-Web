package es.uco.iw.mvc.modelo.business;

import java.sql.Date;

public class PromocionRemoraDTO 
{
	private String correoRemoraPromocionada;
	private String descripcionPromocion;
	private Date fechaInicio;
	private Date fechaFinal;
	
	public PromocionRemoraDTO()
	{
		
	}
	public PromocionRemoraDTO(String correoRemoraPromocionada, String descripcionPromocion, Date fechaInicio, Date fechaFinal)
	{
		setCorreoRemoraPromocionada(correoRemoraPromocionada);
		setDescripcionPromocion(descripcionPromocion);
		setFechaInicio(fechaInicio);
		setFechaFinal(fechaFinal);
	}
	
	
	public String getCorreoRemoraPromocionada() {
		return correoRemoraPromocionada;
	}
	public void setCorreoRemoraPromocionada(String correoRemoraPromocionada) {
		this.correoRemoraPromocionada = correoRemoraPromocionada;
	}
	public String getDescripcionPromocion() {
		return descripcionPromocion;
	}
	public void setDescripcionPromocion(String descripcionPromocion) {
		this.descripcionPromocion = descripcionPromocion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
