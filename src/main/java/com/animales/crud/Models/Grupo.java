//Paquete que contiene las clases para ser usadas para el acceso a la base de datos.
package com.animales.crud.Models;

/**
 * Descripción: Se importan las librerias necesarias para el proyecto.
 * Serializable se usa para convertir un objeto a bytes, para ser enviado 
 * y luego recibido, y reconstruido a partir de esos bytes.
*/
// import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
//Anotaciones para obtener y devolver valores a la base de datos.
@Getter
@Setter
// Anotación dónde especifíco la creación de una entidad. 
@Entity
// Anotación Table para especificar el nombre de la Base de datos
@Table(name="grupo")
public class Grupo{

    //Anotaciones para el mapeo de la Base de datos.
    
@Id
@Column(name="id_grupo")
public String id_grupo;
@Column(name="nombre_grupo")
private String nombre_grupo;

// Anotación para sobre-escribir la información en la Base de Datos.
@Override
public String toString() {
	return "Grupo [id_grupo=" + id_grupo + ", nombre_grupo=" + nombre_grupo + "]";
}
}