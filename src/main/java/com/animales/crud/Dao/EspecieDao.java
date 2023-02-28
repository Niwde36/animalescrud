package com.animales.crud.Dao;


// Imprto la clase Especie 
import com.animales.crud.Models.Especie;
//Librerías necesarias.
import org.springframework.data.repository.CrudRepository;


// EspecieDao toma de la superclase CrudRepository los datos
//necesarios, de la clase Especie y el tipo de dato  de la Pk en este caso String.
public interface EspecieDao extends CrudRepository< Especie, String> {

}