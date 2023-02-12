/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rjsaa
 */
public class Conexion {
    private final int PUERTO= 4444;
    private final String HOST = "localhost";
    protected String mensajeServidor;
    mbnk protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor,salidaCliente;
    
    
    public Conexion(String tipo) throws IOException{
        if(tipo.equalsIgnoreCase("servidor")){
            ss= new ServerSocket(PUERTO);
            cs= new Socket();
        }else{
            cs = new Socket(HOST,PUERTO);
        }    
    }
}
