/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.utilidades.servidor;


import java.rmi.RemoteException;
import servidor.utilidades.servidor.UtilidadesConsola;
import servidor.utilidades.servidor.UtilidadesRegistroS;

import sop_rmi.implementacion.LoguearImpl;
import sop_rmi.implementacion.OperacioneJDImpl;
import sop_rmi.implementacion.OperacionesEDImpl;
import sop_rmi.implementacion.OperacionesEImpl;


public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        
               
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        LoguearImpl objRLogueo=new LoguearImpl();
        OperacioneJDImpl objRJD=new OperacioneJDImpl();
        OperacionesEDImpl objRED=new OperacionesEDImpl();
        OperacionesEImpl objRE=new OperacionesEImpl();             
        
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRLogueo, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoLogueo");
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRJD, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoJD");
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRED, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoED");
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRE, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoE");
           
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
