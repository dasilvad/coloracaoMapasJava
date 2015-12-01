
package colorindomapasjava;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class ColorindoMapasJava {

   
    
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.criarMapaBrazil();
        mapa.colorirMapaBrasil(Color.blue, Color.red, Color.yellow, Color.green);
        ArrayList<Estado> estados= mapa.getMapaColorido();

        for (int i=0; i < estados.size(); i++){
            String sigla = estados.get(i).getSigla();
            String c = estados.get(i).colorToString();
            System.out.println (sigla +" -> " + c);   
        }
    }
    
}
    