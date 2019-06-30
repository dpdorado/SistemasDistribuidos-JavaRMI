package servidor.dto.ObjetosDTO;

import servidor.dto.ObjectDTO;

public class UsuarioDTO extends ObjectDTO{
	//Atributos
    private String NombresApellidos;
    private String Identificacion;
    private String Usuario;
    private String Contrasenia;
    private int tipoUser;
    //Constructores
    public UsuarioDTO(){}
    
    public UsuarioDTO(String NombresApellidos, String Identificacion, String Usuario, String Contrasenia,int tipoUser) {
        this.NombresApellidos = NombresApellidos;
        this.Identificacion = Identificacion;
        this.Usuario = Usuario;
        this.Contrasenia = Contrasenia;
        this.tipoUser=tipoUser;
    }
    //Getters and Setters

    public String getNombresApellidos() {
        return NombresApellidos;
    }

    public void setNombresApellidos(String NombresApellidos) {
        this.NombresApellidos = NombresApellidos;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}
    
}
