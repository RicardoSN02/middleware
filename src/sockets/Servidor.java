/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjsaa
 */
public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc[] = new Socket[3];
        DataInputStream[] in= new DataInputStream[3];
        DataOutputStream[] out= new DataOutputStream[3];
        Socket socketTurno= null;
        
        int[] puertosClientes = new int[3];
        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            ServidorHilo sh = null;
            ServidorHilo sh2 = null;
            ServidorHilo sh3 = null;
            
            //guarda los sockets de los clientes 
            for (int i = 0; i < puertosClientes.length; i++) {
                sc[i]=servidor.accept();
                in[i] = new DataInputStream(sc[i].getInputStream());
                out[i] = new DataOutputStream(sc[i].getOutputStream());
                System.out.println("Cliente "+(i+1)+ " conectado");
                
            }
            
                sh = new ServidorHilo(sc[0],in[0],out[1]);
                sh2 = new ServidorHilo(sc[1],in[1],out[0]);
                sh3 = new ServidorHilo(sc[2],in[2],out[0]);
                sh.start();
                sh2.start();
                sh3.start();
            //Siempre estara escuchando peticiones
            while (true) {
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
