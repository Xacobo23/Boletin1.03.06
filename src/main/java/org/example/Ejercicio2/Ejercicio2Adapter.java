package org.example.Ejercicio2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Ejercicio2Adapter implements JsonSerializer<Persona>, JsonDeserializer<Persona> {
    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Persona p = new Persona(jsonObject.get("name").getAsString(), jsonObject.get("age").getAsInt());




        String nombre = jsonObject.get("name").getAsString();
        int edad = jsonObject.get("age").getAsInt();

        String[] address = jsonObject.get("address").getAsString().split(",");

        p.setDireccion(new Direccion(address[0],address[1]));


        return p;
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name",persona.getNombre());
        jsonObject.addProperty("age",persona.getEdad());

        jsonObject.addProperty("address", persona.getCiudad() + ", " + persona.getCalle());

        return jsonObject;
    }
}
