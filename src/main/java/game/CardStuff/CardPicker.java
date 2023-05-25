package game.CardStuff;

import org.json.simple.JSONObject;

public class CardPicker {
    public static CardInitializer getInstance(JSONObject jsonObject){
        final String parameter = jsonObject.get("parameter").toString();
        switch (parameter) {
            case "start" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final double value = Double.parseDouble(jsonObject.get("value").toString());
                return new StartCard(id, message, parameter, value);
            }
            case "points" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final double value = Double.parseDouble(jsonObject.get("value").toString());
                return new PointsCard(id, message, parameter, value);
            }
            case "tile" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final double value = Double.parseDouble(jsonObject.get("value").toString());
                return new TileCard(id, message, parameter, value);
            }
            default -> {
                return new Card();
            }
        }
    }
}
