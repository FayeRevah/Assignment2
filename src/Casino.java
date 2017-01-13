import java.util.*;
import java.lang.Math;

public class Casino
{
   static int getBet(){
      int bet = -1;
      Scanner input = new Scanner(System.in);
      //comment
      while(bet < 0 || bet > 100){
         System.out.print("How much would you like to bet (1-100) or 0 to quit: ");
         bet = input.nextInt();
      }
      return bet;
   }
   
   //generates random string based on probabilities
   //50% chance of Bar
   //25% chance of cherries
   //12.5% chance each for 7 and space
   private static String randString(){
      double randBet = Math.random();
      System.out.println(randBet);
      if (randBet >= 0 && randBet < 0.5)
         return "Bar";
      else if(randBet >= 0.5 && randBet < 0.750)
         return "cherries";
      else if(randBet >= 0.750 && randBet < 0.875)
         return "7";
      return "space";
   }
   
   public static void main(String argsp[]){
      TripleString tsi = new TripleString();
      tsi.setString1("oh");
      tsi.setString2("my");
      tsi.setString3("Goodness");
      System.out.println(randString());
   }
}

class TripleString
{
   private String string1;
   private String string2;
   private String string3;
   
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   
   private static int pullWinnings[] = new int[MAX_PULLS];
   
   private static int numPulls = 0;
   
   public TripleString(){
      string1 = string2 = string3 = "";
   }
   
   public boolean validString(String str){
      if(str != null && str.length() <= MAX_LEN)
         return true;
      return false;
   }
   
   public boolean setString1(String str){
      if(validString(str)){
         string1 = str;
         return true;
      }
      return false; 
   }
   
   public boolean setString2(String str){
      if(validString(str)){
         string2 = str;
         return true;
      }
      return false; 
   }
   
   public boolean setString3(String str){
      if(validString(str)){
         string3 = str;
         return true;
      }
      return false; 
   }
   
   public String getString1(){
      return string1;
   }
   
   public String getString2(){
      return string2;
   }
   
   public String getString3(){
      return string3;
   }
   
   public String toString(){
      return string1 + " " + string2 + " " + string3;
   }
   
   public boolean saveWinnings(int winnings){
      if(numPulls <= MAX_PULLS){
         pullWinnings[numPulls - 1] = winnings;
         return true;
      }
      return false;
   }
   
   public String displayWinnings(){
      String winnings;
      int total = 0;
      for(int i = 0; i < numPulls; i++)
      {
         total += pullWinnings[i];
      }
      return "Winnings: " + total;
   }
   
}


