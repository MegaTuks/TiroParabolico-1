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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.net.URL;

public class TiroParabolico extends JFrame implements Runnable, KeyListener, MouseListener {
    private Graphics dbg;  //gráfico
    private Image dbImage;  // imagen a proyectar
    private Bueno caballo;  //objeto de la clase bueno
    private Malo ave;  // objeto de la calse malo
    private LinkedList lista;  //lista encadenada
    private long tiempoActual;  //tiempo actual
    private boolean pausa;  //pausa del juego
    private int direccion;  //dirección del objeto bueno
    private int numMalos; //guarda el númeor de objetos malos
    private boolean click; //guarda si se está haciendo click
    private int clickX; //guarda la posición en X del click
    private int clickY; //guarda la posición en Y del click
    private boolean desaparece; //choque del bueno con malo
    private SoundClip bala; //sonido bala
    private SoundClip explosion; //sonido explosion
    private long tiempoChoque; // tiempo del choque con objeto bueno
    private Image img;
   
    
    
    /**
     * Constructor de la clase <I>JFrameExamen</I>
     */
    public TiroParabolico() {
        init();
        start();
    }
    
    /**
     * Método de inicialización de las variables y objetos del <code>Applet</code>
     */
    public void init() {
        direccion = 0; //inicia estático
        click = false; //inicia sin click
        pausa = false;  //se inicia sin pausa
        setSize(1200, 675);  //se redimenciona el applet
        setBackground(Color.white);  //fondo blanco del applet
        addKeyListener(this);  //se añade el keyListener al applet
        addMouseListener(this);  //se añade el mouseListeenr al applet
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar aplicación al cerrar ventana
        
        //URL's de las imágenes de ambas animaciones y los sonidos
        Image caballo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/1.png"));
	Image caballo2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/2.png"));
	Image caballo3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/3.png"));
	Image caballo4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/4.png"));
	Image caballo5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/5.png"));
	Image caballo6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/6.png"));
	Image caballo7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/7.png"));
	Image caballo8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/8.png"));
         Image caballo9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/9.png"));
	Image caballo10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/10.png"));
	Image caballo11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/11.png"));
	Image caballo12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/12.png"));
	Image caballo13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/13.png"));
	Image caballo14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/14.png"));
	Image caballo15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/15.png"));
	Image caballo16 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/16.png"));
	 Image caballo17 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/17.png"));
	Image caballo18 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/18.png"));
	Image caballo19 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/19.png"));
	Image caballo20 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/20.png"));
	Image caballo21 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/21.png"));
	Image caballo22 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/22.png"));
	Image caballo23 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/23.png"));
	Image caballo24 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/24.png"));
         Image caballo25 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/25.png"));
	Image caballo26 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/26.png"));
	Image caballo27 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/27.png"));
	Image caballo28 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/28.png"));
	Image caballo29 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/29.png"));
	Image caballo30 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/30.png"));
	Image caballo31 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/31.png"));
	Image caballo0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/0.png"));
        
        Image ave1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s1.png"));
	Image ave2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s2.png"));
	Image ave3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s3.png"));
        Image ave4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s4.png"));
        Image ave5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s5.png"));
        Image ave6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s6.png"));
        Image ave7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s7.png"));
        Image ave8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s8.png"));
        Image ave9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s9.png"));
        Image ave10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s10.png"));
        Image ave11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s11.png"));
        Image ave12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s12.png"));
        Image ave13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s13.png"));
        Image ave14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s14.png"));
        Image ave15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s15.png"));
        Image ave16 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s16.png"));
        Image ave17 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s17.png"));
        Image ave18 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s18.png"));
        Image ave19 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s19.png"));
        Image ave20 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s20.png"));
        Image ave21 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s21.png"));
        Image ave22 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s22.png"));
        Image ave23 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s23.png"));
        Image ave24 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s24.png"));
        URL oURL = this.getClass().getResource("images/spaces.png");
        
       // gameover = Toolkit.getDefaultToolkit().getImage(goURL);
        img = Toolkit.getDefaultToolkit().getImage(oURL);
        
        bala = new SoundClip("sounds/bala.wav"); //sonido de bala
        explosion = new SoundClip("sounds/explosion.wav");  //sonido de explosion
        //Se crea un nuevo objeto bueno y se añaden los cuadros de animación
        caballo = new Bueno(getWidth() / 2, getHeight() / 2, caballo1);
        caballo.sumaCuadro(caballo0, 75);
        caballo.sumaCuadro(caballo1, 75);
        caballo.sumaCuadro(caballo2, 75);
        caballo.sumaCuadro(caballo3, 75);
        caballo.sumaCuadro(caballo4, 75);
        caballo.sumaCuadro(caballo5, 75);
        caballo.sumaCuadro(caballo6, 75);
        caballo.sumaCuadro(caballo7, 75);
        caballo.sumaCuadro(caballo8, 75);
        caballo.sumaCuadro(caballo9, 75);
        caballo.sumaCuadro(caballo10, 75);
        caballo.sumaCuadro(caballo11, 75);
        caballo.sumaCuadro(caballo12, 75);
        caballo.sumaCuadro(caballo13, 75);
        caballo.sumaCuadro(caballo14, 75);
        caballo.sumaCuadro(caballo15, 75);
        caballo.sumaCuadro(caballo16, 75);
        caballo.sumaCuadro(caballo17, 75);
        caballo.sumaCuadro(caballo18, 75);
        caballo.sumaCuadro(caballo19, 75);
        caballo.sumaCuadro(caballo20, 75);
        caballo.sumaCuadro(caballo21, 75);
        caballo.sumaCuadro(caballo22, 75);
        caballo.sumaCuadro(caballo23, 75);
        caballo.sumaCuadro(caballo24, 75);
        caballo.sumaCuadro(caballo25, 75);
        caballo.sumaCuadro(caballo26, 75);
        caballo.sumaCuadro(caballo27, 75);
        caballo.sumaCuadro(caballo28, 75);
        caballo.sumaCuadro(caballo29, 75);
        caballo.sumaCuadro(caballo30, 75);
        caballo.sumaCuadro(caballo31, 75); 
        
        ave = new Malo(0, 0, ave1, 3);
        
        ave.sumaCuadro(ave1, 100);
        ave.sumaCuadro(ave1, 100);
        ave.sumaCuadro(ave2, 100);
        ave.sumaCuadro(ave3, 100);
        ave.sumaCuadro(ave4, 100);
        ave.sumaCuadro(ave5, 100);
        ave.sumaCuadro(ave6, 100);
        ave.sumaCuadro(ave7, 100);
        ave.sumaCuadro(ave8, 100);
        ave.sumaCuadro(ave9, 100);
        ave.sumaCuadro(ave10, 100);
        ave.sumaCuadro(ave11, 100);
        ave.sumaCuadro(ave12, 100);
        ave.sumaCuadro(ave13, 100);
        ave.sumaCuadro(ave14, 100);
        ave.sumaCuadro(ave15, 100);
        ave.sumaCuadro(ave16, 100);
        ave.sumaCuadro(ave17, 100);
        ave.sumaCuadro(ave18, 100);
        ave.sumaCuadro(ave19, 100);
        ave.sumaCuadro(ave20, 100);
        ave.sumaCuadro(ave21, 100);
        ave.sumaCuadro(ave22, 100);
        ave.sumaCuadro(ave23, 100);
        ave.sumaCuadro(ave24, 100);
    }

    /** 
    * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
    * En este metodo se crea e inicializa el hilo
    * para la animacion este metodo es llamado despues del init o 
    * cuando el usuario visita otra pagina y luego regresa a la pagina
    * en donde esta este <code>Applet</code>
    * 
    */
    public void start() {
        //Crea el thread
        Thread hilo = new Thread(this);
	//Inicializa el thread
        hilo.start();
    }
    
    /** 
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo hasta que pasen los 5 juegos finalmente 
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     * 
     */
    @Override
    public void run () {
        tiempoActual = System.currentTimeMillis();
        
        while (true) {  // Se ejecutará siempre
            //Verifica si el juego está en pausa, de ser así, no actualizará
            //de lo contrario, actualizará
            if (!pausa) {
                actualiza();
                checaColision();
            }
            repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
            
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            
            catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
    }
    
    /**
     * Metodo usado para actualizar la posicion de objetos bueno y malo.
     */
    public void actualiza() {
         //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
         long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
         //Guarda el tiempo actual
       	 tiempoActual += tiempoTranscurrido;
         //Actualiza la animación con base en el tiempo transcurrido
         caballo.actualiza(tiempoTranscurrido);
         
         //verifica que hayan pasado 1.5 segundos desde el choque y desaparece el mensaje
         if (System.currentTimeMillis() - tiempoChoque > 1500) {
             desaparece = false;
         }
         
         //Actualiza la animación con base en el tiempo transcurrido para cada malo
         ave.actualiza(tiempoTranscurrido);
         
         //Actualiza la posición de cada malo con base en su velocidad
         ave.setPosY(ave.getPosY() + ave.getVelocidad());

         //verifica que no esté detenido por haber hecho click sobre el objeto
         if (!click) {
             //actualiza la posición dependiendo de la dirección
             if (direccion == 1) {
                 caballo.setPosY(caballo.getPosY() - 3);
         }
         
             else if (direccion == 2) {
                 caballo.setPosX(caballo.getPosX() + 3);
         }
             
             else if (direccion == 3) {
                 caballo.setPosY(caballo.getPosY() + 3);
         }
             
             else if (direccion == 4) {
                 caballo.setPosX(caballo.getPosX() - 3);
             }
         }
    }
    
    /**
     * Metodo usado para checar las colisiones del objeto tierra y asteroide
     * con las orillas del <code>Applet</code> y entre sí.
     */
    public void checaColision() {
        //Verifica que el caballo no choque con el applet por la derecha
        if (caballo.getPosX() + caballo.getAncho() > getWidth()) {
            caballo.setPosX(getWidth() - caballo.getAncho());
        }
        
        //Verifica que el caballo no choque con el applet por la izquierda
        if (caballo.getPosX() < 0) {
            caballo.setPosX(0);
        }
        
        //Verifica que el caballo no choque con el applet por arriba
        if (caballo.getPosY() <= 0 ) {
            caballo.setPosY(0);
        }
        
        //Verifica que el caballo no choque con el applet por abajo
        if (caballo.getPosY() + caballo.getAlto() > getHeight()) {
            caballo.setPosY(getHeight() - caballo.getAlto());
        }
        
        //Verifica que cada objeto malo no choque con el caballo
        if (caballo.intersecta(ave)) {
            tiempoChoque = System.currentTimeMillis(); //guarda el tiempo en que ocurrió el choque
            desaparece = true;  //se activa el mensaje desaparece
            bala.play();  //reproducre sonido de bala
            ave.setConteo(ave.getConteo() + 1);
            ave.setPosX((int)(Math.random() * (getWidth() - ave.getAncho())));
            ave.setPosY(-50);
        }
        
        //Verifica que cada objeto malo choque con el applet
        if (ave.getPosY() + ave.getAlto() > getHeight()) {
            explosion.play();
            ave.setPosX((int)(Math.random() * (getWidth() - 50)));
            ave.setPosY(-50);
        }
    }
    
    /**
     * Método <I>keyPressed<I/> de la clase <code>KeyListener</code>
     * @param e es el <code>evento</code> del teclado
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Verifica si se oprime la tecla P para pausar o reanudar el juego
        if (e.getKeyCode() == KeyEvent.VK_P) {
            //Se cambia el estado de la variable pausa dependiendo de su
            //valor actual y desaparece el letrero de desaparece
            pausa = !pausa;
            desaparece = false;
        }
        
        //Se cambia la dirección del bueno con base en la tecla oprimida
        if (e.getKeyCode() == KeyEvent.VK_W) {
            direccion = 1;
            click = false;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            direccion = 2;
            click = false;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            direccion = 3;
            click = false;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            direccion = 4;
            click = false;
        }
    }
    
    /**
     * Método <I>keyReleased<I/> de la clase <code>KeyListener</code>
     * @param e es el <code>evento</code> del teclado
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    /**
     * Método <I>KeyTyped<I/> de la clase <code>KeyListener</code>
     * @param e es el <code>evento</code> del teclado
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    /**
     * Método <I>mouseClicked<I/> de la clase <code>MouseListener</code>
     * @param e es el <code>evento</code> del mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //verifica que el click haya sido dentro del objeto caballo
        if (caballo.clickDentro(e.getX(), e.getY())) {
            //cambia el estado de la variable click
            click = !click;
        }
    }
    
    /**
     * Método <I>mouseEntered<I/> de la clase <code>MouseListener</code>
     * @param e es el <code>evento</code> del mouse
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
   
    /**
     * Método <I>mouseExited<I/> de la clase <code>MouseListener</code>
     * @param e es el <code>evento</code> del mouse
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    /**
     * Método <I>mousePressed<I/> de la clase <code>MouseListener</code>
     * @param e es el <code>evento</code> del mouse
     */
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    /**
     * Método <I>mouseReleased<I/> de la clase <code>MouseListener</code>
     * @param e es el <code>evento</code> del mouse
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>,
     * En este metodo lo que hace es actualizar el contenedor
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    @Override
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null){
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

	// Actualiza la imagen de fondo.
        
	dbg.setColor(getBackground ());
	dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

	// Actualiza el Foreground.
	dbg.setColor(getForeground());
	paint1(dbg);

	// Dibuja la imagen actualizada
	g.drawImage(dbImage, 0, 0, this);
    }
    
    /**
     * El método <I>paint1</I> muestra en pantalla la animación
     * @param g
    */
    public void paint1(Graphics g) {
        //Verifica que los objetos existan
        if (caballo != null && ave != null) {
             g.setColor(Color.red);
            
            g.drawImage(img, 0, 0, this); //imagen de fondo.
            // Dibuja el caballo
            g.drawImage(caballo.getImagen(), caballo.getPosX(), caballo.getPosY(), this);
            //Dibuja los objetos malos
            g.drawImage(ave.getImagen(), ave.getPosX(), ave.getPosY(), this);
            //Verifica que haya desaparecido un objeto malo y dibuja el mensaje desaparece
            if (desaparece) {
                g.drawString(caballo.getDesaparece(), caballo.getPosX(), caballo.getPosY());
            }
            //Verifica que no esté en pausa
            if (pausa) {
                //Dibuja el mensaje de pausado
                g.drawString(caballo.getPausado(), caballo.getPosX(), caballo.getPosY());
            } 
        }
        
        else {
            //Da un mensaje mientras se carga el dibujo
            g.drawString("No se cargo la imagen..", 20, 20);
        }
    }
}