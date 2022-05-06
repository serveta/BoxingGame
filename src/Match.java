package src;

public class Match {
    Fighter player1;
    Fighter player2;
    int minWeight;
    int maxWeight;

    Match(Fighter player1, Fighter player2, int minWeight, int maxWeight) {
        this.player1 = player1;
        this.player2 = player2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void playerControl() {
        if ((player1.weight <= this.maxWeight) && (player1.weight >= this.minWeight) &&
                (player2.weight <= this.maxWeight) && (player2.weight >= this.minWeight)) {
            showMatchInfo();
        } else {
            System.out.println("\nWARNING: Players are not eligible for this match.");
        }
    }
    void showMatchInfo() {
        System.out.println();
        System.out.println("*** MATCH INFO ***");
        System.out.println("Player - 1\t: " + player1.name);
        System.out.println("Player - 2\t: " + player2.name);
        System.out.println("Weight\t: " + this.minWeight + " - " + this.maxWeight);
    }

}
