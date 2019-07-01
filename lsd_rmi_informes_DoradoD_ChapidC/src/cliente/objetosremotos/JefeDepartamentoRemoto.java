/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import cliente.Cliente;
import cliente.gui.JefeDepartamentoGUI;
import cliente.utilidades.Constantes;
import cliente.utilidades.Mensajes;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.dto.ObjetosDTO.AnteproyectoCompletoDTO;
import servidor.dto.ObjetosDTO.AnteproyectoSimple;
import servidor.dto.ObjetosDTO.EvaluadoresDTO;
import servidor.dto.ObjetosDTO.NodoAnteproyectoDTO;
import servidor.dto.ObjetosDTO.RespuestaG;
import servidor.dto.ObjetosDTO.UsuarioDTO;
import sop_rmi.callback.clienteCallbackImpl;
import sop_rmi.callback.clienteCallbackInt;
import sop_rmi.interfaces.OperacioneEDInt;
import sop_rmi.interfaces.OperacionesJDInt;

/**
 *
 * @author andres
 */
public class JefeDepartamentoRemoto {

    private OperacionesJDInt operacionesJDInt;
    private OperacioneEDInt operacioneEDInt;
    private JefeDepartamentoGUI jdgui;
    private RespuestaG respuestaG;
    private ServicioRemoto remoto;

    public JefeDepartamentoRemoto(JefeDepartamentoGUI departamentoGUI, String direccionIP, int puerto) throws RemoteException {
        this.remoto = new ServicioRemoto(direccionIP, puerto);
        this.operacionesJDInt = null;
        this.jdgui = departamentoGUI;
        this.respuestaG = new RespuestaG();
    }

    public boolean iniciar() throws RemoteException {

        try {
            this.operacionesJDInt = (OperacionesJDInt) this.remoto.start(Constantes.servicioJefeDep);
            this.operacioneEDInt = (OperacioneEDInt) this.remoto.start(Constantes.servicioEstDir);
            //callback
            clienteCallbackInt callback;
            callback = new clienteCallbackImpl();
            //objeto de Jefe departamento ya registrado, falta añadirel un dodigo al callback por que notifica a todos
            this.operacionesJDInt.registerForCallback(callback);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return (this.operacionesJDInt != null && this.operacioneEDInt != null);

        }

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

    public String[][] listarAnteproyectos() throws RemoteException {
        Vector antProyectos = this.operacioneEDInt.listarAnteproyectos();

        String[][] proyectos = new String[antProyectos.size()][2];

        for (int i = 0; i < antProyectos.size(); i++) {
            AnteproyectoSimple antProyecto = (AnteproyectoSimple) antProyectos.get(i);
            proyectos[i][0] = antProyecto.getCodigo();
            proyectos[i][1] = antProyecto.getTitulo();

        }
        return proyectos;
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
