package dto.ObjetosDTO;
import dto.ObjectDTO;

public class InicioSesionDTO extends ObjectDTO{
	//Attributes
	protected String usuario;
	protected String contrase�a;
	//Builders
	public InicioSesionDTO(String usuario, String contrase�a) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	//Getters and Setters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}	
	
}
