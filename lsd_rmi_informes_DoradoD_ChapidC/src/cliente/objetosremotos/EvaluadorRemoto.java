/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.gui.EvaluadorGUI;
import java.rmi.RemoteException;
import sop_rmi.interfaces.OperacionesEInt;

/**
 *
 * @author andres
 */
public class EvaluadorRemoto extends ServicioRemoto{ 
    private OperacionesEInt operacionesEInt;
    private EvaluadorGUI frameEvaluadorGUI;

    public EvaluadorRemoto(EvaluadorGUI frame, String direccionIP, int puerto) throws RemoteException {
        super("ObjetoRemotoE", direccionIP, puerto);
        this.frameEvaluadorGUI = frame;
        this.operacionesEInt = null;
    }
    
    public boolean iniciar() throws RemoteException{
        this.operacionesEInt =    (OperacionesEInt) this.start();
        return (this.operacionesEInt != null);
        
    }
    
}
