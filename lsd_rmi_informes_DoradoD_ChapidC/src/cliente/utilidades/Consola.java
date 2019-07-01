/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class Consola {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int leerEntero(String mensaje){
        try {
            System.out.println(mensaje);
            return Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
