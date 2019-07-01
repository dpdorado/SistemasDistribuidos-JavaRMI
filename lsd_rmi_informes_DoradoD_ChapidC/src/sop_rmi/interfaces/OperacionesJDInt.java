package sop_rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import servidor.dto.ObjectDTO;
import sop_rmi.callback.serverCallbackInt;

public interface OperacionesJDInt extends serverCallbackInt{
	public ObjectDTO registrarUsuario(ObjectDTO datosUser)  throws RemoteException;
	public ObjectDTO registrarAnteproyecto(ObjectDTO datosAnteproyecto)  throws RemoteException;
	public ObjectDTO asignarEvaluadores(ObjectDTO datosEvaluadores)  throws RemoteException;
	public ObjectDTO buscarAnteproyceto(String codigoAnteproyecto) throws RemoteException;
	public ObjectDTO modificarConceptoAnteproyecto(ObjectDTO datosModificacion)throws RemoteException;
}
