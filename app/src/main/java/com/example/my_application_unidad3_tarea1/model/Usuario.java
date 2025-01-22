package com.example.my_application_unidad3_tarea1.model;

public class Usuario {

    private String nombre;
    private String apellido;
    private String DNI;
    private String nombreUsuario;
    private String contraseniaUsuario;

    public Usuario(String nombre, String apellido, String DNI, String nombreUsuario, String contraseniaUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseniaUsuario='" + contraseniaUsuario + '\'' +
                '}';
    }
}
