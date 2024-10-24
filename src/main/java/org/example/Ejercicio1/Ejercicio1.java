package org.example.Ejercicio1;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new Ejercicio1Adapter())
                .setPrettyPrinting()
                .create();

        Persona persona = new Persona("Ppep",20);
        String json = gson.toJson(persona);
        System.out.println(json);

        Persona persona1 = gson.fromJson(json, Persona.class);
        System.out.println(persona1);

    }
}



//Crea una clase Persona con atributos nombre y edad.
// Implementa un JsonSerializer y un JsonDeserializer para esta clase,
// personalizando los nombres de los atributos en el JSON resultante,
// de modo que aparezcan como name y age en formato JSON.