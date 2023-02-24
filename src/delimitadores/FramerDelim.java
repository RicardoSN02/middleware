/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package delimitadores;

import interfaces.Framer;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author rjsaa
 */
public class FramerDelim implements Framer {

    private InputStream in;
    private static final byte DELIMITER = '|' ;

    public FramerDelim(InputStream in) {
        this.in = in;
    }

    @Override
    public void frameMsg(byte[] message, OutputStream out) throws IOException {
       for(byte b: message){
           if(b==DELIMITER){
               throw new IOException("Message contains delimiter");
               
           }
       }
       out.write(message);
       out.write(DELIMITER);
       out.flush();
    }

    @Override
    public byte[] nextMsg() throws IOException {
        ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
        int nextByte;
        
        while ((nextByte = in.read()) != DELIMITER){
            if(nextByte == -1){
                if(messageBuffer.size() == 0){
                    return null;
                }else{
                    throw new EOFException("non-empty message without delimiter");
                }
            }
            
            messageBuffer.write(nextByte);
        }
        return messageBuffer.toByteArray();
    }
    
}
