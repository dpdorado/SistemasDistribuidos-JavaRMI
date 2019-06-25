package sop_rmi.implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dao.GestorObjetoDAO;
import dto.ObjectDTO;
import dto.ObjetosDTO.AgregarConceptoAnteproyectoDTO;
import dto.ObjetosDTO.RespuestaG;
import sop_rmi.interfaces.OperacionesEInt;
import utilidades.persistencia.GestorEvaluadoresDAO;
import utilidades.persistencia.IConstantes;

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
			respuesta.setMensaje("Se modificó el condepto del anteproyecto.");
		}else {
			respuesta.setMensaje("No se pudo modificar el concepto del anteproyecto, consulte con el administrador.");
		}
		return respuesta;
	}

}
