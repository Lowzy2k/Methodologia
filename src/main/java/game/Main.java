package game;

import game.GameOperations.Game;
import java.util.Scanner;
import java.io.IOException;





public class Main {

    public static void main(String [] args) throws IOException {

        System.out.println("Welcome to the Game Generator. \t ");
        chooseGame();
        }
    public static void chooseGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose game from the Game Generator:");
        System.out.println("1. Limited range board game of progress and setbacks.");
        System.out.println("2. Endless board game containing cards and special abilities.");
        System.out.println("0. Exit.");
        final String userChoice = sc.nextLine();
        boolean isWrongAnswer = false;
        do {
            switch (userChoice) {
                case "1":
                    executeLimitedRangeGame();
                case "2":
                    executeEndlessRangeGame();
                case "0":
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Not a valid input. Try again.");
                    isWrongAnswer = true;
            }
        } while(isWrongAnswer);
    }

    public static void executeLimitedRangeGame(){
        Game game = new Game();

    }

    public static void executeEndlessRangeGame(){
        Game game = new Game();

    }
}






