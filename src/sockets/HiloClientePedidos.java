/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import obj.Producto;
import obj.ProductoInterpreter;
import obj.Reporte;
import obj.ReporteInterpreter;
import pantallas.PedidoFrm;

/**
 *
 * @author Alexandra
 */
public class HiloClientePedidos extends Thread{
    //sockets y buffer a usar para interpretar el mensaje
    
    Socket socket = null;
    DataInputStream in= null;
    Producto recibidoPro = null;
    Reporte recibidoRep = null;
    PedidoFrm pFrm = null;
    /**
     * construcor que inicializa el socket al socket de la clase cliente
     * @param ds 
     */
    public HiloClientePedidos(Socket socket,DataInputStream in,PedidoFrm pFrm) {
        this.socket = socket;
        this.in= in;
        this.pFrm = pFrm;
    }
      
    /**
     * clase que activa el hilo
     */
    @Override
    public void run(){
        while(true){
            try {
                Gson gson = new Gson();


                int numero;


                /**
                 * recibe el mensaje y lo muestra en consola
                 */
                String mensaje = in.readUTF();


                
                try{
                   numero = Integer.parseInt(mensaje);
                   pFrm.setNumeroAsignado(numero);
                }catch(Exception e){
                   System.out.println(mensaje);

                   recibidoPro = ProductoInterpreter.fromString(mensaje);
                    
                   pFrm.agregarReporte(recibidoPro); 
                }

                
            } catch (IOException ex) {
                
            }
        }
    }
}
