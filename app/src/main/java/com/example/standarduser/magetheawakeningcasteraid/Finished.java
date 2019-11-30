package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finished extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        TextView duration = findViewById(R.id.FinalDuration);
        duration.setText(SpellData.getInstance().getDuration().toString() + " Turns");

        TextView range = findViewById(R.id.FinalRange);
        if(SpellData.getInstance().getReachSpent(3))
            range.setText("Sensory");
        else
            range.setText("Touch");
        TextView CastTime = findViewById(R.id.FinalCastTime);
        if(SpellData.getInstance().getReachSpent(0)) {
            String temp = SpellData.getInstance().getCastTime().toString() + " Turns";
            CastTime.setText(temp);
        }
        else
            CastTime.setText(SpellData.getInstance().getRitualTime());

        TextView dice = findViewById(R.id.FinalDice);
        dice.setText(SpellData.getInstance().getDice().toString());

        TextView ManaCost = findViewById(R.id.FinalManaCost);
        if(SpellData.getInstance().getIsRuling()|| SpellData.getInstance().GetCastingMethod().equals("Rote"))
        ManaCost.setText(SpellData.getInstance().getMana().toString());
        else
        {
            Integer temp = SpellData.getInstance().getMana() + 1;
            ManaCost.setText(temp.toString());
        }

        TextView paradox = findViewById(R.id.FinalParadox);
        paradox.setText(SpellData.getInstance().getParadox().toString());

        TextView size = findViewById(R.id.FinalMaxSize);
        size.setText(SpellData.getInstance().getScale().toString());

        TextView area = findViewById(R.id.FinalArea);
        area.setText(SpellData.getInstance().getArea());
        if(SpellData.getInstance().GetCastingMethod().equals("Praxis"))
        {
            TextView praxis = findViewById(R.id.Praxis);
            praxis.setText("You get a critical success on three successes intsead of five");
        }
        Button button = findViewById(R.id.StartNew);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().Reset();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
