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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException; 
import java.lang.Math;

public class TiroParabolico extends JFrame implements Runnable, KeyListener, MouseListener {
    private Graphics dbg;  //gráfico
    private Image dbImage;  // imagen a proyectar
    private Bueno nave;  //objeto de la clase bueno
    private Malo esfera;  // objeto de la calse malo
    private long tiempoActual;  //tiempo actual
    private boolean pausa;  //pausa del juego
    private int direccion;  //dirección del objeto bueno
    private boolean click; //guarda si se está haciendo click
    private int clickX; //guarda la posición en X del click
    private int clickY; //guarda la posición en Y del click
    private SoundClip explosion; //sonido explosion
    private SoundClip moneda; //sonido explosion
    private SoundClip fondoM;
    private Image fondo;
    private Image tierra;
    private boolean info;
    private Image pausaImagen;
    private Image infoImagen;
    private Bueno ovni;
    private Image creditos;
    private String filename;
    private String[] arr;
    private int scores;
    private int vidas;
    private boolean sonido;
    private int gravedad; // valor de la gravedad.
    private boolean movido;
    private int choques;
    private int r;
    private int velocidad;
    private int vX;
    private int vY;
    
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
        vidas = 5; // cantidad inicial de vidas
        scores = 0; // socre inicial
        filename = "puntajes.txt"; // nombre del archivo a modificar donde se guardara la informacion del juego
        sonido = true; // boooleana apra prender sonido
        gravedad = 1; //gravedad del jeugo
        movido = true; //booleana para ver si ya empezo a moverse
        info = false; //booleana para desplegar instrucciones
        choques = 0;// cantidad de choques
        vX = (int)(Math.random() * 5 + 13); // posiciones de velocidad x
        vY = (int)(Math.random() * 12 + 15); //posiciones de velocidad y
        setSize(1024, 640);  //se redimenciona el applet
        setBackground(Color.white);  //fondo blanco del applet
        addKeyListener(this);  //se añade el keyListener al applet
        addMouseListener(this);  //se añade el mouseListeenr al applet
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar aplicación al cerrar ventana
        
        //URL's de las imágenes de ambas animaciones y los sonidos
        fondo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/fondo.jpg"));
        tierra = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/tierra.png"));
        pausaImagen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/pausa.png"));
        infoImagen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/infor.png"));
        creditos = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/creditos.png"));
        Image nave0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave0.png"));
	Image nave1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave1.png"));
	Image nave2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave2.png"));
	Image nave3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave3.png"));
	Image nave4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave4.png"));
	Image nave5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave5.png"));
	Image nave6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave6.png"));
	Image nave7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave7.png"));
        Image nave8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave8.png"));
        Image nave9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave9.png"));
        Image nave10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave10.png"));
        Image nave11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave11.png"));
        Image nave12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave12.png"));
        Image nave13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave13.png"));
        Image nave14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave14.png"));
        Image nave15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave15.png"));
        Image nave16= Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave16.png"));
        Image nave17 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave17.png"));
        Image nave18 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave18.png"));
        Image nave19 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave19.png"));
        Image nave20= Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave20.png"));
        Image nave21 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave21.png"));
        Image nave22 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave22.png"));
        Image nave23 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave23.png"));
        Image nave24 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave24.png"));
        Image nave25= Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave25.png"));
        Image nave26 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave26.png"));
        Image nave27 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave27.png"));
        Image nave28 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave28.png"));
        Image nave29 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave29.png"));
        Image nave30= Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave30.png"));
        Image nave31 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/nave31.png"));
        Image s0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s0.png"));
	Image s1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s1.png"));
	Image s2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s2.png"));
        Image s3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s3.png"));
        Image s4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s4.png"));
        Image s5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s5.png"));
        Image s6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s6.png"));
        Image s7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s7.png"));
        Image s8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s8.png"));
        Image s9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s9.png"));
        Image s10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s10.png"));
        Image s11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s11.png"));
        Image s12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s12.png"));
        Image s13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s13.png"));
        Image s14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s14.png"));
        Image s15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s15.png"));
        Image s16 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s16.png"));
        Image s17 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s17.png"));
        Image s18 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s18.png"));
        Image s19 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s19.png"));
        Image s20 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s20.png"));
        Image s21 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s21.png"));
        Image s22 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s22.png"));
        Image s23 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s23.png"));
        Image s24 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/s24.png"));
        Image o0 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o0.gif"));
        Image o1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o1.gif"));
        Image o2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o2.gif"));
        Image o3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o3.gif"));
        Image o4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o4.gif"));
        Image o5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/o5.gif"));
        
        explosion = new SoundClip("sounds/explosion.wav"); //sonido de explosion
        moneda = new SoundClip("sounds/moneda.wav");  //sonido de explosion
        fondoM = new SoundClip("sounds/musicaFondo.wav");  //sonido de explosion
        
        //Se crea un nuevo objeto bueno y se añaden los cuadros de animación
        nave = new Bueno(getWidth() / 2, getHeight() - 50, nave0);
        nave.sumaCuadro(nave0, 75);
        nave.sumaCuadro(nave1, 75);
        nave.sumaCuadro(nave2, 75);
        nave.sumaCuadro(nave3, 75);
        nave.sumaCuadro(nave4, 75);
        nave.sumaCuadro(nave5, 75);
        nave.sumaCuadro(nave6, 75);
        nave.sumaCuadro(nave7, 75);
        nave.sumaCuadro(nave8, 75);
        nave.sumaCuadro(nave9, 75);
        nave.sumaCuadro(nave10, 75);
        nave.sumaCuadro(nave11, 75);
        nave.sumaCuadro(nave12, 75);
        nave.sumaCuadro(nave13, 75);
        nave.sumaCuadro(nave14, 75);
        nave.sumaCuadro(nave15, 75);
        nave.sumaCuadro(nave16, 75);
        nave.sumaCuadro(nave17, 75);
        nave.sumaCuadro(nave18, 75);
        nave.sumaCuadro(nave19, 75);
        nave.sumaCuadro(nave20, 75);
        nave.sumaCuadro(nave21, 75);
        nave.sumaCuadro(nave22, 75);
        nave.sumaCuadro(nave23, 75);
        nave.sumaCuadro(nave24, 75);
        nave.sumaCuadro(nave25, 75);
        nave.sumaCuadro(nave26, 75);
        nave.sumaCuadro(nave27, 75);
        nave.sumaCuadro(nave28, 75);
        nave.sumaCuadro(nave29, 75);
        nave.sumaCuadro(nave30, 75);
        nave.sumaCuadro(nave31, 75);
        
        // del objeto malo se crea la esfera y se anima.
        esfera = new Malo(50, getHeight() - 100, s0, vX, vY);
        esfera.sumaCuadro(s0, 100);
        esfera.sumaCuadro(s1, 100);
        esfera.sumaCuadro(s2, 100);
        esfera.sumaCuadro(s3, 100);
        esfera.sumaCuadro(s4, 100);
        esfera.sumaCuadro(s5, 100);
        esfera.sumaCuadro(s6, 100);
        esfera.sumaCuadro(s7, 100);
        esfera.sumaCuadro(s8, 100);
        esfera.sumaCuadro(s9, 100);
        esfera.sumaCuadro(s10, 100);
        esfera.sumaCuadro(s11, 100);
        esfera.sumaCuadro(s12, 100);
        esfera.sumaCuadro(s13, 100);
        esfera.sumaCuadro(s14, 100);
        esfera.sumaCuadro(s15, 100);
        esfera.sumaCuadro(s16, 100);
        esfera.sumaCuadro(s17, 100);
        esfera.sumaCuadro(s18, 100);
        esfera.sumaCuadro(s19, 100);
        esfera.sumaCuadro(s20, 100);
        esfera.sumaCuadro(s21, 100);
        esfera.sumaCuadro(s22, 100);
        esfera.sumaCuadro(s23, 100);
        esfera.sumaCuadro(s24, 100);
        
        ovni = new Bueno(0, getHeight() - 100, o0);
        ovni.sumaCuadro(o0, 150);
        ovni.sumaCuadro(o1, 150);
        ovni.sumaCuadro(o2, 150);
        ovni.sumaCuadro(o3, 150);
        ovni.sumaCuadro(o4, 150);
        ovni.sumaCuadro(o5, 150);
    }

    /** 
    * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
    * En este metodo se crea e inicializa el hilo
    * para la animacion este metodo es llamado despues del init o 
    * cuando el usuario visita otra pagina y luego regresa a la pagina
    * en donde esta este <code>JFrame</code>
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
     * se repinta el <code>Jframe</code> y luego manda a dormir el hilo.
     * 
     */
    @Override
    public void run () {
        tiempoActual = System.currentTimeMillis();
        
        while (vidas > 0) {
            
            if (sonido) {
                if (!fondoM.getLooping()) {
                    fondoM.setLooping(true);
                    fondoM.play(); 
                }
            }
            else {
                fondoM.setLooping(false);
                fondoM.stop();
            }

            // Se ejecutará siempre
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
    
      * Metodo <I>actualiza</I> sobrescrito de la clase 
    * En este metodo se actualizan las posciciones de la nave
    *  y de la esfera. asi como actualizar las booleanas
    * 
    */
    public void actualiza() {
         //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
         long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
         
         //Guarda el tiempo actual
       	 tiempoActual += tiempoTranscurrido;
         
         //Actualiza la animación con base en el tiempo transcurrido
         if (direccion != 0) {
             nave.actualiza(tiempoTranscurrido);
         }
         
         
         //Actualiza la animación con base en el tiempo transcurrido para cada malo
         if (click) {
             esfera.actualiza(tiempoTranscurrido);
         }
         
         
         ovni.actualiza(tiempoTranscurrido);
         
         //Actualiza la posición de cada malo con base en su velocidad
         //esfera.setPosY(esfera.getPosY() + esfera.getVelocidad());
         
         
         
         if (esfera.getPosX() != 50 || esfera.getPosY() != getHeight() - 100) {
             movido = false;
         }
         
         if (click) { // si click es true hara movimiento parabolico
             esfera.setPosX(esfera.getPosX() + esfera.getVelocidadX());
             esfera.setPosY(esfera.getPosY() - esfera.getVelocidadY());
             esfera.setVelocidadY(esfera.getVelocidadY() - gravedad);
         }
         
         if (direccion == 1) { // velocidad de las naves entre menos vidas menor el movimiento
             nave.setPosX(nave.getPosX() - vidas - 2);
         }
         
         else if (direccion == 2) {
             nave.setPosX(nave.getPosX() + vidas + 2);
         }
    }
    
    /**
     * Metodo usado para checar las colisiones del objeto tierra y asteroide
     * con las orillas del <code>JFrame</code> y entre sí.
     */
    public void checaColision() {
        //Verifica que la nave no choque con el applet por la derecha
        if (nave.getPosX() + nave.getAncho() > getWidth()) {
            nave.setPosX(getWidth() - nave.getAncho());
        }
        
        //Verifica que nave no choque con el applet por la izquierda
        if (nave.getPosX() < getWidth() / 2) {
            nave.setPosX(getWidth() / 2);
        }
        
        //Verifica que cada objeto malo no choque con el caballo
        if (nave.intersecta(esfera)) {
            if (sonido) {
                moneda.play();  //reproducre sonido de choque corecto           
            }
            vX = (int)(Math.random() * 5 + 13); //genera nueva velocidad x
            vY = (int)(Math.random() * 12 + 15); // genera nueva veolicdad y
            esfera.setConteo(esfera.getConteo() + 1);
            esfera.setPosX(50);// pone la espera en la posicion original
            esfera.setPosY(getHeight() - 100); // pone la esfera en la posicion original
            esfera.setVelocidadY(vY);//valor de velocidad
            scores += 2; // aumenta el score si intersecta
            click = false;
            movido = true;
        }
        
        //Verifica que cada objeto malo choque con el applet
        if (esfera.getPosY() + esfera.getAlto() > getHeight()) {
            if (sonido) {
                explosion.play();  //reproducre sonido de bala           
            }
            vX = (int)(Math.random() * 5 + 13);
            vY = (int)(Math.random() * 12 + 15);
            esfera.setPosX(50);
            esfera.setPosY(getHeight() - 100);
            esfera.setVelocidadY(vY);
            choques++;
            click = false;
            movido = true;

        }
        
        if (choques == 3) {
            vidas--;
            choques = 0;
        }
    }
    
    public void leeArchivo() throws IOException {
        BufferedReader fileIn;
                try {
                    fileIn = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException e){
                    File puntos = new File(filename);
                    PrintWriter fileOut = new PrintWriter(puntos);
                    fileOut.println("512,0,512,100,0,0");
                    fileOut.close();
                    fileIn = new BufferedReader(new FileReader(filename));
                }
                String dato = fileIn.readLine();
                while(dato != null) {
                    
                      arr = dato.split(",");
                      nave.setPosX(Integer.parseInt(arr[0])); //pos x de nave
                      nave.setPosY(Integer.parseInt(arr[1])); // pos y de nave
                      esfera.setPosX(Integer.parseInt(arr[2])); // pos x de esfera
                      esfera.setPosY(Integer.parseInt(arr[3])); // posy de esfera
                      esfera.setVelocidadX(Integer.parseInt(arr[4])); //vel de esfera en x
                      esfera.setVelocidadY(Integer.parseInt(arr[5]));// vel de esfera en y
                      vidas = (Integer.parseInt(arr[6])); // vidas
                      scores = (Integer.parseInt(arr[7])); //score actual
                      choques = (Integer.parseInt(arr[8])); //choques acomulados
                      if ((Integer.parseInt(arr[9])) == 1) { //checar respectivas booleanas
                          click = true;
                      }
                      else {
                          click = false;
                      }
                      if ((Integer.parseInt(arr[10])) == 1) {
                          sonido = true;
                      }
                      else {
                          sonido = false;
                      }
                      
                      dato = fileIn.readLine();
                }
                fileIn.close();
        }
    public void grabaArchivo() throws IOException {
            PrintWriter fileOut = new PrintWriter(new FileWriter(filename));
            String graba; //graba el archivo de (naveposx,naveposy,esferaposx,esferaposy,velocidadx,veloidady,vidas, score , choque,click,sonido)
            graba = Integer.toString(nave.getPosX()) + "," + Integer.toString(nave.getPosY()) + "," + Integer.toString(esfera.getPosX()) + "," + Integer.toString(esfera.getPosY()) + "," + Integer.toString(esfera.getVelocidadX()) + "," + Integer.toString(esfera.getVelocidadY()) + "," + Integer.toString(vidas)+ "," + Integer.toString(scores) + "," + Integer.toString(choques);
            if (click) {
                graba += ",1";
            }
            else {
                graba += ",0";
            }
            
            if (sonido) {
                graba += ",1";
            }
            else {
                graba += ",0";
            }
            fileOut.println(graba);
            fileOut.close();
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
        }
        
        if (e.getKeyCode() == KeyEvent.VK_I) {
            //Se cambia el estado de la variable pausa dependiendo de su
            //valor actual y desaparece el letrero de desaparece
            info = !info;
            pausa = !pausa;
        }

        if (e.getKeyCode() == KeyEvent.VK_G) { //tecla para grabar el juego
            if (!info) {
                try {
                    grabaArchivo();
            } catch(IOException f) {
                    System.out.println("");
              }
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_C) { // tecla para cargar el juego anterior
            try {
                leeArchivo();
            } catch(IOException f) {
                System.out.println("");
            }
        }

        //Se cambia la dirección del bueno con base en la tecla oprimida
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direccion = 1;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direccion = 2;
        }
    }
    
    /**
     * Método <I>keyReleased<I/> de la clase <code>KeyListener</code>
     * @param e es el <code>evento</code> del teclado
     */
    @Override
    public void keyReleased(KeyEvent e) { //detener direcciones
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
            direccion = 0;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direccion = 0;
        }
        
                if (e.getKeyCode() == KeyEvent.VK_S) {//encender apagar musica y sonidos.
            sonido = !sonido;
        }
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
        if (esfera.clickDentro(e.getX(), e.getY())) {
            //cambia el estado de la variable click
            if (movido) {
                click = true;
            }
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
        g.setColor(Color.white);
        //Verifica que los objetos existan
        if (nave != null && esfera != null && ovni != null) { 
            
            if (info) {
                g.drawImage(infoImagen, 0, 0, getWidth(), getHeight(), this);
            }

            else {

                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                g.drawImage(tierra, getWidth() / 2, getHeight() - 100, 512, 512, this);
                g.drawImage(ovni.getImagen(), ovni.getPosX(), ovni.getPosY(), this);
                // Dibuja el caballo
                g.drawImage(nave.getImagen(), nave.getPosX(), nave.getPosY(), this);
                //Dibuja los objetos malos
                g.drawImage(esfera.getImagen(), esfera.getPosX(), esfera.getPosY(), this);
                //Verifica que haya desaparecido un objeto malo y dibuja el mensaje desaparece
                g.drawString("Vidas: " + vidas + "   Puntos: " + scores, getWidth() - 200, 50);
                if (pausa) {
                     //Dibuja el mensaje de pausado
                    g.drawImage(pausaImagen, getWidth() / 2 - 202, getHeight() / 2 - 197, 405, 392, this);
                }  
            }
            
            if (vidas <= 0) {
                g.drawImage(creditos, 0, 0, getWidth(), getHeight() , this);
            }
        }
        
        else {
            //Da un mensaje mientras se carga el dibujo
            g.drawString("No se cargo la imagen..", 20, 20);
        }
    }
}