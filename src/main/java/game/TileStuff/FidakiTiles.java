package game.TileStuff;

import game.CardStuff.CardInitializer;
import game.GameStuff.Player;

import java.util.List;

public class FidakiTiles implements TileInitializer {
    private int index;
    private int value;

    public FidakiTiles(){
        this.index = 0;
        this.value = 0;
    }

    public FidakiTiles(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardInitializer> boardCards, List<Player> players) {
        player.setPosition(player.getPosition() + this.value);
        System.out.println(player.getName() + " πήγε στη θέση " + this.index + " και μετακινήθηκε για " + this.value + " στη θέση " + player.getPosition() + ".");
    }

    public int getIndex(){
        return this.index;
    }
    public int getValue(){
        return this.value;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setValue(int value){
        this.value = value;
    }

}
