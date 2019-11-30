package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpellFactors extends Activity {//notes fix the start so that if useing advanced scale it works the size messes up
    Integer Dice =0;
    Integer potency = 1;
    Integer potencyPrimary = 0;
    Integer scale = 1;
    Integer scalePrimary = 0;
    Integer duration = 1;
    Integer durationPrimary = 0;
    String area = "";
    String Used[];
    String ScaleUsed[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_factors);
        String sDuration[] = {"1 turn","2 turns", "3 turns","5 turns","10 turns"};
        String aDuration[] = {"One hour","One Day","One Week","One Month","One Year","Indefinite"};
        String sScale[] = {"Arm's Reach","Small Room","Large Room","Several Rooms","Small House"};
        String aScale[] = {"Large House","Small Warehouse","Large Warehouse","Small Factory","Large Factory","Campus"};
        Dice = SpellData.getInstance().getGnosis() + SpellData.getInstance().getArcanumLevel();
        TextView DicePool = (TextView)findViewById(R.id.DicePool);
        DicePool.setText(Dice.toString());
        Integer FreePoints = SpellData.getInstance().getArcanumLevel() - 1;
       // TextView freePoints = (TextView)findViewById(R.id.FreePoints);
        //freePoints.setText(FreePoints.toString());
        if(SpellData.getInstance().getReachSpent(4))
        {
            Used = aDuration.clone();
            TextView p_view = (TextView)findViewById(R.id.DurationTime);
            p_view.setText(Used[0]);
        }
        else
            Used = sDuration.clone();
        if(SpellData.getInstance().getReachSpent(2))
        {
            ScaleUsed = aScale.clone();
        }
        else
            ScaleUsed = sScale.clone();
        area = ScaleUsed[0];
        String pSpellFactor = SpellData.getInstance().getPrimarySpellFactor();
        switch(pSpellFactor)
        {
            case"Potency":
                potencyPrimary = FreePoints;
            potency += potencyPrimary;
            SpellData.getInstance().setPotency(potency);
            UpdatePotency(0);
            break;
            case "Duration":
                durationPrimary = FreePoints;
                duration += durationPrimary;
                SpellData.getInstance().setDuration(duration);
                UpdateDuration(0);
                break;
            case "Scale":
                scalePrimary = FreePoints;
                scale += scalePrimary;
                SpellData.getInstance().setDuration(scale);
                UpdateScale(0);
                break;


        }


       // potency = potencyPrimary;
       // UpdatePotency(0);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().setDice(Dice);
                SpellData.getInstance().setArea(area);
                Intent intent = new Intent(getApplicationContext(),Yantra.class);
                startActivity(intent);
            }
        });
    }
    public void ButtonClick(View view)
    {
        switch (view.getId())
        {
            case R.id.IncreasePotency:
            {
                if(potency > potencyPrimary)// if potency is primary factor then it only counts if above the minimum
                {
                    Dice -= 2;
                    SetDiceSpent(Dice);
                }

                potency++;
                SpellData.getInstance().setPotency(potency);
                if(potencyPrimary > 0)
                UpdatePotency((potency - potencyPrimary - 1) * -2 );
                else
                    UpdatePotency((potency -1) * -2);
            }
                break;
            case R.id.IncreaseScale:
            {
                if(scale > scalePrimary)
                {
                    Dice -= 2;
                    SetDiceSpent(Dice);
                }

                scale++;
                SpellData.getInstance().setScale(scale);
                if(scalePrimary > 0)
                UpdateScale((scale - scalePrimary - 1) * -2 );
                else
                    UpdateScale((scale -1) * -2);
            }
                break;
            case R.id.IncreaseDuration:
            {
                if(duration > durationPrimary)
                {
                    Dice -= 2;
                    SetDiceSpent(Dice);
                }

                duration++;
                SpellData.getInstance().setDuration(duration);
                if(durationPrimary > 0)
                UpdateDuration((duration - durationPrimary - 1) * -2 );
                else
                    UpdateDuration((duration - 1) * -2);
            }
                break;
            case R.id.DecreasePotency:
            {
                if(potency > 1)
                {
                    if(potency > potencyPrimary + 1)
                    {
                        Dice += 2;
                        SetDiceSpent(Dice);
                    }
                    if(potency != 1)
                    potency--;
                    SpellData.getInstance().setPotency(potency);
                    UpdatePotency((potency -1 - potencyPrimary) * -2 );
                }

            }
                break;
            case R.id.DecreaseScale:
            {
                if(scale > 1)
                {
                    if(scale > scalePrimary + 1)
                    {
                        Dice += 2;
                        SetDiceSpent(Dice);
                    }

                    if(scale != 1)
                    scale--;
                    SpellData.getInstance().setScale(scale);
                    UpdateScale((scale -1 - scalePrimary) * -2 );
                }

            }
                break;
            case R.id.DecreaseDuration:
            {
                if(duration > 1)
                {
                    if(duration > durationPrimary + 1)
                    {
                        Dice += 2;
                        SetDiceSpent(Dice);
                    }

                    if(duration != 1)
                    duration--;
                    SpellData.getInstance().setDuration(duration);
                    UpdateDuration((duration -1 - durationPrimary) * -2 );
                }

            }
                break;
        }
    }
    void SetDiceSpent(Integer x)
    {
        TextView DicePool = (TextView)findViewById(R.id.DicePool);
        DicePool.setText(x.toString());

    }
    void UpdatePotency(Integer penalty)
    {

        if(penalty > 0)
            penalty = 0;


        TextView p_view = (TextView)findViewById(R.id.Potency);
        TextView p_penalty = (TextView)findViewById(R.id.PotencyDicePenalty);
        p_view.setText(potency.toString());
        p_penalty.setText(penalty.toString());
    }
    void UpdateScale(Integer scaleP)
    {
        Integer tempScale = scale;
        if(scaleP > 0)
            scaleP = 0;
        TextView p_view = (TextView)findViewById(R.id.ScaleTargets);
        TextView p_penalty = (TextView)findViewById(R.id.ScaleDicePenalty);
        TextView p_Size = findViewById(R.id.ScaleSize);
        TextView p_Area = findViewById(R.id.ScaleArea);
        p_penalty.setText(scaleP.toString());
            Integer scaleSize = 5;
            Double UpdateScale = 2.0;
            UpdateScale = Math.pow(UpdateScale, (scale - 1));
            if(SpellData.getInstance().getReachSpent(2))
            {

                UpdateScale = UpdateScale * 5;
                scaleSize = scaleSize * scaleP;
                if(scale > 6)
                    tempScale = 6;

            }
            else
            {

                scaleSize = scaleSize + (scaleP -1);
                if(scale > 5)
                    tempScale = 5;
            }
            p_view.setText(UpdateScale.toString());

            p_Size.setText(scaleSize.toString());
            p_Area.setText(ScaleUsed[tempScale]);
            area = ScaleUsed[tempScale];
    }
    void UpdateDuration(Integer durationP)
    {
        if(durationP > 0)
            durationP = 0;
        TextView p_view = (TextView)findViewById(R.id.DurationTime);
        TextView p_penalty = (TextView)findViewById(R.id.DurationDicePenalty);

       // p_view.setText(duration.toString());
        if(duration <= 5)
        p_view.setText(Used[duration -1]);
        else if(duration == 6 && SpellData.getInstance().getReachSpent(4) )
            p_view.setText(Used[5]);
        else if(duration > 5 && !SpellData.getInstance().getReachSpent(4))
        {
            Integer temp = 10;
            temp = temp * ( duration -4);
            String output = temp + " turns";
            p_view.setText(output);
        }
        p_penalty.setText(durationP.toString());


    }

}
