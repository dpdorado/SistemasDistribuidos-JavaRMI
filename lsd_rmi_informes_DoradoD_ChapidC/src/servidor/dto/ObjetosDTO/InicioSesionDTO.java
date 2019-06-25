package dto.ObjetosDTO;
import dto.ObjectDTO;

public class InicioSesionDTO extends ObjectDTO{
	//Attributes
	protected String usuario;
	protected String contraseña;
	//Builders
	public InicioSesionDTO(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	//Getters and Setters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}	
	
}
