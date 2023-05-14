package com.example.methodologia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import static javafx.application.Application.launch;


public class EngineJsonReader {

    public static void main(String [] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Engine engine = objectMapper.readValue(new File("src/main/resources/com/example/methodologia/engine.json"), Engine.class);
        System.out.println(engine);
    }

}


