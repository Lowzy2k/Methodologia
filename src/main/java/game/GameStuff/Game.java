package game.GameStuff;

import game.BoardStuff.Board;
import game.BoardStuff.BoardPicker;
import game.BoardStuff.BoardInitializer;
import game.Dice;
import game.Rules.Rule;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private BoardInitializer board;
    private List<Player> players;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
    }

    public Game(BoardInitializer board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void setBoard(BoardInitializer board){
        this.board = board;
    }

    public BoardInitializer getBoard(){
        return this.board;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public void createGame(int userChoice){
        this.readPlayersNumber(userChoice);
        this.createBoard(userChoice);
    }

    public void readPlayersNumber(int userChoice){
        String fileName;
        if (userChoice == 1){
            fileName = "/fidaki.json";
        } else {
            fileName = "/pointsandcards.json";
        }
        try {
            JSONParser jsonParser = new JSONParser();
            String filePath = new File("").getAbsolutePath();
            String specsPath = filePath + fileName;
            JSONObject fileJsonObject = (JSONObject) jsonParser.parse(new FileReader(specsPath));

            JSONObject gameObj = (JSONObject) fileJsonObject.get("game");
            final int playersNumber = Integer.parseInt(gameObj.get("players").toString());
            final int initialPlayerPoints = Integer.parseInt(gameObj.get("initial_player_points").toString());
            this.initializePlayers(playersNumber, initialPlayerPoints);
        } catch (Exception e){
            System.exit(90);
        }
    }

    public void initializePlayers(int playersNumber, int initialPlayerPoints){
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<playersNumber; i++){
            System.out.println("Δώσε όνομα στον παίκτη " + (i + 1) + ".");
            final String playerName = sc.nextLine();
            final Player player = new Player( (i + 1), playerName,0,initialPlayerPoints);
            players.add(player);
        }
        this.players = players;
    }

    public void createBoard(int userChoice){

        BoardInitializer gameBoard = BoardPicker.getInstance(userChoice);
        gameBoard.initializeBoard();
        this.board = gameBoard;
    }

    public void displayRules(){
        List<Rule> rules = this.board.getRules();
        System.out.println("Κανόνες παιχνιδιού:");
        for (Rule rule : rules) {
            System.out.println(rule.getMessage());
        }
    }

    public void printMenu(Player playerPlaying){
        System.out.println(" Ειναι σειρά του παίκτη :" + playerPlaying.getName());
        System.out.println("Διάλεξε μία από τις τρεις επιλογές:");
        System.out.println("1. Ρίξε το ζάρι(α).");
        System.out.println("2. Εμφάνισε τους κανόνες.");
        System.out.println("3. Έξοδος.");
    }

    public void play(){
        this.displayRules();
        Scanner sc = new Scanner(System.in);
        int rounds=0;
        do {
            for (Player player : this.players) {

                this.printMenu(player);
                final int userChoice = sc.nextInt();
                switch (userChoice) {
                    case 1 -> {

                        this.playGame(player);
                    }
                    case 2 -> {

                        this.displayRules();
                    }
                    case 3 -> {
                        System.out.println("Έξοδος.");
                        System.exit(0);
                    }
                    default -> {
                    continue;
                    }
                }
            }
            this.board.playersCurrentState(this.players);
            rounds++;
            if (rounds==30){
                this.board.declareWinner(this.players, rounds);
            }

        } while (true);
    }

    public void playBoard(Player playerPlaying) {
        if (playerPlaying.getPosition() > this.board.getBoardSize()){
            System.out.println(playerPlaying.getName() + ", ξεπέρασες το όριο της διαδρομής.");
            this.board.passedBoardSize(playerPlaying);
        } else if (playerPlaying.getPosition() == this.board.getBoardSize()){
            System.out.println(playerPlaying.getName() + ", έφτασες στο τέλος της διαδρομής.");
            this.board.standOnBoardSize(playerPlaying);
        }
    }
    public void playGame(Player playerPlaying){

        this.playBoard(playerPlaying);

        List<Dice> allDice = this.board.getDice();
        int diceSum = 0;
        for (Dice dice: allDice){
            dice.roll();
            diceSum += dice.getDice();
        }
        System.out.println("Έφερες: " + diceSum);

        int tempPlayerPosition = playerPlaying.getPosition() + diceSum;
        playerPlaying.setPosition(tempPlayerPosition);

        this.playBoard(playerPlaying);

        this.board.getTiles().get(playerPlaying.getPosition()).executeSpecificTile(playerPlaying, diceSum, this.board.getCards(), this.players);

        this.board.removePlayer(playerPlaying, this.players);

    }
}
