package sop_rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import servidor.dto.ObjectDTO;

public interface OperacionesEInt extends Remote{
	public ObjectDTO agregarConceptoAnteproyecto(ObjectDTO datosAnteproyecto)  throws RemoteException;
}
