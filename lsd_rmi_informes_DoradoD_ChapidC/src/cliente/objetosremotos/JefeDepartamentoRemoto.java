/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.gui.JefeDepartamentoGUI;
import cliente.utilidades.Mensajes;
import java.rmi.RemoteException;
import servidor.dto.ObjetosDTO.AnteproyectoCompletoDTO;
import servidor.dto.ObjetosDTO.EvaluadoresDTO;
import servidor.dto.ObjetosDTO.NodoAnteproyectoDTO;
import servidor.dto.ObjetosDTO.RespuestaG;
import servidor.dto.ObjetosDTO.UsuarioDTO;
import sop_rmi.interfaces.OperacionesJDInt;

/**
 *
 * @author andres
 */
public class JefeDepartamentoRemoto extends ServicioRemoto {

    private OperacionesJDInt operacionesJDInt;
    private JefeDepartamentoGUI jdgui;
    private RespuestaG respuestaG;

    public JefeDepartamentoRemoto(JefeDepartamentoGUI departamentoGUI, String direccionIP, int puerto) throws RemoteException {
        super("ObjetoRemotoJD", direccionIP, puerto);
        this.operacionesJDInt = null;
        this.jdgui = departamentoGUI;
        this.respuestaG = new RespuestaG();
    }

    public boolean iniciar() throws RemoteException {
        this.operacionesJDInt = (OperacionesJDInt) this.start();
        return (this.operacionesJDInt != null);

    }

    public void registrarUsuario(String nombreCompleto, Integer identificacion, String usuarioUnicauca, String contrasenia, int tipoUsuario) throws RemoteException {
        respuestaG = (RespuestaG) this.operacionesJDInt.registrarUsuario(new UsuarioDTO(nombreCompleto, contrasenia, usuarioUnicauca, contrasenia, tipoUsuario));
        imprimirRespuesta(1);
    }

    public void registrarAnteproyecto(String modalidad, String titulo, String codigo, String e1, String e2, String dir, String coDir, String fechaR, String fechaAp, int concepto, int estado, int numRev) throws RemoteException {
        NodoAnteproyectoDTO acdto = new NodoAnteproyectoDTO(modalidad, titulo, codigo, coDir, coDir, coDir, coDir, fechaR, fechaAp, concepto, estado, numRev);
        RespuestaG registrarAnte = (RespuestaG) this.operacionesJDInt.registrarAnteproyecto(acdto);
        imprimirRespuesta(2);

//        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    public void asignarEvaluadores(String codigo, String nombreEva1, String nombreEva2, String fechaEva1, String fechaEva2, String conceptoEva1, String conceptoEva2) throws RemoteException {
        this.respuestaG = (RespuestaG) this.operacionesJDInt.asignarEvaluadores(new EvaluadoresDTO(codigo, nombreEva1, conceptoEva1, fechaEva1, nombreEva2, conceptoEva2, fechaEva2));
        imprimirRespuesta(3);
    }

    public void buscarAnteproyecto(String codigo) throws RemoteException {
        AnteproyectoCompletoDTO acdto = (AnteproyectoCompletoDTO) this.operacionesJDInt.buscarAnteproyceto(codigo);
        if (acdto.getAnteproyecto() != null) {
            this.jdgui.cargarBuscarAnteproyecto(acdto.getAnteproyecto());
        } else {
            Mensajes.info(jdgui, "No se encontro el anteproyecto con codigo: " + codigo);
        }
    }

    public void listarAnteproyectos() {

    }

    public void imprimirRespuesta(int op) {
        if (respuestaG != null) {
            if (respuestaG.isOperacionExito()) {
                switch (op) {
                    case 1:
                        this.jdgui.limpiarRegistroUsuario();
                        break;
                    case 2:
                        this.jdgui.limpiarRegistrarAnteproyecto();
                        break;
                    case 3:
                        this.jdgui.limpiarAsignarAnteproyecto();
                        break;
                    case 4:
                        this.jdgui.limpiarBuscarAnteproyecto();
                        break;
                }
                Mensajes.info(jdgui, respuestaG.getMensaje());
            } else {
                Mensajes.error(jdgui, respuestaG.getMensaje());
            }
        } else {
            Mensajes.error(jdgui, "No se delvovio ninguna respuesta!");
        }
    }
}
