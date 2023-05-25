package game.TileStuff;

import game.CardStuff.CardInitializer;
import game.GameStuff.Player;

import java.util.List;

public interface TileInitializer {
    void executeSpecificTile(Player player, int diceSum, List<CardInitializer> boardCards, List<Player> players);
}
