/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import obj.ProductoInterpreter;

/**
 *
 * @author rjsaa
 */
public class HiloAceptarClientes extends Thread{

    int posicion=0;
    ServerSocket servidor;
    Socket sc[] = new Socket[3];
    
    
    Socket socketTurno= null;
    
    public HiloAceptarClientes(ServerSocket servidor) {
        this.servidor=servidor;
    }
    
        /**
     * clase que activa el hilo
     */
    @Override
    public void run(){
        while(true){
            try {
                
            
                Socket socket=servidor.accept();
                
                if(!(posicion>=3)){
                
                sc[posicion] = socket;
                
                posicion++;
                
                System.out.println("Cliente "+(posicion)+ " conectado");  
                
                ServidorHilo sh = new ServidorHilo(socket,this);
            
                sh.start();
                
                }else{
                    System.out.println("numero de clientes maximo alcanzado");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(HiloAceptarClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void eliminarCliente(int posicion){
        this.sc[posicion]=null;
        this.posicion-= 1;
    }
    
    public Socket[] devolverSockets(){
        return this.sc;
    }
    
    
}
