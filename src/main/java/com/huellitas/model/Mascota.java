package com.huellitas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mascotas")

public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El tipo es obligatorio")
    @Column(nullable = false)
    private String tipo;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private int edad;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    public Mascota() {

    }

    public Mascota(Long id, String nombre, String tipo, int edad, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
