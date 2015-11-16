
package colorindomapasjava;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 

class BigBang extends JComponent implements ActionListener{
  Timer timer; 
  World world; 
  BigBang(int delay, World world) {
    timer = new Timer(delay, this); 
    this.world = world;
  } 
  public void start() {
    timer.start();  
  }
  BigBang(World world) {
    this(1000, world);  
  }
  @Override
  public void paintComponent(Graphics g) {
    world.draw(g);  
  }
  public void actionPerformed(ActionEvent e) {
    world.update(); 
    if (world.hasEnded())
      timer.stop(); 
    this.repaint(); 
  }
   
}
