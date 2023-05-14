package com.example.methodologia;

public class Board {

    private int start,finish,tiles;

    public Board(int size) {
        this.start = 1;
        this.finish = start + size - 1;
        this.tiles = tiles;
    }
    public int getStart() {
        return start;
    }

    public int getTiles() {
        return tiles;
    }

    public int getEnd() {
        return finish;
    }

}

