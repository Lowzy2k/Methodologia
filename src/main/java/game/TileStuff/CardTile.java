package game.TileStuff;

import game.CardStuff.CardInitializer;
import game.GameStuff.Player;

import java.util.List;
import java.util.Random;

public class CardTile implements TileInitializer {
    private int index;
    private String stat;
    private String parameter;
    private double value;

    public CardTile(){
        this.index = 0;
        this.stat = "";
        this.parameter = "";
        this.value = 0;
    }

    public CardTile(int index, String stat, String parameter, double value) {
        this.index = index;
        this.stat = stat;
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardInitializer> boardCards, List<Player> players){
        System.out.println("Είδος Θέσης: " + this.stat);
        int randomCard = new Random().nextInt(boardCards.size());
        CardInitializer cardToExecute = boardCards.get(randomCard);
        System.out.println(player.getName() + " είναι στη θέση " + this.index + " και διαλέγει μια τυχαία κάρτα.");
        cardToExecute.executeSpecificCard(player, players);
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

    public double getValue(){ return this.value; }

    public void setIndex(int index){
        this.index = index;
    }

    public void setStat(String stat){
        this.stat = stat;
    }

    public void setParameter(String parameter){
        this.parameter = parameter;
    }

    public void setValue(double value){
        this.value = value;
    }


}
