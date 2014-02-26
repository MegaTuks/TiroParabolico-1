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
        Image caballo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo1.png"));
	Image caballo2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo2.png"));
	Image caballo3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo3.png"));
	Image caballo4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo4.png"));
	Image caballo5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo5.png"));
	Image caballo6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo6.png"));
	Image caballo7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo7.png"));
	Image caballo8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/caballo8.png"));
	Image ave1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave1.png"));
	Image ave2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave2.png"));
	Image ave3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave3.png"));
        Image ave4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave4.png"));
        Image ave5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave5.png"));
        Image ave6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/ave6.png"));
        
        bala = new SoundClip("sounds/bala.wav"); //sonido de bala
        explosion = new SoundClip("sounds/explosion.wav");  //sonido de explosion
        
        //Se crea un nuevo objeto bueno y se añaden los cuadros de animación
        caballo = new Bueno(getWidth() / 2, getHeight() / 2, caballo1);
        caballo.sumaCuadro(caballo1, 75);
        caballo.sumaCuadro(caballo2, 75);
        caballo.sumaCuadro(caballo3, 75);
        caballo.sumaCuadro(caballo4, 75);
        caballo.sumaCuadro(caballo5, 75);
        caballo.sumaCuadro(caballo6, 75);
        caballo.sumaCuadro(caballo7, 75);
        caballo.sumaCuadro(caballo8, 75);
        
        
        lista = new LinkedList(); // se crea una nueva lista encadenada
        
        // Se genera un número random entre 1 y 3 para definir el númeor de malos
        int randMal = (int)(Math.random() * 3 + 1);
        
        if (randMal == 1) {
            numMalos = 12;
        }
        
        else if (randMal == 2) {
            numMalos = 14;
        }
        
        else {
            numMalos = 16;
        }
        
        //Se añaden los objetos malos a la lista encadenada
        for (int i = 0; i < numMalos; i++) {
            //se crea un número random para la posición x del objeto malo
            //dependiendo del número de objetos existentes
            if (i < numMalos / 2) {
                int rand = (int)(Math.random() * (getWidth() - 100));
                //se crea un número random para la velocidad del objeto
                int vel = (int)(Math.random() * 4 + 3);
                //se crea un objeto malo
                ave = new Malo(rand, -50, ave1, vel);
            }
            
            else {
                int rand = (int)(Math.random() * (getWidth() - 100));
                //se crea un número random para la velocidad del objeto
                int vel = (int)(Math.random() * 4 - 6);
                //se crea un objeto malo
                ave = new Malo(rand, getHeight() + 25, ave1, vel);
            }
            //se añaden los cuadros de animación
            ave.sumaCuadro(ave1, 100);
            ave.sumaCuadro(ave2, 100);
            ave.sumaCuadro(ave3, 100);
            ave.sumaCuadro(ave4, 100);
            ave.sumaCuadro(ave5, 100);
            ave.sumaCuadro(ave6, 100);
            lista.add(ave);
        }
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
         for (int i = 0; i < lista.size(); i++) {
             ((Malo)lista.get(i)).actualiza(tiempoTranscurrido);
         }
         
         //Actualiza la posición de cada malo con base en su velocidad
         for (int i = 0; i < lista.size(); i++) {
             ((Malo)lista.get(i)).setPosY(((Malo)lista.get(i)).getPosY() + ((Malo)lista.get(i)).getVelocidad());
         }
         
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
        for (int i = 0; i < lista.size(); i++) {
            //Verifica que el caballo intersecte al objeto malo
            if (caballo.intersecta((Malo)lista.get(i))) {
                tiempoChoque = System.currentTimeMillis(); //guarda el tiempo en que ocurrió el choque
                desaparece = true;  //se activa el mensaje desaparece
                bala.play();  //reproducre sonido de bala
                ((Malo)lista.get(i)).setConteo(((Malo)lista.get(i)).getConteo() + 1);
                if (i < lista.size() / 2) {
                    // Reposiciona el asteroide en x random
                    ((Malo)lista.get(i)).setPosX((int)(Math.random() * (getWidth() - ((Malo)lista.get(i)).getAncho())));
                    ((Malo)lista.get(i)).setPosY(-50);
                }
                
                else {
                    // Reposiciona el asteroide en x random
                    ((Malo)lista.get(i)).setPosX((int)(Math.random() * (getWidth() - ((Malo)lista.get(i)).getAncho())));
                    ((Malo)lista.get(i)).setPosY(getHeight() + 25);
                }
            }
        }
        
        //Verifica que cada objeto malo choque con el applet
        for (int i = 0; i < lista.size(); i++) {
            
            if (i < lista.size() / 2) {
                //Verifica que el objeto malo choque con el fondo del applet
                if (((Malo)lista.get(i)).getPosY() + ((Malo)lista.get(i)).getAlto() > getHeight()) {
                    explosion.play();  //reproduce sonido de explosión
                    // Reposiciona el asteroide en x random
                    ((Malo)lista.get(i)).setPosX((int)(Math.random() * (getWidth() - 50)));
                    ((Malo)lista.get(i)).setPosY(-50);
                }
            }
            
            else {
                //Verifica que el objeto malo choque con el principio del applet
                if (((Malo)lista.get(i)).getPosY() < 0) {
                    explosion.play();  //reproduce sonido de explosión
                    // Reposiciona el asteroide en x random
                    ((Malo)lista.get(i)).setPosX((int)(Math.random() * (getWidth() - 50)));
                    ((Malo)lista.get(i)).setPosY(getHeight() + 25);
                }
            }

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
            // Dibuja el caballo
            g.drawImage(caballo.getImagen(), caballo.getPosX(), caballo.getPosY(), this);
            //Dibuja los objetos malos
            for (int i = 0; i < lista.size(); i++) {
                //Dibuja los puntos
                g.drawString("Puntos: " + Integer.toString(((Malo)lista.get(i)).getConteo()), 1100, 50); 
                g.drawImage(((Malo)lista.get(i)).getImagen(), ((Malo)lista.get(i)).getPosX(), ((Malo)lista.get(i)).getPosY(), this);
            }
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