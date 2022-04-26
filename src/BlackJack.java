import java.util.Scanner;

public class BlackJack {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private boolean gameOver;

    BlackJack() {
        // Create a new deck
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

    void printResult() {
        if (playerHand.getValue() == -1) {
            System.out.println("Player busted!");
        } else if (dealerHand.getValue() == -1) {
            System.out.println("Dealer busted!");
        } else if (playerHand.getValue() > dealerHand.getValue()) {
            System.out.println("Player wins!");
        } else if (playerHand.getValue() < dealerHand.getValue()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Tie!");
        }
        dealerHand.showOneCard();
        printTable();
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        while (!game.checkAndSetGameOver()) {
            game.printTable();
            System.out.println("Hit or stand?");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (command.equals("hit")) {
                game.hit();
            } else if (command.equals("stand")) {
                game.stand();
            } else {
                System.out.println("Invalid input!");
            }
        }
        game.printResult();
    }
}
