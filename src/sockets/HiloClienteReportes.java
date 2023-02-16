/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import obj.Producto;
import obj.ProductoInterpreter;
import obj.Reporte;
import obj.ReporteInterpreter;
import pantallas.ProductosFrm;
import pantallas.ReportesFrm;


/**
 * hilo que ayudara a escuchar los mensajes recibidos del lado del cliente
 * @author rjsaa
 */
public class HiloClienteReportes extends Thread{
    //sockets y buffer a usar para interpretar el mensaje
    
    Socket socket = null;
    DataInputStream in= null;
    Producto recibidoPro = null;
    Reporte recibidoRep = null;
    ReportesFrm rFrm=null;
    /**
     * construcor que inicializa el socket al socket de la clase cliente
     * @param ds 
     */
    public HiloClienteReportes(Socket socket,DataInputStream in,ReportesFrm rFrm) {
        this.socket = socket;
        this.in= in;
        this.rFrm = rFrm;
    }
      
    /**
     * clase que activa el hilo
     */
    @Override
    public void run(){
        while(true){
            try {
                Gson gson = new Gson();
                /**
                 * recibe el mensaje y lo muestra en consola
                 */
                String mensaje = in.readUTF();

                System.out.println(mensaje);
                
                
                recibidoPro = ProductoInterpreter.fromString(mensaje);
                    
                rFrm.agregarReporte(recibidoPro);
                
            } catch (IOException ex) {
                
            }
        }
    }
    
}