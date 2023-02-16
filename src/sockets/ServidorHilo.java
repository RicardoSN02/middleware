package sockets;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.logging.Level;
import javax.swing.JFrame;
import obj.Producto;
import obj.ProductoInterpreter;
import obj.Reporte;
import obj.ReporteInterpreter;

/**
 * hilo que ayudara a escuchar los mensajes recibidos del lado del cliente
 * @author rjsaa
 */
public class ServidorHilo extends Thread{
    //sockets y buffer a usar para interpretar el mensaje
    
    Socket socket = null;
    DataInputStream in= null;
    DataOutputStream out=null;
    JFrame frame=null;
    /**
     * construcor que inicializa el socket al socket de la clase cliente
     * @param 
     */
    public ServidorHilo(Socket socket,DataInputStream in,DataOutputStream out) {
        this.socket = socket;
        this.in= in;
        this.out=out;
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
                Gson gson = new Gson();
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                if(mensaje.contains("{")){
                    Producto producto = gson.fromJson(mensaje,Producto.class);
                    
                    mensaje=ProductoInterpreter.toString(producto);
                    
                    out.writeUTF(mensaje);
                }else{
                 
                    Reporte reporte = ReporteInterpreter.fromString(mensaje);
                    
                    String reporteJson = gson.toJson(reporte);
                    
                    out.writeUTF(reporteJson);
                }
                
                

                
                
                
                
            } catch (IOException ex) {
                
            }
        }
    }
    
}
