package org.example.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private Integer edad;
    private Direccion direccion;
    private List<Persona> amigos = new ArrayList<>();
    private Producto producto;
    private List<String> hobbies;

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos, Producto producto, List<String> hobbies) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
        this.producto = producto;
        this.hobbies = hobbies;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos, Producto producto) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
        this.producto = producto;
    }

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCalle() {
        return direccion.getCalle();
    }

    public String getCiudad() {
        return direccion.getCiudad();
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Persona> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Persona> amigos) {
        this.amigos = amigos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        if (edad != null) return
                nombre + " (" + edad + "). \n" +
                        "Dirección: " + direccion
                        +"\nAmigos: " + amigos
                        +"\n"+producto
                ;

        else return nombre;

    }
}
