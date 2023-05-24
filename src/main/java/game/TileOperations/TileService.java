package game.TileOperations;

import game.CardOperations.CardService;
import game.GameOperations.Player;

import java.util.List;

public interface TileService {
    void executeSpecificTile(Player player, int diceSum, List<CardService> boardCards, List<Player> players);
}
