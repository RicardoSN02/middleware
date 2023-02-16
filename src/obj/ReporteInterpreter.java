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
        return reporte.getIdReporte()+ "," + reporte.getProducto().getNombre() + "," + reporte.getComentario();
    }
    public static Reporte fromString(String string) {
        String[] parts = string.split(",");
        Producto producto = new Producto();
        producto.setNombre(parts[1]);
        Reporte reporte = new Reporte(parts[2],producto);
//        reporte.setIdReporte(Integer.parseInt(parts[0]));
        return reporte;
    }
}
