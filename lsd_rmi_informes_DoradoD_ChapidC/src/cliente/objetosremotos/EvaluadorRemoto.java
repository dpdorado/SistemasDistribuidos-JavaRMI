/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.gui.EvaluadorGUI;
import cliente.utilidades.Constantes;
import cliente.utilidades.Mensajes;
import java.rmi.RemoteException;
import sop_rmi.callback.clienteCallbackInt;
import sop_rmi.interfaces.OperacioneEDInt;
import sop_rmi.interfaces.OperacionesEInt;

/**
 *
 * @author andres
 */
public class EvaluadorRemoto extends ServicioRemoto implements clienteCallbackInt {

    private OperacionesEInt operacionesEInt;
    private OperacioneEDInt operacioneEDInt;
    private EvaluadorGUI frameEvaluadorGUI;

  
    public EvaluadorRemoto(EvaluadorGUI frame, String direccionIP, int puerto) throws RemoteException {
        super(direccionIP, puerto);
        this.frameEvaluadorGUI = frame;
        this.operacionesEInt = null;
    }

    public boolean iniciar() throws RemoteException {
        this.operacionesEInt = (OperacionesEInt) this.lookup(Constantes.servicioEvaluador);
        this.operacioneEDInt = (OperacioneEDInt) this.lookup(Constantes.servicioEstDir);
        boolean servicioCallback = this.reebind(Constantes.callEvaluadores+"_"+this.toString(), this);
        return (this.operacionesEInt != null && this.operacioneEDInt != null && servicioCallback);

    }

    public void buscarAnteproyecto(String codigo) {
//        NodoAnteproyectoDTO anteproyectoDTO = (NodoAnteproyectoDTO) this.operacionesEInt.buscarAnteproyecto(codigo);
//        if(anteproyectoDTO != null){
//            
//        }else{
//            Mensajes.info(frameEvaluadorGUI, "No se encontro el anteproyecto con código: "+codigo);
//        }
    }

    @Override
    public String notifyMe(String message) throws RemoteException {
        Mensajes.info(frameEvaluadorGUI, message);
        return this.toString()+ " notified!";
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
