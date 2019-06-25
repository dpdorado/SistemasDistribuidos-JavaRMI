package dto.ObjetosDTO;

import dto.ObjectDTO;

public class UsuarioDTO extends ObjectDTO{
	//Atributos
    private String NombresApellidos;
    private String Identificacion;
    private String Usuario;
    private String Contrase�a;
    private int tipoUser;
    //Constructores
    public clsUsuario(){}
    
    public UsuarioDTO(String NombresApellidos, String Identificacion, String Usuario, String Contrase�a,int tipoUser) {
        this.NombresApellidos = NombresApellidos;
        this.Identificacion = Identificacion;
        this.Usuario = Usuario;
        this.Contrase�a = Contrase�a;
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

    public String getContrase�a() {
        return Contrase�a;
    }

    public void setContrase�a(String Contrase�a) {
        this.Contrase�a = Contrase�a;
    }

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}
    
}
