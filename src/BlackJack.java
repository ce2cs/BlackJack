import java.util.Scanner;

public class BlackJack {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private boolean gameOver;
    private int wins;
    private int totalGames;
    private String winner;

    BlackJack() {
        // Create a new deck
        wins = 0;
        totalGames = 0;
        reset();
    }

    void reset() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        // Shuffle the deck
        deck.sort();
        deck.shuffle();

        // Deal two cards to the dealer
        dealerHand.addCard(deck.removeCard());
        dealerHand.addCard(deck.removeCard());
        dealerHand.hideOneCard();
        // Deal two cards to the player
        playerHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());
        setGameOver(false);
        totalGames++;
        System.out.println("Game " + totalGames + ":");
    }

    void hit() {
        playerHand.addCard(deck.removeCard());
    }

    void stand() {
        // Dealer's turn
        if (dealerHand.getValue() == -1) {
            setGameOver(true);
            return;
        }
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.removeCard());
            if (dealerHand.getValue() == -1) {
                break;
            }
        }
        setGameOver(true);
    }

    boolean checkAndSetGameOver() {
        if (gameOver) {
            return true;
        } if (playerHand.getValue() == 21 || dealerHand.getValue() == 21) {
            setGameOver(true);
            return true;
        } if (playerHand.getValue() == -1 || dealerHand.getValue() == -1) {
            setGameOver(true);
            return true;
        }
        return false;
    }

    void drawTable() {
        System.out.println("Dealer's hand:");
        System.out.print(dealerHand.drawDeck());
        if (gameOver) {
            if (dealerHand.getValue() == -1) {
                System.out.println("Dealer's hand value: BUSTED");
            } else {
                System.out.println("Dealer's hand value: " + dealerHand.getValue());
            }
        }
        System.out.println("Player's hand:");
        System.out.print(playerHand.drawDeck());
        if (playerHand.getValue() == -1) {
            System.out.println("Player's hand value: BUSTED");
        } else {
            System.out.println("Player's hand value: " + playerHand.getValue());
        }
    }

    void printTable() {
        System.out.println("Dealer's hand: " + dealerHand.toString());
        if (gameOver) {
            if (dealerHand.getValue() == -1) {
                System.out.println("Dealer's hand value: BUSTED");
            } else {
                System.out.println("Dealer's hand value: " + dealerHand.getValue());
            }
        }
        System.out.println("Player's hand: " + playerHand.toString());
        if (playerHand.getValue() == -1) {
            System.out.println("Player's hand value: BUSTED");
        } else {
            System.out.println("Player's hand value: " + playerHand.getValue());
        }
    }

    void evaluateWinner() {
        if (playerHand.getValue() == -1) {
            winner = "Dealer";
        } else if (dealerHand.getValue() == -1) {
            winner = "Player";
            wins++;
        } else if (playerHand.getValue() == 21) {
            winner = "Player";
            wins++;
        } else if (playerHand.getValue() > dealerHand.getValue()) {
            winner = "Player";
            wins++;
        } else if (playerHand.getValue() < dealerHand.getValue()) {
            winner = "Dealer";
        } else {
            winner = "Tie";
        }
    }

    void printResult() {
        dealerHand.showOneCard();
        drawTable();
        System.out.println("\nGame result: ");
        if (winner.equals("Tie")) {
            System.out.println("Tie!");
        } else {
            System.out.println(winner + " wins!");
        }
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        if (gameOver) {
            evaluateWinner();
        }
    }

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);
        String command;
        BlackJack game = new BlackJack();
        while (playAgain) {
            while (!game.checkAndSetGameOver()) {
                game.drawTable();
                System.out.println("[H]it or [S]tand?");
                command = input.nextLine();
                if (command.equals("H")) {
                    game.hit();
                } else if (command.equals("S")) {
                    game.stand();
                } else {
                    System.out.println("Invalid input!, please input H or S");
                }
            }
            game.printResult();
            while (true) {
                System.out.println("[E]xit or [R]eset the game?");
                command = input.nextLine();
                if (command.equals("E")) {
                    System.out.println("Good Bye!");
                    playAgain = false;
                    break;
                } else if (command.equals("R")) {
                    game.reset();
                    break;
                } else {
                    System.out.println("Invalid input!, please input E or R");
                }
            }
        }

        System.out.println("You won " + game.wins + " out of " + game.totalGames + " games!");
    }
}
