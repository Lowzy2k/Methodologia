package game.BoardStuff;

public class BoardPicker {
    public static BoardInitializer getInstance(int type){
        if (type == 1) {
            return new FidakiBoard();
        }
        if (type == 2){
            return new PointsAndCardsBoard();
        }
        return new Board();
    }
}
