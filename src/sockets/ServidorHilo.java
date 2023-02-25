package sockets;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import obj.Pedido;
import obj.PedidoInterpreter;
import obj.Producto;
import obj.ProductoInterpreter;
import obj.Reporte;
import obj.ReporteInterpreter;

/**
 * hilo que ayudara a escuchar los mensajes recibidos del lado del cliente
 *
 * @author rjsaa
 */
public class ServidorHilo extends Thread {
    //sockets y buffer a usar para interpretar el mensaje

    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    JFrame frame = null;
    HiloAceptarClientes acceso = null;

    /**
     * construcor que inicializa el socket al socket de la clase cliente
     *
     * @param
     */
    public ServidorHilo(Socket socket,HiloAceptarClientes acceso) {
            this.socket = socket;
            this.acceso = acceso;
    }

    /**
     * clase que activa el hilo
     */
    @Override
    public void run() {
        try{
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        }catch(Exception e){
            
        }
        while (true) {
            try {
                /**
                 * recibe el mensaje y lo muestra en consola
                 */

                  Gson gson = new Gson();

                  String mensaje = in.readUTF();
//
                  System.out.println(mensaje);

                  Socket socket[]=this.acceso.devolverSockets();
                  
                  try{
                      Producto producto = gson.fromJson(mensaje, Producto.class);
                      
                      for(Socket x: socket){
                        if(!this.socket.equals(x)){
                            DataOutputStream out = new DataOutputStream(x.getOutputStream());
                            out.writeUTF(mensaje);
                            out.flush();
                        }
                      }
                      
                  }catch(Exception e){
                      
                  }
                  
                  try{
                      Reporte reporte = ReporteInterpreter.fromString(mensaje);
                      
                      for(Socket x: socket){
                        if(!this.socket.equals(x)){
                            DataOutputStream out = new DataOutputStream(x.getOutputStream());
                            out.writeUTF(mensaje);
                            out.flush();
                        }
                      }
                      
                      
                  }catch(Exception e){
                      
                  }
                  
                  //pedido
                  try{
                      Pedido pedido = PedidoInterpreter.fromString(mensaje);
                      
                      
                      for(Socket x: socket){
                        if(!this.socket.equals(x)){
                            DataOutputStream out = new DataOutputStream(x.getOutputStream());
                            out.writeUTF(mensaje);
                            out.flush();
                        }
                      }
                      
                  }catch(Exception e){
                      
                  }
                  

//                if (mensaje.contains("{")) {
//                    
//
//                    mensaje = ProductoInterpreter.toString(producto);
//
//                    out.writeUTF(mensaje);
//                } else {
//
//                    
//
//                    String reporteJson = gson.toJson(reporte);
//
//                    out.writeUTF(reporteJson);
//                }

            } catch (IOException ex) {

            }
        }
    }

}
