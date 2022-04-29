# BlackJack
Spring 2022 CS5004 group project  
Written by @Boyang Gao, @Baoyan Li

## Usage
1. clone the project `git clone https://github.com/ce2cs/BlackJack.git`
2. compile the source code
`javac -c bin src/*.java`
3. run the command
`java -cp bin BlackJack`

## Design
1. `class BlackJack`  
`BlackJack` is the main class of the game. It has a main method 
and which controls the flow of the game. 
2. `class Card`
3. `class Deck`
4. `class Hand`  
`Hand` is the class that stores the cards of the player and dealer.
`Hand` is inherited from `class Deck`. It has a method to evaluate the value
of the hand using backtrace.

## Libraries We Used
We only used java's built-in libraries
1. `java.util.ArrayList`
2. `java.util.Random`
3. `java.util.Scanner`




