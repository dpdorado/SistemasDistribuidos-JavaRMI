package sop_rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import servidor.dto.ObjectDTO;

public interface OperacioneEDInt extends Remote{
	public ObjectDTO buscarAnteproyecto(String CodigoAnteproyecto) throws RemoteException;
	public Vector listarAnteproyectos() throws RemoteException;
}
