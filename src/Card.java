import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card {

    

    private int suit;

    private int rank;

    private boolean faceUp;

    static String[] rankToPattern = {"#", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    static char[] suitToPattern = {'#', '♣', '♦', '♥', '♠'};

    public Card(int suit, int rank)

    {

          this.suit = suit;

          this.rank= rank;

          this.faceUp = true;

    }

   

    public void setSuit(int suit)

    {

          this.suit = suit;

    }

   

    public void setRank(int rank)

    {

          this.rank = rank;

    }

   

    public int getSuit()

    {

          return suit;

    }

   

    public int getRank()

    {

          return rank;

    }

   

    public String toString()

    {
          if (!getFaceUp()) {
              return "Hidden Card";
          }
          String str="";

          if(rank >=2 && rank <=10)

                 str += rank ;

          else if(rank == 1)

                 str = "Ace";

          else if(rank == 11)

                 str = "Jack";

          else if(rank == 12)

                 str = "Queen";

          else

                 str = "King";

          str += " of ";

         

          if(suit == 1)

                 str += "Clubs";

          else if(suit == 2)

                 str += "Diamonds";

          else if(suit == 3)

                 str += "Hearts";

          else

                 str += "Spades";

         

          return str;

    }

    public boolean getFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public ArrayList<String> drawCard() {
        ArrayList<String> pattern = new ArrayList<>();
        String rankPattern;
        char suitPattern;
        if (getFaceUp()) {
            rankPattern = rankToPattern[getRank()];
            suitPattern = suitToPattern[getSuit()];
        } else {
            rankPattern = rankToPattern[0];
            suitPattern = suitToPattern[0];
        }
        if (rankPattern.length() == 1) {
            pattern.add("┌-------┐");
            pattern.add("│ " + rankPattern + "     │");
            pattern.add("│   " + suitPattern + "   │");
            pattern.add("│     " + rankPattern + " │");
            pattern.add("└-------┘");
        } else {
            pattern.add("┌-------┐");
            pattern.add("│ " + rankPattern + "    │");
            pattern.add("│   " + suitPattern + "   │");
            pattern.add("│    " + rankPattern + " │");
            pattern.add("└-------┘");
        }
        return pattern;
    }
}
