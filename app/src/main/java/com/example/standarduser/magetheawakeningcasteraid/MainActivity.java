package com.example.standarduser.magetheawakeningcasteraid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Spinner;
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
                assignSpellFactors();
                SpellData.getInstance().setRitualTime(GnosisData.GetRitualInterval(SpellData.getInstance().getGnosis()));
                Intent startintent = new Intent(getApplicationContext(), AssignReach.class);
                startActivity(startintent);
            }
        });
    }

    private void assignSpellFactors()
    {
        Spinner ArcanumSpinner = findViewById(R.id.ArcanumLevelSpinner);
        Spinner LevelSpinner,GnosisSpinner;
        String arcanumString = ArcanumSpinner.getSelectedItem().toString();
        String gnosisString,spellLevelString;
        SpellData.getInstance().setArcanumLevelet(Integer.parseInt(arcanumString));

        GnosisSpinner = findViewById(R.id.GnosisSpinner);
        gnosisString = GnosisSpinner.getSelectedItem().toString();
        LevelSpinner = findViewById(R.id.SpellLevelSpinner);
        spellLevelString = LevelSpinner.getSelectedItem().toString();
        SpellData.getInstance().setSpellLevel(Integer.parseInt(spellLevelString));
        SpellData.getInstance().setGnosis(Integer.parseInt(gnosisString));



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

    public void IsRuling(View view)
    {
        boolean checked = ((ToggleButton) view).isChecked();
        if(checked)
            SpellData.getInstance().SetIsRuling(true);
        else
            SpellData.getInstance().SetIsRuling(false);


    }


}

