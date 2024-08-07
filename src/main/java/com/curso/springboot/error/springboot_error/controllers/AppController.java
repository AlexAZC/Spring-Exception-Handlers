package com.curso.springboot.error.springboot_error.controllers;


import com.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.curso.springboot.error.springboot_error.models.domain.User;
import com.curso.springboot.error.springboot_error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;


    @GetMapping
    public String index(){
        int value = Integer.parseInt("10x");
        return "ok 200";
    }

//    @GetMapping("/show/{id}")
//    public ResponseEntity show(@PathVariable (name = "id") Long id){
//       //User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error en el usuario no existe!"));
//        Optional<User> optionalUser = service.findById(id);
//        if(optionalUser.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//       return ResponseEntity.ok(optionalUser.get());
//    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable (name = "id") Long id){
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error en el usuario no existe!"));

        return user;
    }

}