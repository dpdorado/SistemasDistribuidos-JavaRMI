package cliente;

import cliente.gui.EstudianteDirectorGUI;
import cliente.gui.EvaluadorGUI;
import cliente.gui.IniciarSesion;
import cliente.gui.JefeDepartamentoGUI;
import servidor.utilidades.servidor.UtilidadesConsola;

/**
 * Cliente
 */
public class Cliente {

    public static void main(String[] args) {
        
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        
               
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
        
        
        IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        JefeDepartamentoGUI departamentoGUI = new JefeDepartamentoGUI();
        departamentoGUI.setVisible(true);
        EstudianteDirectorGUI estudianteDirectorGUI = new EstudianteDirectorGUI();
        estudianteDirectorGUI.setVisible(true);
        EvaluadorGUI evaluadorGUI = new EvaluadorGUI();
        evaluadorGUI.setVisible(true);
          
    }
}