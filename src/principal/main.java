/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import pantallas.ProductosFrm;
import pantallas.ReportesFrm;
import sockets.Servidor;

/**
 *
 * @author rjsaa
 */
public class main {
    public static void main(String[] args){
        

      //no usar todavia , incompleto
        //abre productos frm
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosFrm().setVisible(true);
            }
        });        
        
        //abre main de reportes
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesFrm().setVisible(true);
            }
        });
    }
}
