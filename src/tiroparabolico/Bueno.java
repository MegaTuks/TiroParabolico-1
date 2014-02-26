/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ecristerna
 */

package tiroparabolico;

import java.awt.Image;

public class Bueno extends Base {
    private final static String DESAPARECE = "DESAPARECE";  //String constante
    private final static String PAUSADO = "PAUSADO";  //String constante
    
    /**
     * Método constructor de la calse <I>Bueno</I>
     * 
     * @param posX es la posición en x del tipo <code>int</code> del objeto
     * @param posY es la posición en y del tipo <code>int</code> del objeto
     * @param image es la imagen del tipo <code>Image</code> del objeto
     */
    public Bueno(int posX, int posY, Image image) {
        super(posX, posY, image); //se utiliza el constructor de la clase padre
    }
    
    /**
     * Método <I>getDesaparece</I> que regresa el valor de desaparece
     * 
     * @return el valor de desaparece del tipo <code>String</code>
     */
    public static String getDesaparece() {
        return DESAPARECE;  //regresa el valor de desaparece
    }
    
    /**
     * Método <I>getPausado</I> que regresa el valor de desaparece
     * 
     * @return el valor de pausado del tipo <code>String</code>
     */
    public static String getPausado() {
        return PAUSADO;  //regresa el valor de pausado
    }
}