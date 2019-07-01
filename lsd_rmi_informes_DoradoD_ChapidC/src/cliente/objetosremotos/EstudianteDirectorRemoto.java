/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.gui.EstudianteDirectorGUI;
import cliente.utilidades.Constantes;
import cliente.utilidades.Mensajes;
import java.rmi.RemoteException;
import servidor.dto.ObjetosDTO.NodoAnteproyectoDTO;
import sop_rmi.interfaces.OperacioneEDInt;

/**
 *
 * @author andres
 */
public class EstudianteDirectorRemoto{ 
    private OperacioneEDInt operacioneEDInt;
    private EstudianteDirectorGUI edgui;
    private ServicioRemoto remoto;

    public EstudianteDirectorRemoto(EstudianteDirectorGUI estudianteDirectorGUI,String direccionIP, int puerto) throws RemoteException {
        this.remoto = new ServicioRemoto(direccionIP, puerto);
        this.edgui = estudianteDirectorGUI;
        this.operacioneEDInt = null;
    }
    
    public boolean iniciar() throws RemoteException{
        this.operacioneEDInt =    (OperacioneEDInt) this.remoto.start(Constantes.servicioEstDir);
        return (this.operacioneEDInt != null);
        
    }
    
    public void buscarAnteproyecto(String codigo) throws RemoteException{
        NodoAnteproyectoDTO anteproyectoDTO = (NodoAnteproyectoDTO) this.operacioneEDInt.buscarAnteproyecto(codigo);
        if(anteproyectoDTO != null){
            
        }else{
            Mensajes.info(edgui, "No se encontro el anteproyecto con código: "+codigo);
        }
    }
    
    public void listarAnteproyectos() throws RemoteException{
        this.operacioneEDInt.listarAnteproyectos();
    }
    
}
