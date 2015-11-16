
package colorindomapasjava;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class ColorindoMapasJava implements World{

   Test testDraw = new Test();
    

    @Override
    public void draw(Graphics g) {
        testDraw.draw(g);
    }

    @Override
    public void update() {
        return;
    }

    @Override
    public boolean hasEnded() {
        return false;
    }
    
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.criarMapaBrazil();
        mapa.colorirMapaBrasil(Color.red, Color.blue, Color.yellow, Color.pink);
        ArrayList<Estado> estados= mapa.getMapaColorido();
        
        BigBang bigBang = new BigBang(500, new ColorindoMapasJava()); 
        
        JFrame frame = new JFrame("Maps"); 
        frame.getContentPane().add( bigBang ); 
        frame.setVisible(true); 
        frame.setSize(800, 700); 
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        bigBang.start(); //start timer
        
        for (int i=0; i < estados.size(); i++){
            String sigla = estados.get(i).getSigla();
            Color c = estados.get(i).getColor();
            System.out.println (sigla +" -> " + c);   
        }
    }
    
}
    