/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop_rmi.callback;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author DD
 */
public class clienteCallbackImpl extends UnicastRemoteObject implements clienteCallbackInt{

    public clienteCallbackImpl()throws RemoteException{
        super();
    }
    
    @Override
    public String notifyMe(String message) throws RemoteException {        
        String returnMessage="Se asigno un anteproyecto con codigo:"+message;
        JOptionPane.showMessageDialog(null, returnMessage);
        return returnMessage;
    }
    
}
