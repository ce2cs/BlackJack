import java.util.concurrent.TransferQueue;

public class Card {

    

    private int suit;

    private int rank;

    private boolean faceUp;

   

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

   

    public void setName(int rank)

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
}
