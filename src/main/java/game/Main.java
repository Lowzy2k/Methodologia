package game;

import game.GameStuff.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Καλώς ήρθες στην επιλογή παιχνιδιού! \t ");
        chooseGame();
    }

    public static void chooseGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Επιλέξτε παιχνίδι ΤΩΡΑ:");
        System.out.println("1. Επιτραπέζιο Φιδάκι!");
        System.out.println("2. Κάρτες και πόντοι!" +"");
        System.out.println("0. Έξοδος.");
        final String userChoice = sc.nextLine();
        boolean isWrongAnswer = false;
        do {
            switch (userChoice) {
                case "1":
                    executeFidaki();
                case "2":
                    executePointsAndCards();
                case "0":
                    System.out.println("Έξοδος!");
                    System.exit(0);
                default:
                    System.out.println("Λάθος είσοδος! Δοκίμασε ξανά!");
                    isWrongAnswer = true;
            }
        } while(isWrongAnswer);
    }

    public static void executeFidaki(){
        Game game = new Game();
        game.createGame(1);
        game.play();
    }

    public static void executePointsAndCards(){
        Game game = new Game();
        game.createGame(2);
        game.play();
    }
}

