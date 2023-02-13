/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obj;

/**
 *
 * @author Alexandra
 */
public class ReporteInterpreter {
    public static String toString(Reporte reporte) {
        return reporte.getIdReporte()+ "," + reporte.getProducto().getNombre() + "," + reporte.getProducto().getDescripcion();
    }
    public static Producto fromString(String string) {
        String[] parts = string.split(",");
        return new Producto(Integer.parseInt(parts[0]), parts[1], parts[2]);
    }
}
