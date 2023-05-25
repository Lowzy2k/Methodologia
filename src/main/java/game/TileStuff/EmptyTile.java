package game.TileStuff;

import game.CardStuff.CardInitializer;
import game.GameStuff.Player;

import java.util.List;

public class EmptyTile implements TileInitializer {
    private int index;
    private String stat;
    private String parameter;
    private int value;

    public EmptyTile(){
        this.index = 0;
        this.stat = "";
        this.parameter = "";
        this.value = 0;
    }

    public EmptyTile(int index, String stat, String parameter, int value) {
        this.index = index;
        this.stat = stat;
        this.parameter = parameter;
        this.value = value;
    }
    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardInitializer> boardCards, List<Player> players){
        System.out.println("Είδος θέσης: " + this.stat);
        System.out.println(player.getName() + " είναι στη θέση " + this.index + " ' οπου δεν υπάρχει δύναμη.");
    }
    public int getIndex(){
        return this.index;
    }
    public String getStat(){
        return this.stat;
    }

    public String getParameter(){
        return this.parameter;
    }

    public int getValue(){
        return this.value;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public void setStat(String stat){
        this.stat = stat;
    }

    public void setParameter(String parameter){
        this.parameter = parameter;
    }

    public void setValue(int value){
        this.value = value;
    }


}