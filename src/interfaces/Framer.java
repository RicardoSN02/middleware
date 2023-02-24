/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author rjsaa
 */
public interface Framer {
    void frameMsg(byte[] messaga,OutputStream out) throws IOException;
    byte[] nextMsg() throws IOException;
}
