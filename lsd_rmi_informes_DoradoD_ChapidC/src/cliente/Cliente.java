package cliente;

import cliente.gui.EstudianteDirectorGUI;
import cliente.gui.EvaluadorGUI;
import cliente.gui.IniciarSesion;
import cliente.gui.JefeDepartamentoGUI;
import cliente.utilidades.Consola;
import java.rmi.RemoteException;
import servidor.utilidades.servidor.UtilidadesConsola;

/**
 * Cliente
 */
public class Cliente {

    public static void main(String[] args) throws RemoteException {
        
        int numPuertoRMIRegistry = 1090;
        String direccionIpRMIRegistry = "localhost";
//        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
//        System.out.println("Numero "+number);
//        direccionIpRMIRegistry = Consola.leerCadena("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
//        numPuertoRMIRegistry = Consola.leerEntero("Cual es el número de puerto por el cual escucha el rmiregistry"); 
//        
//        
//        IniciarSesion iniciarSesion = new IniciarSesion(direccionIpRMIRegistry, numPuertoRMIRegistry);
//        iniciarSesion.setVisible(true);
        JefeDepartamentoGUI departamentoGUI = new JefeDepartamentoGUI(direccionIpRMIRegistry,numPuertoRMIRegistry);
        departamentoGUI.setVisible(true);
//        EstudianteDirectorGUI estudianteDirectorGUI = new EstudianteDirectorGUI(direccionIpRMIRegistry, numPuertoRMIRegistry);
//        estudianteDirectorGUI.setVisible(true);
//        EvaluadorGUI evaluadorGUI = new EvaluadorGUI();
//        evaluadorGUI.setVisible(true);
          
    }
}