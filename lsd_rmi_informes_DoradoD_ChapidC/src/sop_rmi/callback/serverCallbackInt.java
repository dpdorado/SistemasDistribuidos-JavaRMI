/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop_rmi.callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DD
 */
public interface serverCallbackInt extends Remote{
    public String notify(String message) throws RemoteException;
    public void registerForCallback(clienteCallbackInt callbackClientObject ) throws java.rmi.RemoteException;
    public void unregisterForCallback(clienteCallbackInt callbackClientObject) throws java.rmi.RemoteException; 
}
