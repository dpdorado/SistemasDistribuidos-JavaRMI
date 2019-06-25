package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dao.GestorObjetoDAO;
import dto.ObjectDTO;
import dto.ObjetosDTO.CambioContrase�aDTO;
import dto.ObjetosDTO.InicioSesionDTO;
import dto.ObjetosDTO.RespuestaG;
import dto.ObjetosDTO.RespuestaIS;
import sop_rmi.interfaces.LoguearInt;
import utilidades.persistencia.IConstantes;
import utilidades.persistencia.InicioSesionDAO;

public class LoguearImpl extends UnicastRemoteObject implements LoguearInt{
	private GestorObjetoDAO gestor;
	
	public LoguearImpl() throws RemoteException {
		super();
		gestor=new InicioSesionDAO();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObjectDTO iniciarSesion(ObjectDTO datosIS) throws RemoteException {
		RespuestaIS respuesta=new RespuestaIS();
		InicioSesionDTO is=(InicioSesionDTO)datosIS;
		Hashtable<String,String> object= new Hashtable<String,String>(); 
		object.put(IConstantes.USUARIO, is.getUsuario());
		object= (Hashtable<String,String>)this.gestor.leerObjeto((Object)object);
		if (object!=null) {
			if(object.get(IConstantes.CONTRASENIA).equals(is.getContrase�a())) {
				respuesta.setTipoUser(Integer.parseInt(object.get(IConstantes.TIPO_USUARIO)));
				respuesta.setMensaje("Inicio de sesi�n exitoso.");
			}
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObjectDTO cambiarContrase�a(ObjectDTO datosCC) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		CambioContrase�aDTO is=(CambioContrase�aDTO)datosCC;
		Hashtable<String,String> object= new Hashtable<String,String>(); 
		
		object.put(IConstantes.USUARIO, is.getUsuario());
		//object.put(IConstantes.CONTRASENIA, is.getContrase�a());
		
		//object.put(IConstantes.NUEVA_CONTRASENIA, is.getNuevaContrase�a());
		
		object= (Hashtable<String,String>)this.gestor.leerObjeto((Object)object);
		if (object!=null) {
			if(object.get(IConstantes.CONTRASENIA).equals(is.getContrase�a())) {
				object.put(IConstantes.CONTRASENIA,is.getContrase�a());
				respuesta.setOperacionExito(this.gestor.editarObjeto(object));
				if(respuesta.isOperacionExito()) {
					respuesta.setMensaje("Se cambio la contrase�a.");
				}else {
					respuesta.setMensaje("No se pudo cambiar la contrase�a.");
				}
				
			}
		}else {
			respuesta.setMensaje("Datos incorrectos, intentelo denuevo.");
		}
		return respuesta;
	}
	
}
