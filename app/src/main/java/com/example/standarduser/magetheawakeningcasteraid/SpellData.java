package com.example.standarduser.magetheawakeningcasteraid;

public class SpellData {
    private static final SpellData spell = new SpellData();// keeps a static version of itself

    public static  SpellData getInstance(){return  spell;};// returns the static self
    private String CastingMethod ="Improvised";// this keeps what type of casting is being done
    public String GetCastingMethod(){return  CastingMethod;}// this returns the casting being done
    public void setCastingMethod(String castingMethod){this.CastingMethod = castingMethod;}// this sets the casting method

    // this deals with the gnosis
    private Integer gnosis = 1;
    public Integer getGnosis() {
        return gnosis;
    }
    public void setGnosis(Integer gnosis) {
        this.gnosis = gnosis;
    }


    // this deals with the arcanum level of the spell
    private Integer ArcanumLevel = 1;
    public Integer getArcanumLevel() {
        return ArcanumLevel;
    }
    public void setArcanumLevelet(Integer ArcanumLevel) {
        this.ArcanumLevel = ArcanumLevel;
    }

    // this deals with the spell level
    private Integer SpellLevel = 1;
    public Integer getSpellLevel() {
        return SpellLevel;
    }
    public void setSpellLevel(Integer spellLevel)
    {
        this.SpellLevel = spellLevel;
    }

    // this deals with how reach was spent for advanced values
  private  boolean ReachSpent[] = {false,false,false,false,false};// a bitmap for the spent reach.
    // 0 is casting time. 1 is potency. 2 is Scale. 3 is Range. 4 is duration
    public  void setReachSpent(int x , Boolean value)
    {
        ReachSpent[x] = value;
    }
    public boolean getReachSpent(int x ) {
        return ReachSpent[x];
    }

    // this is how much reach was spent
   private Integer reach = 0;
    public Integer getReach() {
        return reach;
    }
    public void setReach(int x)
    {
        reach = x;
    }

    // this deals with the spells potency
    private Integer potency = 1;
    public Integer getPotency() {
        return potency;
    }
    public void setPotency(Integer x)
    {
        potency = x;
    }

    // this deals with the spells scale
    private Integer scale = 1;
    public Integer getScale()
    {
        return scale;
    }
    public void setScale(Integer x)
    {
        scale = x;
    }

    // this is the area affected
    private String area = "Arms Reach";

    public String getArea() {
        return area;
    }
    public void setArea(String x)
    {
        area = x;
    }

    // this deals with the spells duration
    private Integer duration = 1;
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer x)
    {
        duration = x;
    }

    // this keeps the spell primary factor
    private String PrimarySpellFactor = "Potency";
    public String getPrimarySpellFactor() {
        return PrimarySpellFactor;
    }
    public void setPrimarySpellFactor(String x)
    {
        PrimarySpellFactor = x;
    }

    // this is the dice pool of the caster
    private Integer Dice = 2;
    public Integer getDice() {
        return Dice;
    }
    public void setDice(Integer x)
    {
        Dice = x;
    }

    // this is the time it takes to cast
    private Integer CastTime = 1;
    public Integer getCastTime() {
        return CastTime;
    }
    public void setCastTime(Integer x)
    {
        CastTime = x;
    }

    //ritual casting time
    private String ritualTime = "1 hour";
    public  String getRitualTime()
    {
        return ritualTime;
    }
    public void setRitualTime(String x)
    {
        ritualTime = x;
    }



    // this is how much Mana was spent
    private Integer Mana = 0;
    public Integer getMana() {
        return Mana;
    }
    public void setMana(Integer x)
    {
        Mana = x;
    }

    // this is the paradox dice pool
    private Integer paradox = 0;
    public Integer getParadox() {
        return paradox;
    }
    public  void setParadox(Integer x)
    {
        paradox  = x;
    }

    private boolean IsRuling = false;
     public boolean getIsRuling()
     {
         return IsRuling;
     }
     public void SetIsRuling(boolean x)
     {
         IsRuling = x;
     }
     public void Reset()
     {
         CastingMethod = "";
         gnosis  = 0;
         ArcanumLevel  = 0;
         SpellLevel = 0;
         for(int x = 0; x< 5 ; x++)
             ReachSpent[x] = false;
         reach = 0;
         potency = 0;
         scale = 0;
         area = "";
         duration = 0;
         PrimarySpellFactor = "";
         Dice = 0;
         CastTime = 0;
         ritualTime = "";
         Mana = 0;
         paradox = 0;
         IsRuling = false;
     }
}


