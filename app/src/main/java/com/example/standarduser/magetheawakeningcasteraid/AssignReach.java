package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class AssignReach extends AppCompatActivity {
        Integer ReachSpent = 0;
        String StartPrimary = "";
        String CurrentPrimary = "";
        boolean HasChanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_reach);
        TextView TV = (TextView)findViewById(R.id.FreeReach);
        Integer holdReach;
        if(!SpellData.getInstance().GetCastingMethod().equals("Rote"))
         holdReach = SpellData.getInstance().getArcanumLevel() - SpellData.getInstance().getSpellLevel() + 1;
        else
            holdReach = 6 - SpellData.getInstance().getSpellLevel();
        TV.setText(holdReach.toString());
        StartPrimary = SpellData.getInstance().getPrimarySpellFactor();
        CurrentPrimary = StartPrimary;
        Button button = (Button)findViewById(R.id.proceed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().setReach(ReachSpent);
                Intent intent = new Intent(getApplicationContext(),SpellFactors.class);
                startActivity(intent);
            }
        });
    }
    public void OnToggleClick(View view)
    {
        boolean checked = ((ToggleButton) view).isChecked();
        if(checked)
            ReachSpent++;
        else
            ReachSpent--;
        switch (view.getId())
        {
            case R.id.time:
                if(!SpellData.getInstance().GetCastingMethod().equals("Grimoire"))
                {
                    if(checked) {
                        SpellData.getInstance().setReachSpent(0, true);
                    }
                    else
                        SpellData.getInstance().setReachSpent(0,false);
                }

                break;
            case R.id.potency:
                if(checked)
                    SpellData.getInstance().setReachSpent(1,true);
                else
                    SpellData.getInstance().setReachSpent(1,false);
                break;
            case R.id.scale:
                if(checked)
                    SpellData.getInstance().setReachSpent(2,true);
                else
                    SpellData.getInstance().setReachSpent(2,false);
                break;
            case R.id.range:
                if(checked)
                    SpellData.getInstance().setReachSpent(3,true);
                else
                    SpellData.getInstance().setReachSpent(3,false);
                break;
            case R.id.duraction:
                if(checked)
                    SpellData.getInstance().setReachSpent(4,true);
                else
                    SpellData.getInstance().setReachSpent(4,false);
                break;


        }
        UpdateSpentReach();

    }
    public  void UpdateSpentReach()
    {
        TextView spent = (TextView)findViewById(R.id.ReachSpent);
        spent.setText(ReachSpent.toString());

    }
    public void ChangePrimary(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.ChangedPotency:
                if(checked)
                {
                    CurrentPrimary = "Potency";
                    if(StartPrimary.equals(CurrentPrimary) ) {
                        ReachSpent--;
                        HasChanged = false;
                        break;
                    }
                        if(!HasChanged)
                        {
                            HasChanged = true;
                            ReachSpent++;
                            UpdateSpentReach();
                        }


                }
                break;
            case R.id.ChangedDuration:
                if(checked)
                {
                    CurrentPrimary = "Duration";
                    if(StartPrimary.equals(CurrentPrimary) ) {
                        ReachSpent--;
                        HasChanged = false;
                        break;
                    }

                    if(!HasChanged)
                    {
                        HasChanged = true;
                        ReachSpent++;
                        UpdateSpentReach();
                    }


                }
                break;
            case R.id.ChangeScale:
                if(checked)
                {
                    CurrentPrimary = "Scale";
                    if(StartPrimary.equals(CurrentPrimary) ) {
                        ReachSpent--;
                        HasChanged = false;
                        break;
                    }

                    if(!HasChanged)
                    {
                        HasChanged = true;
                        ReachSpent++;
                        UpdateSpentReach();
                    }


                }
                break;

        }


    }
}
