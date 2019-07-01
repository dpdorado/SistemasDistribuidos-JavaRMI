/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.gui.EvaluadorGUI;
import java.rmi.RemoteException;
import sop_rmi.interfaces.OperacioneEDInt;
import sop_rmi.interfaces.OperacionesEInt;

/**
 *
 * @author andres
 */
public class EvaluadorRemoto{ 
    private OperacionesEInt operacionesEInt;
    private OperacioneEDInt operacioneEDInt;
    private EvaluadorGUI frameEvaluadorGUI;
    private ServicioRemoto remoto;

    public EvaluadorRemoto(EvaluadorGUI frame, String direccionIP, int puerto) throws RemoteException {
        this.remoto = new ServicioRemoto(direccionIP, puerto);
        this.frameEvaluadorGUI = frame;
        this.operacionesEInt = null;
    }
    
    public boolean iniciar() throws RemoteException{
        this.operacionesEInt =    (OperacionesEInt) this.remoto.start("ObjetoRemotoE");
        this.operacioneEDInt =    (OperacioneEDInt) this.remoto.start("ObjetoRemotoED");
        return (this.operacionesEInt != null && this.operacioneEDInt != null);
        
    }
    
    public void buscarAnteproyecto(String codigo){
//        NodoAnteproyectoDTO anteproyectoDTO = (NodoAnteproyectoDTO) this.operacionesEInt.buscarAnteproyecto(codigo);
//        if(anteproyectoDTO != null){
//            
//        }else{
//            Mensajes.info(frameEvaluadorGUI, "No se encontro el anteproyecto con código: "+codigo);
//        }
    }
    
}
