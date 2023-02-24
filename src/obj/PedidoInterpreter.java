/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obj;

/**
 *
 * @author Alexandra
 */
public class PedidoInterpreter {
    public static String toString(Pedido pedido) {
        return pedido.getIdReporte()+","+ pedido.getProducto().getNombre()+ "," + pedido.getCantidad();
    }
    public static Producto fromString(String string) {
        String[] parts = string.split(",");
        return new Producto(parts[0], parts[1]);
    }
}
