/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiroparabolico;

/**
 *
 * @author Tuks
 */

public class SaveFile {
    private int posXnave;
    private int posYnave;
    private int posXbola;
    private int posYbola;
    private int score;
    private int vidas;
   
  public SaveFile()
  {
       posXnave=0;
       posYnave=0;
       posXbola=0;
       posYbola=0;
       score=0;
       vidas=10;
  }/**
     * Metodo constructor usado para crear el objeto
     * @param xnave es la <code>posicion en x</code> del objetonave.
     * @param ynave es la <code>posicion en y</code> del objeto.
     * @param xbola es la <code> posicion en x</code> de la esfera.
     * @param ybola es la <code> posicion en y </code> de la esfera. 
     * @param s es la <code>puntuacion </code> del objeto.
     */  
  public SaveFile(int xnave, int ynave,int xbola, int ybola,int s,int vidas)
  {
    this.posXnave=xnave;
    this.posYnave=ynave;
    this.posXbola=xbola;
    this.posYbola=ybola;
    this.score=s;
    this.vidas=vidas;
  
  } 
  /**
     * Metodo set de posXnave
     * @param xnave es la <code>posicion en x</code> del objetonave.
     */
  public void setXnave(int xnave)
    {
        this.posXnave=xnave;
    }
  /**
     * Metodo set de posYnave
     * @param ynave es la <code>posicion en x</code> del objetonave.
     */
  public void setYnave(int ynave)
  {
      this.posYnave=ynave;
  }
  /**
     * Metodo set de posXbola
     * @param xbola es la <code>posicion en x</code> del objetonave.
     */
  public void setXbola(int xbola)
  {
      this.posXbola=xbola;
  }
   /**
     * Metodo set de posYbola
     * @param ybola es la <code>posicion en x</code> del objetonave.
     */
  public void setYbola(int ybola)
  {
      this.posYbola=ybola;
  }
  /**
     * Metodo set de score
     * @param s es la <code>posicion en x</code> del objetonave.
     */
  public void setScore(int s)
  {
      this.score=s;
  }
  
  public void setVidas(int d)
  {
      this.score=d;
  }
  /**
     * Metodo get de posXnave
     */
  public int getXnave()
  {
      return posXnave;
  }
   /**
     * Metodo get de posYnave
     */
  public int getYnave()
  {
      return posYnave;
  }
   /**
     * Metodo get de posXbola
     */
  public int getXbola()
  {
      return posXbola;
  }
   /**
     * Metodo get de posYbola.
     */
  public int getYbola()
  {
      return posYbola;
  }
  /**
     * Metodo get de score.
     */
  public int getScore()
  {
      return score;
  }
  
  /**
     * Metodo get de vidas.
     */
   public int getVidas()
  {
      return vidas;
  }
}
