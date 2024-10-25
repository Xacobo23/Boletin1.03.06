package org.example.Ejercicio2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ejercicio2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new Ejercicio2Adapter())
                .setPrettyPrinting()
                .create();
        
        Direccion direccion = new Direccion("Reina","Lugo");
        Persona persona = new Persona("Pepe", 20, direccion);
        String json = gson.toJson(persona);
        System.out.println("json = " + json);

        Persona persona1 = gson.fromJson(json, Persona.class);
        System.out.println("persona1 = " + persona1);


    }
}
