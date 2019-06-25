package dto.ObjetosDTO;


public class CambioContraseñaDTO extends InicioSesionDTO{
	//Attributes
	private String  nueva_contraseña;
	//Builders
	public CambioContraseñaDTO(String usuario, String contraseña, String nueva_contraseña) {
		super(usuario,contraseña);
		this.nueva_contraseña = nueva_contraseña;
	}
	
	//Getters and Setters
	public String getNuevaContraseña() {
		return nueva_contraseña;
	}
	public void setNuevaContraseña(String nueva_contraseña) {
		this.nueva_contraseña = nueva_contraseña;
	}

	
}
