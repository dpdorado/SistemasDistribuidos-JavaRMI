package dto.ObjetosDTO;


public class CambioContrase�aDTO extends InicioSesionDTO{
	//Attributes
	private String  nueva_contrase�a;
	//Builders
	public CambioContrase�aDTO(String usuario, String contrase�a, String nueva_contrase�a) {
		super(usuario,contrase�a);
		this.nueva_contrase�a = nueva_contrase�a;
	}
	
	//Getters and Setters
	public String getNuevaContrase�a() {
		return nueva_contrase�a;
	}
	public void setNuevaContrase�a(String nueva_contrase�a) {
		this.nueva_contrase�a = nueva_contrase�a;
	}

	
}
