package src;

import java.util.Scanner;

public class Fighter {
    String name;
    int health;
    int weight;
    int damage;
    int dodge;

    Fighter() {
        this.health = 100;
    }

    Fighter(String name, int weight, int damage, int dodge) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
        this.dodge = dodge;
    }

    void createPlayer(int playerCount) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n*** Create a player ***");
            System.out.print("Player-" + playerCount + " name : ");
            name = input.next();
            System.out.print("Player-" + playerCount + " weight (85-110) : ");
            weight = input.nextInt();
            System.out.print("Player-" + playerCount + " damage (1-10) : ");
            damage = input.nextInt();
            System.out.print("Player-" + playerCount + " dodge (1-100) : ");
            dodge = input.nextInt();
        } while (playerControl());
    }

    boolean playerControl() {
        if ((this.damage > 0 && this.damage <= 10) && (this.dodge >= 0 && this.dodge <= 100)) {
            System.out.println("JOINED: " + this.name + " is ready.");
            return false;
        } else {
            System.out.println("\nWARNING (eliminated): Doping detected in " + this.name);
            return true;
        }
    }

    void showFighterInfo() {
        System.out.println();
        System.out.println("*** FIGHTER INFO " + this.name + " ***");
        System.out.println("Fighter Weight\t: " + this.weight);
        System.out.println("Fighter Health\t: " + this.health);
        System.out.println("Fighter Damage\t: " + this.damage);
        System.out.println("Fighter Dodge\t: " + this.dodge);
    }

    void damage(Fighter fighter) {
        this.health -= fighter.damage;
    }

    boolean isDodge() {
        return (Math.random() * 100) < this.dodge;
    }

}
