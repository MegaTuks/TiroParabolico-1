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

public class Malo extends Base {
    private static int conteo;  //variable de conteo
    private int velocidadX;  //variable de velocidad
    private int velocidadY;
    
    /**
     * Método constructor de la clase <I>Malo</I>
     * 
     * @param posX es la posición en x del tipo <code>int</code> del objeto
     * @param posY es la posición en y del tipo <code>int</code> del objeto
     * @param image es la imagen del tipo <code>Image</code> del objeto
     * @param vel es la velociad del tipo <code>int</code> del objeto
     */
    public Malo(int posX, int posY, Image image, int velX, int velY) {
        super(posX, posY, image);  //se utiliza el constructor de la clase padre
        velocidadX = velX;  //se define la velocidad del objeto
        velocidadY = velY;
    }
    
    /**
     * Método <I>setConteo</I> para definir el conteo del objeto
     * 
     * @param cont es el conteo que se almacenará del tipo <code>int</code>
     */
    public static void setConteo(int cont) {
        conteo = cont;  //se define el conteo
    }
    
    /**
     * Método <I>getConteo</I> que regresa el conteo del objeto
     * 
     * @return valor de conteo del tipo <code>int</code>
     */
    public static int getConteo() {
        return conteo;  //regresa el valor de conteo
    }
    
    /**
     * Método <I>setVelocidad</I> que define la velocidad del objeto
     * 
     * @param vel es el valor de la velocidad del tipo <code>int</code>
     */
    public void setVelocidadX(int vel) {
        velocidadX = vel;  //define el valor de la velocidad
    }
    
    /**
     * Método <I>getVelocidad</I> que regresa el valor de la velocidad del objeto
     * 
     * @return valor de la velocidad del objeto de tipo <code>int</code>
     */
    public int getVelocidadX() {
        return velocidadX;  //regresa el valor de la velocidad
    }
    
    public void setVelocidadY(int vel) {
        velocidadY = vel;  //define el valor de la velocidad
    }
    
    public int getVelocidadY() {
        return velocidadY;  //regresa el valor de la velocidad
    }
}
