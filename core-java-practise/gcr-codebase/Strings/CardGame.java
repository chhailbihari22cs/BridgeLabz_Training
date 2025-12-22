import java.util.*;

public class CardGame {

    // Initialize the deck
    static String[] initDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace" };
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int k = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[k++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck
    static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute n cards among x players
    static String[][] distribute(String[] deck, int n, int x) {
        if (n % x != 0) {
            System.out.println("Cards cannot be evenly distributed!");
            return new String[0][0];
        }
        int cardsPerPlayer = n / x;
        String[][] players = new String[x][cardsPerPlayer];
        int k = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[k++];
            }
        }
        return players;
    }

    // Print players and their cards
    static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j] + (j == players[i].length - 1 ? "" : ", "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize and shuffle deck
        String[] deck = initDeck();
        shuffleDeck(deck);

        // User input
        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();

        // Distribute and print
        String[][] players = distribute(deck, n, x);
        if (players.length > 0) {
            printPlayers(players);
        }
    }
}
