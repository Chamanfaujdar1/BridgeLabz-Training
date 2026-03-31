import java.util.Scanner;

public class CardGame {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        int n = suits.length * ranks.length;
        String[] deck = new String[n];
        
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            // Generate a random card number between i and n
            int r = i + (int) (Math.random() * (n - i));
            
            // Swap current card with the random card
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards in the deck!");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int deckIndex = 0;

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[deckIndex++];
            }
        }
        return players;
    }

    public static void printPlayerCards(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " Hand:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  - " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Initialize and Shuffle
        String[] myDeck = initializeDeck();
        myDeck = shuffleDeck(myDeck);

        // 2. Get User Input
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int n = sc.nextInt();

        // 3. Distribute and Print
        String[][] playersHands = distributeCards(myDeck, x, n);
        printPlayerCards(playersHands);

        sc.close();
    }
}
