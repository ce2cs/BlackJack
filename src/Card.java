public class Card {

    

    private int suit;

    private int name;

   

    public Card(int suit, int name)

    {

          this.suit = suit;

          this.name= name;

    }

   

    public void setSuit(int suit)

    {

          this.suit = suit;

    }

   

    public void setName(int name)

    {

          this.name = name;

    }

   

    public int getSuit()

    {

          return suit;

    }

   

    public int getName()

    {

          return name;

    }

   

    public String toString()

    {

          String str="";

          if(name >=2 && name <=10)

                 str += name ;

          else if(name == 1)

                 str = "Ace";

          else if(name == 11)

                 str = "Jack";

          else if(name == 12)

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

}
