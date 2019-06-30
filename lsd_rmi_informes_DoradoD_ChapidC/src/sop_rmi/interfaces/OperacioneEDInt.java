package sop_rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import servidor.dto.ObjectDTO;

public interface OperacioneEDInt extends Remote{
	public ObjectDTO buscarAnteproyecto(String CodigoAnteproyecto) throws RemoteException;
	public ObjectDTO listarAnteproyectos() throws RemoteException;
}
