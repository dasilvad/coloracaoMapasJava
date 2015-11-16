/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorindomapasjava;

import java.awt.Color;

/**
 *
 * @author daniel
 */
public class Estado {
    private String sigla;
    private Color color;

    public Estado(String sigla, Color color) {
        this.sigla = sigla;
        this.color = color;
    }
    
    
    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
