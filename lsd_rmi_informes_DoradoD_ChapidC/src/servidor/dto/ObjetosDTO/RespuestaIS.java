package dto.ObjetosDTO;

import dto.ObjectDTO;

//Se utiliza para enviar la rspuesta del Inicio de Sesión.
public class RespuestaIS extends ObjectDTO{
	//Attribute
	private  int TipoUser;//-1->Error,1->JD,2->Es-D,3->Ev.
	private String Mensaje;//Mesanje de error.
	//Builders
	public RespuestaIS() {
		this.TipoUser=-1;
		this.Mensaje="FATAL ERROR, Contacte con el administrador.";
	}
	
	public RespuestaIS(int TipoUser,String Mensaje) {
		this.TipoUser=TipoUser;
		this.Mensaje=Mensaje;
	}
	
	//Getters and Setters
	public int getTipoUser() {
		return TipoUser;
	}

	public void setTipoUser(int tipoUser) {
		TipoUser = tipoUser;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
}
