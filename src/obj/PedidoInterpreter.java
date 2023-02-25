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
        return  pedido.getProducto().getNombre()+","+pedido.getCantidad()  ;
    }
    public static Pedido fromString(String string) {
        String[] parts = string.split(",");
        Producto producto = new Producto();
        producto.setNombre(parts[0]);
        return new Pedido(Integer.parseInt(parts[1]),producto);
    }
}
