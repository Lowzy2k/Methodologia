package game.BoardStuff;

import game.CardStuff.CardPicker;
import game.CardStuff.CardInitializer;
import game.Dice;
import game.GameStuff.Player;
import game.Rules.Rule;
import game.TileStuff.TileInitializer;
import game.TileStuff.TilesPicker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PointsAndCardsBoard implements BoardInitializer {

    private List<TileInitializer> tiles;
    private int boardSize;
    private String boardType;
    private List<Dice> dice;
    private List<CardInitializer> cards;
    private List<Rule> rules;

    public PointsAndCardsBoard() {
        this.tiles = new ArrayList<>();
        this.boardSize = 0;
        this.boardType = "";
        this.dice = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.rules = new ArrayList<>();
    }

    public PointsAndCardsBoard(List<TileInitializer> tiles, int boardSize, String boardType, List<Dice> dice, List<CardInitializer> cards, List<Rule> rules) {
        this.tiles = tiles;
        this.boardSize = boardSize;
        this.boardType = boardType;
        this.dice = dice;
        this.cards = cards;
        this.rules = rules;
    }
    @Override
    public void initializeBoard() {
        this.initializeSpecs();
    }
    @Override
    public void initializeSpecs() {
        try {
            JSONParser jsonParser = new JSONParser();
            String filePath = new File("").getAbsolutePath();
            String advancedSpecsPath = filePath + "/advancedspecs.json";
            JSONObject fileJsonObject = (JSONObject) jsonParser.parse(new FileReader(advancedSpecsPath));

            JSONObject gameObj = (JSONObject) fileJsonObject.get("game");

            final int sizeOfBoard = Integer.parseInt(gameObj.get("board_size").toString());
            setBoardSize(sizeOfBoard);

            final String typeOfBoard = gameObj.get("board_type").toString();
            setBoardType(typeOfBoard);

            final int diceNumber = Integer.parseInt(gameObj.get("dice_number").toString());
            this.initializeDice(diceNumber);

            JSONArray tilesArray = (JSONArray) fileJsonObject.get("tiles");
            this.initializeTiles(tilesArray);

            JSONArray cardsArray = (JSONArray) fileJsonObject.get("cards");
            this.initializeCards(cardsArray);

            JSONArray rulesArray = (JSONArray) fileJsonObject.get("rules");
            this.initializeRules(rulesArray);

        } catch (Exception e) {
            System.exit(90);
        }
    }
    @Override
    public void initializeDice(int diceNumber) {
        List<Dice> allDice = new ArrayList<>();
        for (int i = 0; i < diceNumber; i++) {
            final Dice newDice = new Dice();
            allDice.add(newDice);
        }
        this.dice = allDice;
    }
    @Override
    public void initializeTiles(JSONArray allTiles) {
        List<TileInitializer> tilesList = new ArrayList<>();
        for (int i = 0; i < allTiles.toArray().length; i++) {
            JSONObject tileObj = (JSONObject) allTiles.get(i);
            final TileInitializer newTile = TilesPicker.getInstance(tileObj);
            tilesList.add(newTile);
        }
        this.tiles = tilesList;
    }
    @Override
    public void initializeCards(JSONArray allCards) {
        List<CardInitializer> cardsList = new ArrayList<>();
        for (int i = 0; i < allCards.toArray().length; i++) {
            JSONObject cardObj = (JSONObject) allCards.get(i);
            final CardInitializer newCard = CardPicker.getInstance(cardObj);
            cardsList.add(newCard);
        }
        this.cards = cardsList;
    }
    @Override
    public void initializeRules(JSONArray allRules) {
        List<Rule> rulesList = new ArrayList<>();
        for (int i = 0; i < allRules.toArray().length; i++) {
            JSONObject ruleObj = (JSONObject) allRules.get(i);
            final Rule newRule = new Rule(String.valueOf(ruleObj.get("rule")));
            rulesList.add(newRule);
        }
        this.rules = rulesList;
    }

    @Override
    public void passedBoardSize(Player playerPlaying){
        playerPlaying.setPoints(playerPlaying.getPoints() + 200);
        System.out.println("Κέρδισες 200 πόντους!");
        playerPlaying.setPosition( playerPlaying.getPosition() % this.boardSize);
    }
    @Override
    public void standOnBoardSize(Player playerPlaying){
        playerPlaying.setPosition(playerPlaying.getPosition() - 1);
    }

    @Override
    public void declareWinner(List<Player> players, int rounds){
        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                Integer pointsPlayer1 = p1.getPoints();
                Integer pointsPlayer2 = p2.getPoints();
                return pointsPlayer2.compareTo(pointsPlayer1);
            }
        });
        players=sortedPlayers;
        this.playersCurrentState(players);
        System.out.println(players.get(0).getName() + " Είναι ο νικητής!");
        System.exit(0);
    }

    @Override
    public void removePlayer(Player playerPlaying, List<Player> players){
        if (playerPlaying.getPoints()<=0){
            System.out.println(playerPlaying.getName() + " του τελείωσαν οι πόντοι και είναι εκτός παιχνιδιού.");
            players.remove(playerPlaying.getId()-1);
        }
    }
    @Override
    public void playersCurrentState(List<Player> players){
        System.out.println("Κατάταξη: ");
        System.out.println("Id | Όνομα παίκτη |  Tile  |  Πόντοι  |");
        for(Player player : players){
            System.out.printf("%2d | %-13s | %6d | %8d |%n", player.getId(), player.getName(), player.getPosition(), player.getPoints());
        }
    }

    @Override
    public void setTiles(List<TileInitializer> tiles) {
        this.tiles = tiles;
    }

    @Override
    public List<TileInitializer> getTiles() {
        return this.tiles;
    }

    @Override
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public int getBoardSize() {
        return this.boardSize;
    }

    @Override
    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    @Override
    public String getBoardType() {
        return this.boardType;
    }

    @Override
    public void setDice(List<Dice> dice) {
        this.dice = dice;
    }

    @Override
    public List<Dice> getDice() {
        return this.dice;
    }

    @Override
    public void setCards(List<CardInitializer> cards) {
        this.cards = cards;
    }

    @Override
    public List<CardInitializer> getCards() {
        return this.cards;
    }

    @Override
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public List<Rule> getRules() {
        return this.rules;
    }

}
