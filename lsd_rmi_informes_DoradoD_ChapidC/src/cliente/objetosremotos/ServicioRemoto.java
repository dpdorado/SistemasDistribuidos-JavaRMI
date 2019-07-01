/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.objetosremotos;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author andres
 */
public class ServicioRemoto extends UnicastRemoteObject {

    private String nombreServicio;
    private String direccionIP;
    private int puerto;

    public ServicioRemoto(String direccionIP, int puerto) throws RemoteException {
        super();
        this.nombreServicio = nombreServicio;
        this.direccionIP = direccionIP;
        this.puerto = puerto;
    }

    protected Remote start(String nombreServicio) throws RemoteException {
        Remote servicio = null;
        try {
            servicio = Naming.lookup("rmi://" + direccionIP + ":" + puerto + "/" + nombreServicio);
        } catch (ConnectException e) {
//            JOptionPane.showMessageDialog(
//                    chatGUI.frame, "The server seems to be unavailable\nPlease try later",
//                    "Connection problem", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NotBoundException | MalformedURLException me) {
            me.printStackTrace();
        } finally {
            System.out.println("Cliente " + this.nombreServicio + " se está ejecutando ....\n");
            return servicio;

        }
    }

}
