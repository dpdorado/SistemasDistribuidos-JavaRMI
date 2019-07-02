package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;
import servidor.dto.ObjectDTO;
import servidor.dto.ObjetosDTO.CambioContraseniaDTO;
import servidor.dto.ObjetosDTO.InicioSesionDTO;
import servidor.dto.ObjetosDTO.RespuestaG;
import servidor.dto.ObjetosDTO.RespuestaIS;
import sop_rmi.interfaces.LoguearInt;
import servidor.utilidades.persistencia.IConstantes;
import servidor.utilidades.persistencia.InicioSesionDAO;

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
			System.out.println(object.get(IConstantes.CONTRASENIA));
			if(object.get(IConstantes.CONTRASENIA).equals(is.getContrasenia())) {
				respuesta.setTipoUser(Integer.parseInt(object.get(IConstantes.TIPO_USUARIO)));
				respuesta.setMensaje("Inicio de sesi�n exitoso.");
			}
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObjectDTO cambiarContrasenia(ObjectDTO datosCC) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		CambioContraseniaDTO is=(CambioContraseniaDTO)datosCC;
		Hashtable<String,String> object= new Hashtable<String,String>(); 
		
		object.put(IConstantes.USUARIO, is.getUsuario());
		//object.put(IConstantes.CONTRASENIA, is.getContrase�a());
		
		//object.put(IConstantes.NUEVA_CONTRASENIA, is.getNuevaContrase�a());
		
		object= (Hashtable<String,String>)this.gestor.leerObjeto((Object)object);
		if (object!=null) {
			if(object.get(IConstantes.CONTRASENIA).equals(is.getContrasenia())) {
				object.put(IConstantes.CONTRASENIA,is.getContrasenia());
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
