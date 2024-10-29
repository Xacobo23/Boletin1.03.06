package org.example.Ejercicio5;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5Adapter implements JsonSerializer<Persona>, JsonDeserializer<Persona> {
    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Persona p = new Persona(jsonObject.get("name").getAsString(), jsonObject.get("age").getAsInt());

//        String nombre = jsonObject.get("name").getAsString();
//        int edad = jsonObject.get("age").getAsInt();

        String[] address = jsonObject.get("address").getAsString().split(",");

        p.setDireccion(new Direccion(address[0], address[1]));

        List<Persona> amigos = new ArrayList<>();
        for (JsonElement amigo : jsonObject.get("amigos").getAsJsonArray()) {

            JsonObject amigoList = amigo.getAsJsonObject();
            String[] direccion = amigoList.get("address").getAsString().split(",");
            Persona p1 = new Persona(amigoList.get("name").getAsString(), amigoList.get("age").getAsInt());
            p1.setDireccion(new Direccion(direccion[0], direccion[1]));
            amigos.add(
                    p1
            );
        }
        if (amigos != null) p.setAmigos(amigos);

        p.setProducto(new Producto(
                jsonObject.get("producto").getAsJsonObject().get("nombre").getAsString(),
                jsonObject.get("producto").getAsJsonObject().get("precio").getAsDouble()
        ));

        return p;
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();


        jsonObject.addProperty("name", persona.getNombre());
        jsonObject.addProperty("age", persona.getEdad());
        jsonObject.addProperty("address", persona.getCiudad() + ", " + persona.getCalle());

        if (persona.getAmigos() != null) {
            JsonArray jsonArray = new JsonArray();

            for (Persona amigo : persona.getAmigos()) {
                jsonArray.add(jsonSerializationContext.serialize(amigo));
            }

            jsonObject.add("amigos", jsonArray);
        }


        if (persona.getProducto() != null) {
            JsonObject jsonProduct = new JsonObject();
            jsonProduct.addProperty("nombre", persona.getProducto().getNombre());
            jsonProduct.addProperty("precio",
//                Double.parseDouble(String.format("%.2f",
                    persona.getProducto().getPrecio()
//                ))
            );
            jsonObject.add("producto", jsonProduct);
        }


        if (persona.getHobbies() != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < persona.getHobbies().size(); i++) {
                sb.append(persona.getHobbies().get(i));
                if (i < persona.getHobbies().size() - 1) {
                    sb.append(" - ");
                }
            }

            jsonObject.addProperty("hobbies", sb.toString());
        }


        return jsonObject;
    }
}
