/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * hilo que ayudara a escuchar los mensajes recibidos del lado del cliente
 * @author rjsaa
 */
public class HiloCliente extends Thread{
    //sockets y buffer a usar para interpretar el mensaje
    
    Socket socket = null;
    DataInputStream in= null;
    /**
     * construcor que inicializa el socket al socket de la clase cliente
     * @param ds 
     */
    public HiloCliente(Socket socket,DataInputStream in) {
        this.socket = socket;
        this.in= in;
    }
      
    /**
     * clase que activa el hilo
     */
    @Override
    public void run(){
        while(true){
            try {
                /**
                 * recibe el mensaje y lo muestra en consola
                 */
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                
            } catch (IOException ex) {
                
            }
        }
    }
    
}