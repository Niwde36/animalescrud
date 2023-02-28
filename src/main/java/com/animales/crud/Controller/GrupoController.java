package com.animales.crud.Controller;
// Se importa el modelo.
import com.animales.crud.Models.Grupo;
//import com.animales.crud.Security.Hash;
//Se importa el DAO (Repositorio).
import com.animales.crud.Dao.GrupoDao;
//Se importa el Servicio.
import com.animales.crud.Service.GrupoService;
// Librería para usar una lista o arreglo para guardar la información.
import java.util.List;

//import javax.validation.Valid;

//Importo las librerias que permiten definir los recursos para consumir el API REST.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Aqui se define el API REST y en adelante se usan los recursos que ofrece Spring Boot
@RestController
//CrossOrigin lo uso para definir el protocolo de interacción entre navegador y servidor
@CrossOrigin("*")
//Aqui apunto a la ubicación del API Rest
@RequestMapping("/grupo")


public class GrupoController {
    @Autowired
    private GrupoDao grupoDao; 
    @Autowired
    private GrupoService grupoService;
    
    //Etiqueta como recurso para crear un registro.
    @PostMapping(value="/")
    public ResponseEntity<Grupo> agregar(@RequestBody Grupo grupo){        
        Grupo obj = grupoService.save(grupo);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
   
    //Etiqueta que uso como recurso para eliminar un registro.
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Grupo> eliminar(@PathVariable String id){ 
        Grupo obj = grupoService.findById(id); 
        if(obj!=null) 
            grupoService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    //Etiqueta que uso para actualizar un registro.
    @PutMapping(value="/") 
    public ResponseEntity<Grupo> editar(@RequestBody Grupo grupo){ 
        Grupo obj = grupoService.findById(grupo.getId_grupo()); 
        if(obj!=null) { 
            obj.setNombre_grupo(grupo.getNombre_grupo());
            //Despues de que se actualiza un registro, se graba de la siguiente forma:
            grupoService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    // Etiqueta como recurso para consultar toda la tabla
    @GetMapping("/list") 
    public List<Grupo> consultarTodo(){
        return grupoService.findAll(); 
    }
    // O puedo consultar un solo regitro especificando su Id.
    @GetMapping("/list/{id}") 
    public Grupo consultaPorId(@PathVariable String id){ 
        return grupoService.findById(id); 
    }
    
}
