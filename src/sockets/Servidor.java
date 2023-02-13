/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author rjsaa
 */
public class Servidor extends Conexion {

    public Servidor() throws IOException {
        super("servidor");
    } //Se usa el constructor para servidor de Conexion

    public void startServer() {
        try {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while (true) {
                // Recibir datos desde el cliente
                String mensaje = entrada.readLine();

                // Verificar si se recibió la señal para detener el servidor
                if (mensaje.equals("bye")) {
                    break;
                }
            }

            System.out.println("Fin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
