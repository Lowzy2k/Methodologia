package com.example.methodologia;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Engine {
    private String Game;
    private int dice;
    private int tiles;
    private int players;



    public String getGame() {
        return Game;
    }

    public void setGame(String game) {
        Game = game;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getTiles() {
        return tiles;
    }

    public void setTiles(int tiles) {
        this.tiles = tiles;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "Game='" + Game + '\'' +
                ", dice=" + dice +
                ", tiles=" + tiles +
                ", players=" + players +
                '}';
    }
}
