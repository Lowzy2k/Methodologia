package game.TileStuff;

import org.json.simple.JSONObject;

public class TilesPicker {
    public static TileInitializer getInstance(JSONObject jsonObject){
        final String parameter = jsonObject.get("parameter").toString();
        switch (parameter) {
            case "simple" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new FidakiTiles(index, value);
            }
            case "card" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new CardTile(index, stat, parameter, value);
            }
            case "points" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new PointsTile(index, stat, parameter, value);
            }
            case "dicepoints" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new Craps(index, stat, parameter, value);
            }
            case "tile" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new Jump(index, stat, parameter, value);
            }
            case "none" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new EmptyTile(index, stat, parameter, value);
            }
            default -> {
                return new Tile();
            }
        }
    }
}