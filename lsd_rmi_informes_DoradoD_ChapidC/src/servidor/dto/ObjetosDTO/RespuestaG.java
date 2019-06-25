package dto.ObjetosDTO;

import dto.ObjectDTO;

//Respuesta general, contiene el exito de la operación y mensaje de error si ocurre
public class RespuestaG extends ObjectDTO{
	//Attributes
	private boolean OperacionExito;
	private String Mensaje;
	//Builders
	public RespuestaG() {
		this.OperacionExito=false;
		this.Mensaje="Error, contacte con el administrador.";
	}
	public RespuestaG(boolean operacionExito, String mensaje) {
		super();
		this.OperacionExito = operacionExito;
		this.Mensaje = mensaje;
	}
	//Getters and Setters
	public boolean isOperacionExito() {
		return OperacionExito;
	}
	public void setOperacionExito(boolean operacionExito) {
		OperacionExito = operacionExito;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
}
