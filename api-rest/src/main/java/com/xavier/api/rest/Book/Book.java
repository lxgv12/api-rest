package com.xavier.api.rest.Book;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String nombre;
    private String precio;
    private String autor;
    private String editorial;
    private String publicado;
    private String genero;
    private String idioma;
    private String iSBN;
    private String formato;
    private String urlImagen;
}
