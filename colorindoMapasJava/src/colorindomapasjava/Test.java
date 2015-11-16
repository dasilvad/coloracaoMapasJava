/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorindomapasjava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author daniel
 */
class Test {
    void draw (Graphics g){
        Polygon RS;
        int xRS[] = {390, 393, 400, 375, 450, 275, 100};
        int yRS[] = {500, 545, 585, 225, 250, 375, 300};
        RS = new Polygon(xRS, yRS, xRS.length);
        g.setColor(Color.BLACK);
        g.drawPolygon(RS);
        
        
    }
}
