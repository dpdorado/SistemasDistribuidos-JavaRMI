/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.utilidades.Constantes;
import java.rmi.RemoteException;
import servidor.dto.ObjetosDTO.InicioSesionDTO;
import servidor.dto.ObjetosDTO.RespuestaIS;
import sop_rmi.interfaces.LoguearInt;

/**
 *
 * @author andres
 */
public class IniciarSesionRemoto extends ServicioRemoto{

    private LoguearInt loguearInt;

    public IniciarSesionRemoto(String direccionIP, int puerto) throws RemoteException {
        super(direccionIP, puerto);
        this.loguearInt = null;
    }
    
    public boolean iniciar() throws RemoteException{
        this.loguearInt =    (LoguearInt) this.lookup(Constantes.servicioIniSesion);
        return (this.loguearInt != null);
        
    }

    public RespuestaIS iniciarSesion(String usuario, String contrasenia) throws RemoteException{
        return (RespuestaIS) loguearInt.iniciarSesion(new InicioSesionDTO(usuario, contrasenia));
    }
}
