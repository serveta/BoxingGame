package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Fighter player1 = new Fighter();
        Fighter player2 = new Fighter();

        player1.createPlayer(1);
        player2.createPlayer(2);

        Match match = new Match(player1, player2, 85,120);
        match.playerControl();

    }
}
