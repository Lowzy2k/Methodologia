package game.CardStuff;

import game.GameStuff.Player;

import java.util.List;

public class StartCard implements CardInitializer {
    private int id;
    private String message;
    private String parameter;
    private double value;
    public StartCard(int id, String message, String parameter, double value) {
        this.id = id;
        this.message = message;
        this.parameter = parameter;
        this.value = value;
    }
    @Override
    public void executeSpecificCard(Player player, List<Player> players){
        System.out.println("Δύναμη κάρτας: " + this.message);
        double playerPoints = player.getPoints();
        playerPoints += this.value;
        player.setPoints((int)playerPoints);
        player.setPosition(0);
        System.out.println(player.getName() + " μετακινήθηκε στη θέση και πήρε " + ((int)this.value) + " οπότε τώρα έχει " + player.getPoints() + " πόντους.");
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
