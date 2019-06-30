package servidor.dto.ObjetosDTO;


public class CambioContraseniaDTO extends InicioSesionDTO{
	//Attributes
	private String  nueva_contrasenia;
	//Builders
	public CambioContraseniaDTO(String usuario, String contrasenia, String nueva_contrasenia) {
		super(usuario,contrasenia);
		this.nueva_contrasenia = nueva_contrasenia;
	}
	
	//Getters and Setters
	public String getNuevaContrasenia() {
		return nueva_contrasenia;
	}
	public void setNuevaContrasenia(String nueva_contrasenia) {
		this.nueva_contrasenia = nueva_contrasenia;
	}

	
}
