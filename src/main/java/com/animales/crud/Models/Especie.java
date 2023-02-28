//Paquete que contiene las clases para ser usadas para el acceso a la base de datos.
package com.animales.crud.Models;

//Se importan las librerias necesarias para el proyecto.
//Serializable se usa para convertir un objeto a bytes, para ser enviado y luego recibido, y reconstruido a partir de esos bytes.

// import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;

//Anotaciones para obtener y devolver valores a la base de datos.
@Getter
@Setter

// Anotación dónde especifíco la creación de una entidad. 
@Entity
// Anotación Table para especificar el nombre de la Base de datos
@Table(name="especie")
public class Especie{
@Id
@Column(name="id_especie")
private String id_especie;
@Column(name="nombre_especie")
private String nombre_especie;
@Column(name="cantidad")
private Integer cantidad;
//Anotación para traer id_grupo de la otra tabla(Grupo)
@ManyToOne
@JoinColumn(name = "id_grupo")
public Grupo grupo;
//Anotación para sobreescribir los valores de la tabla
@Override
public String toString() {
	return "Especie [id_especie=" + id_especie + ", nombre_especie=" + nombre_especie + 
	", cantidad=" + cantidad + ", id_grupo=" + grupo +"]";
}
}