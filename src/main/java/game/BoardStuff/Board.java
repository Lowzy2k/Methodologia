package game.BoardStuff;


import game.CardStuff.CardInitializer;
import game.Dice;
import game.GameStuff.Player;
import game.Rules.Rule;
import game.TileStuff.TileInitializer;
import org.json.simple.JSONArray;

import java.util.List;

public class Board implements BoardInitializer {
    public Board(){
    }

    @Override
    public void setTiles(List<TileInitializer> newTiles) {

    }

    @Override
    public List<TileInitializer> getTiles() {
        return null;
    }

    @Override
    public void setBoardSize(int newBoardSize) {

    }

    @Override
    public int getBoardSize() {
        return 0;
    }

    @Override
    public void setBoardType(String newBoardType) {

    }

    @Override
    public String getBoardType() {
        return null;
    }

    @Override
    public void setDice(List<Dice> newDice) {

    }

    @Override
    public List<Dice> getDice() {
        return null;
    }

    @Override
    public void setCards(List<CardInitializer> newCards) {

    }

    @Override
    public List<CardInitializer> getCards() {
        return null;
    }

    @Override
    public void setRules(List<Rule> newRules) {

    }

    @Override
    public List<Rule> getRules() {
        return null;
    }

    @Override
    public void initializeBoard() {

    }
    @Override
    public void passedBoardSize(Player playerPlaying){

    }
    @Override
    public void standOnBoardSize(Player playerPlaying){

    }
    @Override
    public void removePlayer(Player playerPlaying, List<Player> players){

    }
    @Override
    public void declareWinner(List<Player> players, int rounds){

    }
    @Override
    public void playersCurrentState(List<Player> players){

    }
    @Override
    public void initializeSpecs(){

    }
    @Override
    public void initializeDice(int diceNumber) {

    }
    @Override
    public void initializeTiles(JSONArray allTiles) {

    }
    @Override
    public void initializeCards(JSONArray allCards) {

    }
    @Override
    public void initializeRules(JSONArray allRules){

    }

}
