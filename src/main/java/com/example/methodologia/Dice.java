package com.example.methodologia;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Dice {

    int dice_max, dice_min;

    public int roll() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Engine engine = mapper.readValue(new File("src/main/resources/com/example/methodologia/engine.json"), Engine.class);
            int dice = engine.getDice();
            if (dice == 1) {
                dice_min = 1;
                dice_max = 6;
            }
        }

            catch (IOException e) {
                e.printStackTrace();
            }
            Random rand = new Random();
            return rand.nextInt(dice_min, dice_max);

    }
}
