package dto.ObjetosDTO;

import dto.ObjectDTO;

public class UsuarioDTO extends ObjectDTO{
	//Atributos
    private String NombresApellidos;
    private String Identificacion;
    private String Usuario;
    private String Contraseña;
    private int tipoUser;
    //Constructores
    public clsUsuario(){}
    
    public UsuarioDTO(String NombresApellidos, String Identificacion, String Usuario, String Contraseña,int tipoUser) {
        this.NombresApellidos = NombresApellidos;
        this.Identificacion = Identificacion;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}
    
}
