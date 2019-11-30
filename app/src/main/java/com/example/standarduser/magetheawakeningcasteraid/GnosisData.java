package com.example.standarduser.magetheawakeningcasteraid;

public final class GnosisData {
   private static Integer MaxArcanum[] = {3,3,4,4,5,5,5,5,5,5};
    private static   Integer ManaPerTurn[] = {1,2,3,4,5,6,7,8,10,15};
    private static   Integer Paradox[] = {1,1,2,2,3,3,4,4,5,5};
    private static   String RitualInterval[] = {"3 hours","1 hour"," 30 minutes","10 minutes","1 minute"};
  private GnosisData()
  {

  }
  public  static Integer GetMaxArcanume(int gnosis)
    {

        return  MaxArcanum[gnosis];
    }
  public static  Integer GetManaPerTurn(int gnosis)
    {
        return ManaPerTurn[gnosis];
    }
  public  static Integer GetParadox(int gnosis)
    {
        return Paradox[gnosis];
    }
  public  static String GetRitualInterval(int gnosis)
    {

        int value = (int)Math.ceil((double)gnosis/2.0) - 1;
        return RitualInterval[value];
    }
}
