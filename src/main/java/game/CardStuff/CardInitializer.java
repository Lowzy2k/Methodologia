package game.CardStuff;
import game.GameStuff.Player;
import java.util.List;

public interface CardInitializer {
    void executeSpecificCard(Player player, List<Player> players);
}