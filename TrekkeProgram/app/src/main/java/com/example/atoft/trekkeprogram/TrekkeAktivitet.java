package com.example.atoft.trekkeprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrekkeAktivitet extends AppCompatActivity {


    tilfeldigTall rndObj;
    TilfeldigTrekkerMaxEinGang rndObj2;
    TlfTallMaxEinGangStoreTall rndObj3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trekke_aktivitet);



        if (getIntent().hasExtra("rnd")){
            rndObj = (tilfeldigTall) getIntent().getSerializableExtra("rnd");
        }else if(getIntent().hasExtra("rnd2")) {
            rndObj2 = (TilfeldigTrekkerMaxEinGang) getIntent().getSerializableExtra("rnd2");
        }
        else {
            rndObj3 = (TlfTallMaxEinGangStoreTall) getIntent().getSerializableExtra("rnd3");
        }

        Button knapp = (Button) findViewById(R.id.TrekkeKnapp);
        knapp.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                TextView output = (TextView) findViewById(R.id.outputTekst);
                TextView outputListe = (TextView) findViewById(R.id.textListeID);

                if (getIntent().hasExtra("rnd")){
                    int tilfeldig = rndObj.trekkTall();
                    String s = rndObj.getListe();

                    output.setText(tilfeldig + "");
                    outputListe.setText(s);
                }
                if (getIntent().hasExtra("rnd2")){


                    if(rndObj2.hasTall()){

                        int tilfeldig = rndObj2.trekkTall();
                        String s = rndObj2.getListe();

                        output.setText(tilfeldig + "");
                        outputListe.setText(s);


                    }
                    else {
                        output.setText("Tomt for tall");
                    }

                }
                if (getIntent().hasExtra("rnd3")){
                    int tilfeldig = rndObj3.trekkTall();
                    String s = rndObj3.getListe();

                    output.setText(tilfeldig + "");
                    outputListe.setText(s);

                }



            }
        });


    }


}
