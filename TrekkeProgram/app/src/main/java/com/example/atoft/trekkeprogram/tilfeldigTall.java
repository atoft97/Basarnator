package com.example.atoft.trekkeprogram;

import java.io.Serializable;
import java.util.ArrayList;

public class tilfeldigTall implements Serializable {

    private int nedre;
    private int ovre;

    ArrayList<Integer> liste = new ArrayList<>();


    public int trekkTall (){
        int tilfeldig = (int )(Math.random() * (ovre-nedre +1) + nedre);

        liste.add(0, tilfeldig);
        if (liste.size() > 5) {

            liste.remove(liste.size()- 1);

        }

        return (tilfeldig);
    }

    public int getNedre(){
        return(nedre);
    }
    public int getOvre(){
        return (ovre);
    }
    public void setTall(int nedre, int ovre){
        this.nedre = nedre;
        this.ovre = ovre;
    }

    public String getListe(){
        String s = "";
        for (Integer tall: liste){
            s+= tall + "\n";
        }
        return(s);
    }



}
