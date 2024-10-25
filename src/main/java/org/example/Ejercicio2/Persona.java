package org.example.Ejercicio2;

public class Persona {
    private String nombre;
    private int edad;
    private Direccion direccion;

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

    public String getCalle(){
        return direccion.getCalle();
    }
    public String getCiudad(){
        return direccion.getCiudad();
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad+"). \n" +
                "Dirección: "+direccion;
    }
}
