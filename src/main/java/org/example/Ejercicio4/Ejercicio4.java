package org.example.Ejercicio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new Ejercicio4Adapter())
                .setPrettyPrinting()
                .create();

        Direccion direccion = new Direccion("Reina","Lugo");

        Persona amigo1 = new Persona("Luis",30, direccion);
        Persona amigo2 = new Persona("Jose", 10, direccion);

        List<Persona> amigos = new ArrayList<>();;
        amigos.add(amigo1);
        amigos.add(amigo2);

        Producto producto = new Producto("A",20);

        Persona persona = new Persona("Pepe", 20, direccion, amigos, producto);
        String json = gson.toJson(persona);
        System.out.println("json = " + json);

        Persona persona1 = gson.fromJson(json, Persona.class);
        System.out.println("persona1 = " + persona1);


    }
}
