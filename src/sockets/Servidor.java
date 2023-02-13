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
        Socket sc[] = new Socket[2];
        DataInputStream[] in= new DataInputStream[2];
        DataOutputStream[] out= new DataOutputStream[2];
        Socket socketTurno= null;
        
        int[] puertosClientes = new int[2];
        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            
            //guarda los sockets de los clientes 
            for (int i = 0; i < puertosClientes.length; i++) {
                sc[i]=servidor.accept();
                in[i] = new DataInputStream(sc[i].getInputStream());
                out[i] = new DataOutputStream(sc[i].getOutputStream());
                System.out.println("Cliente conectado");
            }
            
            //Siempre estara escuchando peticiones
            while (true) {

                socketTurno= servidor.accept();
                DataInputStream inTurno= new DataInputStream(socketTurno.getInputStream());
                DataOutputStream outTurno= new DataOutputStream(socketTurno.getOutputStream());
                
                if(sc[0].getPort()==socketTurno.getPort()){
                    String mensaje = inTurno.readUTF();

                    
                    System.out.println(mensaje);

                //Le envio un mensaje
                    out[1].writeUTF("¡Hola mundo desde el servidor!");

                //Cierro el socket
                    sc[1].close();
                    System.out.println("Cliente desconectado");
                }else{
                    String mensaje = inTurno.readUTF();

                    System.out.println(mensaje);

                //Le envio un mensaje
                    out[0].writeUTF("¡Hola mundo desde el servidor!");

                //Cierro el socket
                    sc[0].close();
                    System.out.println("Cliente desconectado");
                }
                

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
