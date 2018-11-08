package com.example.atoft.trekkeprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final tilfeldigTall rndObj = new tilfeldigTall();

        final TextView feilmelding = (TextView) findViewById(R.id.FeilID);
        feilmelding.setText("");


        Button knapp = (Button) findViewById(R.id.knapp);
        knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Switch bryter = (Switch) findViewById(R.id.switchID);


                EditText nedre = (EditText) findViewById(R.id.nedre);
                EditText ovre = (EditText) findViewById(R.id.ovre);
                TextView feilmelding = (TextView) findViewById(R.id.FeilID);


                String nedreTekst = nedre.getText().toString();
                String ovreTekst = ovre.getText().toString();



                if ( !(nedreTekst.matches("")) && !(ovreTekst.matches( ""))) {
                    if (nedreTekst.length() > 9 || ovreTekst.length() > 9){
                        feilmelding.setText("Tallet kan maksimalt være 9 siffer");
                    }
                    else{

                        int nedreTall = Integer.parseInt(nedre.getText().toString());
                        int ovreTall = Integer.parseInt(ovre.getText().toString());


                        if (nedreTall >= ovreTall){
                            feilmelding.setText("Nedre grense må være mindre enn øvre grense");

                        }
                        else{

                            if(!(bryter.isChecked())){
                                tilfeldigTall rndObj = new tilfeldigTall();
                                rndObj.setTall(nedreTall, ovreTall);
                                Intent begynntIntent = new Intent(getApplicationContext(), TrekkeAktivitet.class);
                                begynntIntent.putExtra("rnd", rndObj);
                                startActivity(begynntIntent);
                            }
                            else if(ovreTall- nedreTall < 10000){

                                TilfeldigTrekkerMaxEinGang rndObj2 = new TilfeldigTrekkerMaxEinGang(nedreTall, ovreTall);

                                Intent begynntIntent = new Intent(getApplicationContext(), TrekkeAktivitet.class);
                                begynntIntent.putExtra("rnd2", rndObj2);
                                startActivity(begynntIntent);
                            }
                            else{
                                TlfTallMaxEinGangStoreTall rndObj3 = new TlfTallMaxEinGangStoreTall(nedreTall, ovreTall);

                                Intent begynntIntent = new Intent(getApplicationContext(), TrekkeAktivitet.class);
                                begynntIntent.putExtra("rnd3", rndObj3);
                                startActivity(begynntIntent);
                            }

                        }

                    }


                }



            }


        });



    }
}
