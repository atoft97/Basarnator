package com.example.atoft.trekkeprogram;



import java.io.Serializable;
import java.util.ArrayList;

public class TilfeldigTrekkerMaxEinGang implements Serializable {

    ArrayList<Integer> liste = new ArrayList<>();

    ArrayList<Integer> liste2 = new ArrayList<>();

    TilfeldigTrekkerMaxEinGang(int nedre, int ovre){
        for(int i = nedre; i <= (ovre); i++){
            liste.add(i);
        }
    }

    public int trekkTall(){

        int tilf = (int )(Math.random() * (liste.size()));
        int tall = liste.get(tilf);
        liste.remove(tilf);


        liste2.add(0, tall);
        if (liste2.size() > 5) {
            liste2.remove(liste2.size()- 1);
        }

        return (tall);
    }



    public String getListe (){
        String s = "";
        for (Integer tall: liste2){
            s+= tall + "\n";
        }
        return(s);

    }

    public boolean hasTall (){
        return (!(liste.isEmpty()));
        //return (liste.size());
    }
    public int returnSize(){
        return (liste.size());
    }



}
