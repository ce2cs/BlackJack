# BlackJack
Spring 2022 CS5004 group project  
Written by @Boyang Gao, @Baoyan Li

## Usage
1. clone the project `git clone https://github.com/ce2cs/BlackJack.git`
2. change the directory to `cd BlackJack`
3. compile the source code `javac -d bin src/*.java`
4. run the command `java -cp bin BlackJack`

## Play Instruction
Basically you only need four keys to play the game:
1. H for hit
2. S for stand
3. E for exit
4. R for next round     

When it is your turn, you could decide to hit or stand.
![image](https://user-images.githubusercontent.com/69294919/166082302-87280745-a681-4953-8a2d-159a93412bf7.png)
When current round is over, you could decide to start a new round or exit the game.
![image](https://user-images.githubusercontent.com/69294919/166082370-063f06ce-48e5-4f83-9acc-55e7204931b4.png)

## Design
1. `class BlackJack`  
`BlackJack` is the main class of the game. It has a main method 
and which controls the flow of the game. 
2. `class Card`  
`Card` is the class that uses to define each card suit and rank, 
including the hidden card(also with value) for dealer. And we 
also made it how they look like when they are on a casino table.
3. `class Deck`  
 `Deck` is a class that stores an ArrayList of Card objects.
 `Deck` class have methods include Shuffle the cards in the deck, 
 add and remove card from deck, and sort card in deck orderd by name.
4. `class Hand`  
`Hand` is the class that stores the cards of the player and dealer.
`Hand` is inherited from `class Deck`. It has a method to evaluate the value
of the hand using backtrace.

The diagram below shows the relationship between the classes.

![image](https://user-images.githubusercontent.com/69294919/166082752-492d2ae7-de21-4b6e-ad0b-e62e385a68b5.png)

## Libraries We Used
We only used java's built-in libraries
1. `java.util.ArrayList`
2. `java.util.Random`
3. `java.util.Scanner`




