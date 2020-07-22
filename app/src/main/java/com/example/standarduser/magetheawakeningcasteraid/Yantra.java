package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Yantra extends AppCompatActivity {// note fix this so that if casting time is ritual then any number of yantras can be used
    Integer Dice = 0;
    //String Time = "1 Turn";
    Integer time = 1;
    Integer mudravalue = 0;
    Integer patronvalue = 0;
    Integer sympathvalue = 0;
    Integer sacramentvalue = 0;
    Integer personavalue = 0;
    boolean UsedFirstYantra = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yantra);
        Dice = SpellData.getInstance().getDice();
        UpdateDice();
        UpdateTurn();

        Button button = (Button)findViewById(R.id.Proceed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().setDice(Dice);
                SpellData.getInstance().setCastTime(time);
                Intent intent = new Intent(getApplicationContext(),FinalCalulations.class);
                startActivity(intent);
            }
        });
    }
    public void OnToggleClickYantra(View view)// note finish assigning these so that they increase and decrease dice and time when selected
    {
        boolean checked = ((ToggleButton) view).isChecked();



        switch (view.getId())
        {
            case R.id.DemesneToggleButton:
            case R.id.VergeToggleButton:
            case R.id.ConcentrationToggleButton:
            case R.id.RunesToggleButton:
                if(checked)
                {
                    Dice += 2;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;

                    }

                }
                else
                {
                    Dice -= 2;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;

            case R.id.EnvironmentToggleButton:
            case R.id.PathToggleButton:
            case R.id.OrderToggleButton:
                if(checked)
                {
                    Dice += 1;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else
                {
                    Dice -= 1;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;
            case R.id.MantraToggleButton:
                if(checked)
                {
                    Dice += 2;
                    if(SpellData.getInstance().getReachSpent(0))
                        time++;
                }
                else
                {
                    Dice -= 2;
                    if(SpellData.getInstance().getReachSpent(0))
                        time--;

                }
                break;
            case R.id.PatronToggleButton:
                if(checked)
                {
                    Dice += patronvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else
                {
                    Dice -= patronvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;
            case R.id.SympathyToggleButton:
                if(checked)
                {
                    Dice += sympathvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else
                {
                    Dice -= sympathvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;
            case R.id.SacramentToggleButton:
                if(checked)
                {
                    Dice += sacramentvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else
                {
                    Dice -= sacramentvalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;
            case R.id.PersonaToggleButton:
                if(checked)
                {
                    Dice += personavalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else
                {
                    Dice -= personavalue;
                    if(SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;
            case R.id.MudraToggleButton:
                if(checked && SpellData.getInstance().GetCastingMethod().equals("Rote"))
                {
                    Dice += mudravalue;
                    if(!SpellData.getInstance().getReachSpent(0))
                    {
                        if(!UsedFirstYantra)
                            UsedFirstYantra = true;
                        else
                            time++;
                    }

                }
                else if(SpellData.getInstance().GetCastingMethod().equals("Rote"))
                {
                    Dice -= mudravalue;
                    if(!SpellData.getInstance().getReachSpent(0))
                    {
                        if(UsedFirstYantra && time == 1) {
                            UsedFirstYantra = false;
                        }
                        else
                            time--;
                    }


                }
                break;

        }
        UpdateDice();
        UpdateTurn();

    }
    void UpdateTurn()
    {
        TextView turn = (TextView)findViewById(R.id.Turns);
        if(SpellData.getInstance().getReachSpent(0)) {

            if(time > 1)
                turn.setText(time.toString() + " Turns");
            else
                turn.setText(time.toString() + " Turn");

        }
        else {

            turn.setText(SpellData.getInstance().getRitualTime());

        }


    }
    void UpdateDice()
    {
        TextView dice = (TextView)findViewById(R.id.TotalDice);
        dice.setText(Dice.toString());
    }
    public void ChangeDiceBonus(View view)
    {

        switch (view.getId())
        {
            case R.id.MudraUpButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.MudraToggleButton);
                if(tb.isChecked())
                    break;
                mudravalue++;
                TextView tv = (TextView)findViewById(R.id.MudraValue);
                tv.setText(mudravalue.toString());

            }
                break;
            case R.id.MudraDownButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.MudraToggleButton);
                if(tb.isChecked())
                    break;
                mudravalue--;
                TextView tv = (TextView)findViewById(R.id.MudraValue);
                tv.setText(mudravalue.toString());

            }
                break;
            case R.id.PatronUpButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.PatronToggleButton);
                if(tb.isChecked())
                    break;
                patronvalue++;
                TextView tv = (TextView)findViewById(R.id.PatronValue);
                tv.setText(patronvalue.toString());

            }
                break;
            case R.id.SympathyUpButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.SympathyToggleButton);
                if(tb.isChecked())
                    break;
                sympathvalue++;
                TextView tv = (TextView)findViewById(R.id.SympathyValue);
                tv.setText(sympathvalue.toString());

            }
                break;
            case R.id.SacramentUpBotton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.SacramentToggleButton);
                if(tb.isChecked())
                    break;
                sacramentvalue++;
                TextView tv = (TextView)findViewById(R.id.SacramentValue);
                tv.setText(sacramentvalue.toString());

            }
                break;
            case R.id.PersonaUpButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.PersonaToggleButton);
                if(tb.isChecked())
                    break;
                personavalue++;
                TextView tv = (TextView)findViewById(R.id.PersonaValue);
                tv.setText(personavalue.toString());

            }
                break;

            case R.id.PatronDownButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.PatronToggleButton);
                if(tb.isChecked())
                    break;
                patronvalue--;
                TextView tv = (TextView)findViewById(R.id.PatronValue);
                tv.setText(patronvalue.toString());

            }
                break;
            case R.id.SympathyDownButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.SympathyToggleButton);
                if(tb.isChecked())
                    break;
                sympathvalue--;
                TextView tv = (TextView)findViewById(R.id.SympathyValue);
                tv.setText(sympathvalue.toString());

            }
                break;
            case R.id.SacramentDownBotton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.SacramentToggleButton);
                if(tb.isChecked())
                    break;
                sacramentvalue--;
                TextView tv = (TextView)findViewById(R.id.SacramentValue);
                tv.setText(sacramentvalue.toString());

            }
                break;
            case R.id.PersonaDownButton:
            {
                ToggleButton tb = (ToggleButton)findViewById(R.id.PersonaToggleButton);
                if(tb.isChecked())
                    break;
                personavalue--;
                TextView tv = (TextView)findViewById(R.id.PersonaValue);
                tv.setText(personavalue.toString());

            }
                break;
        }

    }
}
