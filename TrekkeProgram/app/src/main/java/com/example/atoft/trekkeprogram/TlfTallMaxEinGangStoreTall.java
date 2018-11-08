package com.example.atoft.trekkeprogram;

import java.io.Serializable;
import java.util.ArrayList;

public class TlfTallMaxEinGangStoreTall implements Serializable {

    ArrayList<Integer> opptatTall = new ArrayList<>();

    ArrayList<Integer> forrigeTall = new ArrayList<>();

    int nedre = 0;
    int ovre = 0;

    TlfTallMaxEinGangStoreTall(int nedre, int ovre){
        this.nedre = nedre;
        this.ovre = ovre;
    }


    public int trekkTall (){

        int tilfeldig = (int )(Math.random() * (ovre-nedre +1) + nedre);
        while (opptatTall.contains(tilfeldig)){
            tilfeldig = (int )(Math.random() * (ovre-nedre +1) + nedre);
        }


        forrigeTall.add(0, tilfeldig);
        if (forrigeTall.size() > 5) {

            forrigeTall.remove(forrigeTall.size()- 1);

        }
        opptatTall.add(tilfeldig);

        return (tilfeldig);

    }

    public String getListe(){
        String s = "";
        for (Integer tall: forrigeTall){
            s+= tall + "\n";
        }
        return(s);
    }




}
