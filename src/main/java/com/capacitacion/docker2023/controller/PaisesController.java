package com.capacitacion.docker2023.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capacitacion.docker2023.entity.PaisEntity;
import com.capacitacion.docker2023.service.PaisesService;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    PaisesService paisesService;
    
    /**
     * Retorna una lista con todos los paises
     * 
     * @author Jorge Rojas
     * @return responseEntity
     */
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPaises(){
        return new ResponseEntity<>(paisesService.getPaises(), HttpStatus.valueOf(200));
    }

    /**
     * Retorna un pais especifico de acuerdo al id
     * 
     * @author Jorge Rojas
     * @return responseEntity
     */
    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPaisesPorId(@PathVariable Long id){
        return new ResponseEntity<>(paisesService.getPaisesPorId(id), HttpStatus.valueOf(200));
    }

    /**
     * Inserta un nuevo pais
     * 
     * @author Jorge Rojas
     * @return responseEntity
     */
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearPais(@RequestBody PaisEntity paisEntity){
        return new ResponseEntity<>(paisesService.crearPais(paisEntity), HttpStatus.valueOf(200));
    }

    /**
     * Actualiza un pais
     * 
     * @author Jorge Rojas
     * @return responseEntity
     */
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarPais(@RequestBody PaisEntity paisEntity){
        return new ResponseEntity<>(paisesService.actualizarPais(paisEntity), HttpStatus.valueOf(200));
    }

    /**
     * Elimina un pais
     * 
     * @author Jorge Rojas
     * @return responseEntity
     */
    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarPais(@RequestParam Long id){
        return new ResponseEntity<>(paisesService.eliminarPais(id), HttpStatus.valueOf(200));
    }
    

}
