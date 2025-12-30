import java.util.Random;

public class SnakeAndLadder {

    static Random r = new Random();

    // UC-2: Roll the dice (1 to 6)
    static int rollDice() {
        return r.nextInt(6) + 1;
    }

    // UC-3: Check option (No Play, Ladder, Snake) and move player
    static int move(int pos, int dice) {
        int option = r.nextInt(3); // 0-No Play, 1-Ladder, 2-Snake

        // UC-4: Ladder - move forward
        if (option == 1 && pos + dice <= 100) {
            pos += dice;
        }
        // UC-5: Snake - move backward
        else if (option == 2) {
            pos -= dice;
            if (pos < 0)
                pos = 0;
        }
        // UC-3: No Play - position remains same

        return pos;
    }

    public static void main(String[] args) {

        // UC-1: Initialize player positions
        int p1 = 0, p2 = 0;
        int c1 = 0, c2 = 0;
        boolean turn = true;

        System.out.println("🎲 Snake & Ladder Game Started 🎲");

        // UC-6: Play game till one player reaches position 100
        while (p1 < 100 && p2 < 100) {
            int dice = rollDice();

            if (turn) {
                c1++;
                p1 = move(p1, dice);
                System.out.println("Player 1 rolled " + dice + " | Position: " + p1);
            } else {
                c2++;
                p2 = move(p2, dice);
                System.out.println("Player 2 rolled " + dice + " | Position: " + p2);
            }
            turn = !turn;
        }

        // UC-6: Display winner and dice count
        System.out.println("\nWinner: " + (p1 == 100 ? "Player 1" : "Player 2"));
        System.out.println("Dice Rolls: " + (p1 == 100 ? c1 : c2));
    }
}
