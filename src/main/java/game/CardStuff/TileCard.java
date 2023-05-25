package game.CardStuff;

import game.GameStuff.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TileCard implements CardInitializer {
    private int id;
    private String message;
    private String parameter;
    private double value;

    public TileCard(int id, String message, String parameter, double value) {
        this.id = id;
        this.message = message;
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public void executeSpecificCard(Player player, List<Player> players){
        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                Integer pointsPlayer1 = p1.getPoints();
                Integer pointsPlayer2 = p2.getPoints();
                return pointsPlayer1.compareTo(pointsPlayer2);
            }
        });
        System.out.println("Δύναμη κάρτας:" + this.message);
        if ((int)this.value == -1){
            //Is Minimum Tile
            if (player.getPoints() == sortedPlayers.get(0).getPoints()) {
                System.out.println("'" + player.getName() + "', έχεις τους λιγότερο δυνατόν πόντους.");
                return;
            } else {
                int currentPlayerPosition = player.getPosition(); //Current Player Position
                int playerPositionToChange = sortedPlayers.get(0).getPosition(); //Player Position to Change
                int playerIDToChange = sortedPlayers.get(0).getId();
                for (Player singlePlayer: players){
                    if (singlePlayer.getId() == playerIDToChange){
                        //Change Position with this player
                        singlePlayer.setPosition(currentPlayerPosition);
                        player.setPosition(playerPositionToChange);
                        break;
                    }
                }
                System.out.println("'" + player.getName() + "' άλλαξε θέση με " + sortedPlayers.get(0).getName() + " αφού είχαν τους λιγότερους δυνατόν πόντους.");
            }
        } else {
            //Is Maximum Tile
            if (player.getPoints() == sortedPlayers.get(sortedPlayers.size() - 1).getPoints()) {
                System.out.println("'" + player.getName() + "', έχεις το μέγιστο διαθέσιμο αριθμό πόντων.");
            } else {
                int currentPlayerPosition = player.getPosition(); //Current Player Position
                int playerPositionToChange = sortedPlayers.get(sortedPlayers.size() - 1).getPosition(); //Player Position to Change
                int playerIDToChange = sortedPlayers.get(sortedPlayers.size() - 1).getId();
                for (Player singlePlayer: players){
                    if (singlePlayer.getId() == playerIDToChange){
                        //Change Position with this player
                        singlePlayer.setPosition(currentPlayerPosition);
                        player.setPosition(playerPositionToChange);
                        break;
                    }
                }
                System.out.println("'" + player.getName() + "' άλλαξε θέση με " + sortedPlayers.get(sortedPlayers.size() - 1).getName() + " αφού είχαν το μεγαλύτερο αριθμό πόντων.");
            }
        }
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message; }
    public void printMessage(String message){System.out.println(message);}
    public String getParameter() { return this.parameter; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    public double getValue() { return this.value; }
    public void setValue(double value) { this.value = value; }


}
