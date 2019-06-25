package sop_rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.ObjectDTO;

public interface LoguearInt extends Remote{
	public ObjectDTO iniciarSesion(ObjectDTO datosIS) throws RemoteException;
	public ObjectDTO cambiarContraseña(ObjectDTO datosCC) throws RemoteException;
}
