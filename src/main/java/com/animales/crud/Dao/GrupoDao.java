package com.animales.crud.Dao;

// Imprto la clase Grupo para usarla mas adelante.

import com.animales.crud.Models.Grupo;
//Librerías necesarias.
import org.springframework.data.repository.CrudRepository;

// Anotación para gestionar las colecciones de datos

/*  EspecieDao toma de la superclase CrudRepository los datos
necesarios, de la clase Grupo y el tipo de dato de la Primary Key en este caso String.*/
public interface GrupoDao extends CrudRepository< Grupo, String> {

}