package game.CardStuff;

import game.GameStuff.Player;

import java.util.List;
import java.util.Random;

public class PointsCard implements CardInitializer {

    private int id;
    private String message;
    private String parameter;
    private double value;

    public PointsCard(int id, String message, String parameter, double value) {
        this.id = id;
        this.message = message;
        this.parameter = parameter;
        this.value = value;
    }
    @Override
    public void executeSpecificCard(Player player, List<Player> players){
        if (this.value == 2 || this.value==0.5){
            System.out.println("Δύναμη κάρτας: " + this.message);
            double playerPoints = player.getPoints();
            playerPoints *= this.value;
            player.setPoints((int)playerPoints);
            System.out.println(player.getName() + " πέτυχε " + this.value + " * πόντους " + "οπότε τώρα έχει " + player.getPoints() + ".");
        } else if (this.value==100){
            System.out.println("Δύναμη κάρτας: " + this.message);
            int randomPlayerIndex;
            do {
                randomPlayerIndex= new Random().nextInt(players.size()-1);
                if (randomPlayerIndex != player.getId()-1) {
                    double newOthersPoints = players.get(randomPlayerIndex).getPoints() - this.value;
                    players.get(randomPlayerIndex).setPoints((int)newOthersPoints);
                    double newPpoints = player.getPoints();
                    newPpoints += this.value;
                    player.setPoints((int)newPpoints);
                    System.out.println(player.getName() + " πέτυχε " + (int)this.value + " πόντους από τον παίκτη " + players.get(randomPlayerIndex).getName() + ".");
                    break;
                }
            } while (true);
        } else {
            System.out.println("Δύναμη κάρτας: " + this.message);
            double playerPoints = player.getPoints();
            playerPoints += this.value;
            player.setPoints((int)playerPoints);
            System.out.println(player.getName() + " πέτυχε " + (int)this.value + " πόντους οπότε τώρα έχει " + player.getPoints() + ".");
        }
    }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message; }
    public String getParameter() { return this.parameter; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    public double getValue() { return this.value; }
    public void setValue(double value) { this.value = value; }


}
