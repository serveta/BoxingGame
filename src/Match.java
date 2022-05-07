package src;

public class Match {
    Fighter player1;
    Fighter player2;
    int minWeight;
    int maxWeight;
    boolean whichPlayerStarts;
    int roundCount = 0;
    boolean player1Dodge = false;
    boolean player2Dodge = false;

    Match(Fighter player1, Fighter player2, int minWeight, int maxWeight) {
        this.player1 = player1;
        this.player2 = player2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {

        while (this.player1.health > 0 && this.player2.health > 0) {
            player1Dodge = false;
            player2Dodge = false;

            if (whichPlayerStarts) {
                //player - 1 starts the game...
                if (player2.isDodge()){
                    player2Dodge = true;
                } else {
                    this.player2.damage(this.player1);
                }
            }

            if (this.player2.health <= 0) {
                this.player2.health = 0;
                winner(player1, player2);
                break;
            }


            //player - 2 starts the game...
            if (player1.isDodge()){
                player1Dodge = true;
            } else {
                this.player1.damage(this.player2);
            }

            if (this.player1.health <= 0) {
                this.player1.health = 0;
                winner(player2, player1);
                break;
            }


            if (!whichPlayerStarts) {
                this.player2.damage(this.player1);
                if (player2.isDodge()){
                    player2Dodge = true;
                } else {
                    this.player2.damage(this.player1);
                }
            }

            roundInfo(player1Dodge, player2Dodge);

        }

    }

    void roundInfo(boolean player1Dodge, boolean player2Dodge) {
        System.out.println("\n*********ROUND -" + (++roundCount) + "- INFO**********");
        System.out.println(player1Dodge ? player1.name + " dodged!" : player1.name + " took damage!");
        System.out.println(player2Dodge ? player2.name + " dodged!" : player2.name + " took damage!");
        this.player1.showFighterInfo();
        this.player2.showFighterInfo();
    }

    boolean whichPlayerStarts() {
        whichPlayerStarts = (Math.random() * 100) >= 50;
        return whichPlayerStarts;
    }

    void playerControl() {
        if ((this.player1.weight <= this.maxWeight) && (this.player1.weight >= this.minWeight) &&
                (this.player2.weight <= this.maxWeight) && (this.player2.weight >= this.minWeight)) {
            showMatchInfo();
        } else {
            System.out.println("\nWARNING: Players are not eligible for this match.");
        }
    }

    void winner(Fighter winner, Fighter loser) {
        roundInfo(player1Dodge, player2Dodge);
        System.out.println("\n*** The match ends. ***");
        System.out.println("\nWINNER : " + winner.name);
        //System.out.println("\n*** WINNER / LOSER INFOS ***");
        //winner.showFighterInfo();
        //loser.showFighterInfo();
    }

    void showMatchInfo() {
        System.out.println();
        System.out.println("*** MATCH INFO ***");
        System.out.println("Player - 1\t: " + this.player1.name);
        System.out.println("Player - 2\t: " + this.player2.name);
        System.out.println("Weight\t: " + this.minWeight + " - " + this.maxWeight);

        System.out.println("*** The coin was flipped. ***");
        if (whichPlayerStarts()) {
            System.out.println(this.player1.name + " starts the game!");
        } else {
            System.out.println(this.player2.name + " starts the game!");
        }

        run();
    }

}
