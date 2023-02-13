/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.IOException;
import pantallas.ProductosFrm;

/**
 *
 * @author rjsaa
 */
public class MainCliente {
    public static void main(String[] args) throws IOException
    {
//        Cliente cli = new Cliente(); //Se crea el cliente
//
//        System.out.println("Iniciando cliente\n");
//        cli.startClient(); //Se inicia el cliente
        
        ProductosFrm p = new ProductosFrm();
        p.setVisible(true);
    }
}
