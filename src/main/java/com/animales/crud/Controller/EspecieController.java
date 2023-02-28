package com.animales.crud.Controller;
//Importo el modelo
import com.animales.crud.Models.Especie;
//Importo el DAO (Repositorio)
import com.animales.crud.Dao.EspecieDao;
//Importo el Servicio
import com.animales.crud.Service.EspecieService;
// Libreria para usar una lista y almacenar información
import java.util.List;

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

/*Anotación para iniciar con la definición del API REST, en adelante se usan los recursos
que ofrece Spring Boot.*/ 
@RestController
/*Anotación que me permite definir el protocolo de interacción entre navegador y servidor*/
@CrossOrigin("*")
// Anotación que me permite definir la ubicación del API REST.
@RequestMapping("/especie")
public class EspecieController {
    
    @Autowired
    private EspecieDao especieDao;

    @Autowired
    private EspecieService especieService;
    
    //Anotacion usada para crear un nuevo registro
    @PostMapping(value="/")
    public ResponseEntity<Especie> agregar(@RequestBody Especie especie){        
        Especie obj = especieService.save(especie);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Especie> eliminar(@PathVariable String id){ 
        Especie obj = especieService.findById(id); 
        if(obj!=null) 
            especieService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Especie> editar(@RequestBody Especie especie){ 
        Especie obj = especieService.findById(especie.getId_especie()); 
        if(obj!=null) {
            
            especieService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<Especie> consultarTodo(){
        return especieService.findAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Especie consultaPorId(@PathVariable String id){ 
        return especieService.findById(id); 
    }
}
