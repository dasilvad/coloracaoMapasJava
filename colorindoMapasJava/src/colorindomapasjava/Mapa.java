/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorindomapasjava;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author daniel
 */
/*cria o grafo de estados.
*/
public class Mapa {
    ArrayList <Estado> estado;
    ArrayList<ArrayList> mapa = new ArrayList<>();
    Color defautColor = Color.WHITE;
    
    @SuppressWarnings("empty-statement")
    void criarMapaBrazil(){
        String[][] grafo = {
            {"RS", "SC"}, 
            {"SC", "RS", "PR"},
            {"PR", "SC", "SP", "MS"},
            {"SP", "PR", "MS", "RJ", "MG"},
            {"MS", "PR", "SP", "GO", "MG", "MT"},
            {"RJ", "SP", "MG", "ES"},
            {"MG", "GO", "MS", "SP", "RJ", "ES", "BA"}, 
            {"ES", "MG", "RJ", "BA"},
            {"GO", "BA", "TO", "MT", "MS", "MG"},
            {"MT", "PA","AM", "RO", "MS", "GO", "TO"},
            {"TO", "MA", "PA", "MT", "GO", "BA"},
            {"BA", "SE", "AL", "PE", "PI", "MA", "TO", "GO", "MG", "ES"},
            {"RO", "AM", "AC", "MT"},
            {"AC", "RO", "AM"},
            {"AM", "RR", "AC", "MT", "RO", "PA"},
            {"RR", "PA", "AM"},
            {"PA", "AP", "RR", "AM", "MT", "TO", "MA"},
            {"AP", "PA"},
            {"MA", "PA", "TO", "BA", "PI"},
            {"PI", "MA", "BA", "PE", "CE"},
            {"CE", "PI", "PE", "PB", "RN"},
            {"RN", "CE", "PB"},
            {"PB", "RN", "CE", "PE"},
            {"PE", "PB", "CE", "PI", "BA", "AL"},
            {"AL", "PE", "BA", "SE"},
            {"SE", "AL", "BA"}   
        };
        
        for (String[] linha : grafo) {
            estado = new ArrayList<>();
            for (String coluna : linha) {
                estado.add(new Estado(coluna, defautColor));
            }
            mapa.add(estado);   
        }

        
    } 
    
    
     Comparator<ArrayList> ORDENAR_MAPA_CRESCENTE = 
                                        new Comparator<ArrayList>() {
        @Override
        public int compare(ArrayList a1, ArrayList a2) {
            return (a1.size() > a2.size()? -1 :
                   (a1.size() == a2.size() ? 0 : 1));
        }
    };
    
    /*
    1) ordenar de forma crescente de acordo com aquantidade de vertices vizinhos
    2) 
    */
    /*
     ArrayList<Estado> sao os vertices com seus vizinhos
       1st elemento e' o vertice, os demais sao os vertices vizinhos
     */ 
    boolean colorir (ArrayList<Estado> es, Color c){
        
        
        
        for (int i =1; i < es.size(); i++){//percorre os vizinhos de um dado estado
            Estado estado = es.get(i);
            for (int j = 0; j < mapa.size(); j++) {//percorre os vertices do mapa
               Estado elemento =  ((ArrayList<Estado>) mapa.get(j)).get(0);
               if (estado.getSigla().equals(elemento.getSigla())){
                   if (elemento.getColor() == c)
                       return false;
                   else
                       break;
               }
            }
        }
        
        es.get(0).setColor(c);//colore o estado
        return true;
        
    }
        
        
        
    
    
    void colorirMapaBrasil(Color c1, Color c2, Color c3, Color c4){
        Collections.sort(mapa, ORDENAR_MAPA_CRESCENTE);
//        System.out.println(((Estado) (mapa.get(0).get(0))).getSigla());
//        System.out.println(((Estado) (mapa.get(0).get(1))).getSigla());
        Color [] paleta = new Color[4];
        paleta[0]=c1;
        paleta[1]=c2;
        paleta[2]=c3;
        paleta[3]=c4;
        
        Iterator itMapa = mapa.iterator();
        while (itMapa.hasNext()){//percorrde todos os estados do mapa
            ArrayList<Estado> es = (ArrayList<Estado>) itMapa.next();
            
                int i=0;
                while (i < paleta.length){
                    if (colorir(es, paleta[i]))
                        break;
                    i++;
               }
            
        }
        
        
        
        
    }
    
    ArrayList<Estado> getMapaColorido(){
        ArrayList<Estado> estadosColoridos = new ArrayList<>();
        
        Iterator it = mapa.iterator();
        while(it.hasNext()){
            estadosColoridos.add(((ArrayList<Estado>) it.next()).get(0));
        }
        return estadosColoridos;
    }
        
}


