package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpellData.getInstance().setCastingMethod("Improvised");
        SpellData.getInstance().setSpellLevel(1);
        SpellData.getInstance().setArcanumLevelet(1);
        SpellData.getInstance().setPrimarySpellFactor("Potency");
        SpellData.getInstance().setGnosis(1);
        Button button = (Button) findViewById(R.id.ToPhaseTwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpellData.getInstance().setRitualTime(GnosisData.GetRitualInterval(SpellData.getInstance().getGnosis()));
                Intent startintent = new Intent(getApplicationContext(), AssignReach.class);
                startActivity(startintent);
            }
        });
    }
    public void onRadioButtonClickCasting(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.Improvised:
                if(checked)
                    SpellData.getInstance().setCastingMethod("Improvised");
                    break;
            case R.id.Rote:
                if(checked)
                    SpellData.getInstance().setCastingMethod("Rote");
                    break;
            case R.id.Grimoire:
                if(checked)
                    SpellData.getInstance().setCastingMethod("Grimoire");
                    break;
            case R.id.Praxis:
                if(checked)
                    SpellData.getInstance().setCastingMethod("Praxis");
                    break;

        }
    }
    public void onRadioButtonClickSpellLevel(View view)
    {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.SpellLevel1:
                if(checked)
                    SpellData.getInstance().setSpellLevel(1);
                break;
            case R.id.SpellLevel2:
                if(checked)
                    SpellData.getInstance().setSpellLevel(2);
                break;
            case R.id.SpellLevel3:
                if(checked)
                    SpellData.getInstance().setSpellLevel(3);
                break;
            case R.id.SpellLevel4:
                if(checked)
                    SpellData.getInstance().setSpellLevel(4);
                break;
            case R.id.SpellLevel5:
                if(checked)
                    SpellData.getInstance().setSpellLevel(5);
                break;
        }

    }
    public void onRadioButtonClickLevel(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.Arcanum1:
                if(checked)
                    SpellData.getInstance().setArcanumLevelet(1);
                    break;
            case R.id.Arcanum2:
                if(checked)
                    SpellData.getInstance().setArcanumLevelet(2);
                    break;
            case R.id.Arcanum3:
                if(checked)
                    SpellData.getInstance().setArcanumLevelet(3);
                    break;
            case R.id.Arcanum4:
                if(checked)
                    SpellData.getInstance().setArcanumLevelet(4);
                    break;
            case R.id.Arcanum5:
                if(checked)
                    SpellData.getInstance().setArcanumLevelet(5);
                    break;

        }
    }
    public void onRadioButtonClickPrimary(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.PotencyPrimary:
                if(checked)
                    SpellData.getInstance().setPrimarySpellFactor("Potency");
                break;
            case R.id.DurationPrimary:
                if(checked)
                    SpellData.getInstance().setPrimarySpellFactor("Duration");
                break;
        }




    }
    public void onRadioButtonClickGnosis(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.gnosis1:
                if(checked)
                    SpellData.getInstance().setGnosis(1);
                    break;
            case R.id.gnosis2:
                if(checked)
                    SpellData.getInstance().setGnosis(2);
                    break;
            case R.id.gnosis3:
                if(checked)
                    SpellData.getInstance().setGnosis(3);
                    break;
            case R.id.gnosis4:
                if(checked)
                    SpellData.getInstance().setGnosis(4);
                    break;
            case R.id.gnosis5:
                if(checked)
                    SpellData.getInstance().setGnosis(5);
                    break;
            case R.id.gnosis6:
                if(checked)
                    SpellData.getInstance().setGnosis(6);
                    break;
            case R.id.gnosis7:
                if(checked)
                    SpellData.getInstance().setGnosis(7);
                    break;
            case R.id.gnosis8:
                if(checked)
                    SpellData.getInstance().setGnosis(8);
                    break;
            case R.id.gnosis9:
                if(checked)
                    SpellData.getInstance().setGnosis(9);
                    break;
            case R.id.gnosis10:
                if(checked)
                    SpellData.getInstance().setGnosis(10);
                    break;

        }
    }
    public void IsRuling(View view)
    {
        boolean checked = ((ToggleButton) view).isChecked();
        if(checked)
            SpellData.getInstance().SetIsRuling(true);
        else
            SpellData.getInstance().SetIsRuling(false);


    }


}

