/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import java.rmi.RemoteException;
import servidor.dto.ObjetosDTO.InicioSesionDTO;
import servidor.dto.ObjetosDTO.RespuestaIS;
import sop_rmi.interfaces.LoguearInt;

/**
 *
 * @author andres
 */
public class IniciarSesionRemoto{

    private LoguearInt loguearInt;
    private ServicioRemoto remoto;

    public IniciarSesionRemoto(String direccionIP, int puerto) throws RemoteException {
        this.remoto = new ServicioRemoto(direccionIP, puerto);
        this.loguearInt = null;
    }
    
    public boolean iniciar() throws RemoteException{
        this.loguearInt =    (LoguearInt) this.remoto.start("ObjetoRemotoLogueo");
        return (this.loguearInt != null);
        
    }

    public RespuestaIS iniciarSesion(String usuario, String contrasenia) throws RemoteException{
        return (RespuestaIS) loguearInt.iniciarSesion(new InicioSesionDTO(usuario, contrasenia));
    }
}
