package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import servidor.dao.GestorObjetoDAO;
import servidor.dto.ObjectDTO;
import servidor.dto.ObjetosDTO.AgregarConceptoAnteproyectoDTO;
import servidor.dto.ObjetosDTO.RespuestaG;
import sop_rmi.interfaces.OperacionesEInt;
import servidor.utilidades.persistencia.GestorEvaluadoresDAO;
import servidor.utilidades.persistencia.IConstantes;

public class OperacionesEImpl extends UnicastRemoteObject implements OperacionesEInt{
	private GestorObjetoDAO gestorEvaluadores;
	
	public OperacionesEImpl() throws RemoteException {
		super();
		this.gestorEvaluadores=new GestorEvaluadoresDAO();
	}

	@Override
	public ObjectDTO agregarConceptoAnteproyecto(ObjectDTO datosAnteproyecto) throws RemoteException {
		RespuestaG respuesta=new RespuestaG();
		if (datosAnteproyecto==null) {
			return respuesta;
		}			
		AgregarConceptoAnteproyectoDTO datas=(AgregarConceptoAnteproyectoDTO)datosAnteproyecto;
		Hashtable<String,String> object=new Hashtable<String,String>();
		object.put(IConstantes.CODIGO_ANTEPROYECTO, datas.getCodigoAnteproyecto());
		object.put(IConstantes.CONCEPTO,datas.getConcepto());
		respuesta.setOperacionExito(this.gestorEvaluadores.editarObjeto(object));
		if(respuesta.isOperacionExito()) {
			respuesta.setMensaje("Se modific� el condepto del anteproyecto.");
		}else {
			respuesta.setMensaje("No se pudo modificar el concepto del anteproyecto, consulte con el administrador.");
		}
		return respuesta;
	}

}
