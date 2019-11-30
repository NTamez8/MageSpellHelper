package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;

public class FinalCalulations extends AppCompatActivity {
    Integer Dice;
    Integer reach;
    Integer Mana = 0;
    Integer paradox;
    Integer minParadox = 0;
    int StaticMinParadox;
    int MaxParadox;
    Integer time = 1;
    int TimeMultiple = 1;
    String RitualTime = "";
    int MinTimeMult= 1;
    String OrinialRituaTime = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_calulations);
        // set the dice
        Dice = SpellData.getInstance().getDice();
        UpdateDice();
        // set the reach
        reach = SpellData.getInstance().getReach();
        UpdateReach();
        // set paradox dice
        minParadox = ( (SpellData.getInstance().getArcanumLevel() - SpellData.getInstance().getSpellLevel() + 1) - reach ) * GnosisData.GetParadox(SpellData.getInstance().getGnosis()) * -1;

        if(minParadox >= 0)
        paradox = minParadox;
        else
        {
            minParadox = 0;
            paradox = 0;
        }
        StaticMinParadox = minParadox;
        MaxParadox = StaticMinParadox;
        UpdateParadox();
        if(SpellData.getInstance().getReachSpent(0))
        time = SpellData.getInstance().getCastTime();
        else
            RitualTime = SpellData.getInstance().getRitualTime();
        if(SpellData.getInstance().GetCastingMethod().equals("Grimoire"))
        {
            TimeMultiple++;
            MinTimeMult++;
            UpdateTime();
        }
        OrinialRituaTime = RitualTime;
        UpdateTime();
        Button button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().setReach(reach);
                SpellData.getInstance().setDice(Dice);
                SpellData.getInstance().setParadox(paradox);
                SpellData.getInstance().setCastTime(time);
                SpellData.getInstance().setRitualTime(RitualTime);
                SpellData.getInstance().setMana(Mana);
                Intent intent = new Intent(getApplicationContext(),Finished.class);
                startActivity(intent);
            }
        });
    }

    void UpdateDice()
    {
        TextView dice = (TextView)findViewById(R.id.totaldice);
        dice.setText(Dice.toString());

    }
    void UpdateReach()
    {
        TextView temp = (TextView)findViewById(R.id.SReach);
        temp.setText(reach.toString());

    }
    void UpdateParadox()
    {
        TextView Par = (TextView)findViewById(R.id.Paradox);
        Par.setText(paradox.toString());
    }
    void UpdateMana()
    {
        TextView mana = (TextView)findViewById(R.id.ManaSpent);
        mana.setText(Mana.toString());
    }
    void UpdateTime()
    {
        String temp = " Turns";
        TextView t = (TextView)findViewById(R.id.TurnsCalc);
        if(SpellData.getInstance().getReachSpent(0))
        {
            if(time == 1)
                temp = " Turn";
            t.setText(time.toString() + temp);
        }
        else
        {
            /*
            temp = RitualTime.replaceAll("\\D+","");
            Integer  number = Integer.parseInt(temp);
          Integer Result = number * TimeMultiple;
          temp = RitualTime.replaceAll(number.toString(),Result.toString());
          RitualTime = temp;
          t.setText(temp);*/
            temp = OrinialRituaTime.replaceAll("\\D+","");
            Integer  number = Integer.parseInt(temp);
            Integer Result = number * TimeMultiple;
            temp = OrinialRituaTime.replaceAll(number.toString(),Result.toString());
            RitualTime = temp;
            t.setText(temp);
        }

    }
    public void CalculationButtons(View view)
    {
        switch (view.getId())
        {
            case R.id.IncreaseManaSpent:
            {
                Mana++;
                UpdateMana();
                if(GnosisData.GetManaPerTurn(SpellData.getInstance().getGnosis()) < Mana)
                {
                    time++;
                    UpdateTime();
                }
            }
            break;
            case R.id.DecreaseManaSpent:
            {
                if(Mana > 0)
                    Mana--;
                UpdateMana();
                if(GnosisData.GetManaPerTurn(SpellData.getInstance().getGnosis()) <= Mana)
                {
                    time--;
                    UpdateTime();
                }
            }
            break;
            case R.id.CustParUp:
            {
                paradox++;
                MaxParadox++;
                UpdateParadox();
            }
            break;
            case R.id.CustParDown:
            {
                if(paradox > minParadox)
                {
                    paradox--;
                    MaxParadox--;
                }
                UpdateParadox();
            }
            break;
            case R.id.IncreaseRitualInterval:// update the time
            {
                    if(SpellData.getInstance().getReachSpent(0) || TimeMultiple > 5)
                        break;
                    TimeMultiple++;
                    Dice++;
                    UpdateDice();
                    UpdateTime();
            }
            break;
            case R.id.DecreaseRitualInterval:
            {
                if(SpellData.getInstance().getReachSpent(0))
                    break;
                if(TimeMultiple > MinTimeMult) {
                    TimeMultiple--;
                    Dice--;
                    UpdateDice();
                }
                UpdateTime();
            }
            break;
            case R.id.IncreasePar:
            {
                if(minParadox != StaticMinParadox)
                minParadox++;
                if(paradox != MaxParadox)
                    paradox++;
                else
                    break;


                Mana--;
                if(GnosisData.GetManaPerTurn(SpellData.getInstance().getGnosis()) <= Mana)
                {
                    time--;
                    UpdateTime();
                }
                UpdateParadox();
                UpdateMana();

            }
            break;
            case R.id.DecreasePar:
            {
                    if(minParadox != 0)
                    minParadox--;
                    if(paradox != 0)
                        paradox--;
                    else
                        break;

                    Mana++;
                if(GnosisData.GetManaPerTurn(SpellData.getInstance().getGnosis()) < Mana)
                {
                    time++;
                    UpdateTime();
                }
                UpdateParadox();
                UpdateMana();


            }
            break;
            case R.id.SpendReach:
            {
                reach++;
                UpdateReach();
            }
            break;
            case R.id.UnSpendReach:
            {
                if(reach > 0)
                {
                    reach--;
                    UpdateReach();
                }
            }
            break;
        }

    }

}
