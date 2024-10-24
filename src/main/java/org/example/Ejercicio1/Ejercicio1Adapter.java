package org.example.Ejercicio1;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Ejercicio1Adapter implements JsonSerializer<Persona>, JsonDeserializer<Persona> {

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("name").getAsString();
        int edad = jsonObject.get("age").getAsInt();
        return new Persona(nombre,edad);
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name",persona.getNombre());
        jsonObject.addProperty("age",persona.getEdad());
        return jsonObject;
    }
}
