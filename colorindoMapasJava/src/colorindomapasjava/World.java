package colorindomapasjava;


import java.awt.*; 
import java.awt.event.*; 

interface World {
  public void draw(Graphics g);
  public void update(); 
  public boolean hasEnded();
  
}
