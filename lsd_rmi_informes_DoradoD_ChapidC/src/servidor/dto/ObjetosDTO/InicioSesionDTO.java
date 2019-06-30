package servidor.dto.ObjetosDTO;
import servidor.dto.ObjectDTO;

public class InicioSesionDTO extends ObjectDTO{
	//Attributes
	protected String usuario;
	protected String contrasenia;
	//Builders
	public InicioSesionDTO(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	//Getters and Setters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}	
	
}
