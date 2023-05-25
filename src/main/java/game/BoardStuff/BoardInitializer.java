package game.BoardStuff;

import game.CardStuff.CardInitializer;
import game.Dice;
import game.GameStuff.Player;
import game.Rules.Rule;
import game.TileStuff.TileInitializer;
import org.json.simple.JSONArray;

import java.util.List;

public interface BoardInitializer {
    void initializeBoard();
    void initializeSpecs();
    void initializeDice(int diceNumber);
    void initializeTiles(JSONArray allTiles);
    void initializeCards(JSONArray allCards);
    void initializeRules(JSONArray allRules);
    void passedBoardSize(Player playerPlaying);
    void standOnBoardSize(Player playerPlaying);
    void declareWinner(List<Player> players, int rounds);
    void removePlayer(Player playerPlaying, List<Player> players);
    void playersCurrentState(List<Player> players);
    void setTiles(List<TileInitializer> tiles);
    List<TileInitializer> getTiles();
    void setBoardSize(int boardSize);
    int getBoardSize();
    void setBoardType(String boardType);
    String getBoardType();
    void setDice(List<Dice> dice);
    List<Dice> getDice();
    void setCards(List<CardInitializer> cards);
    List<CardInitializer> getCards();
    void setRules(List<Rule> rules);
    List<Rule> getRules();
}
