package com.callcenter.controllers;


import com.callcenter.Domain.Record;
import com.callcenter.Domain.User;
import com.callcenter.Service.RecordService;
import com.callcenter.Service.UserService;
import com.callcenter.util.EncriptarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    EncriptarPassword encriptar_password;



    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user,  @RequestParam("contrasena") String contrasena) {
        encriptarPassword(user, contrasena);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteUser(@PathVariable("id") int iduser){
        var user = userService.findUserById(String.valueOf(iduser));

        if (user != null) {
            userService.delete(user);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int iduser){

        var user = userService.findUserById(String.valueOf(iduser));
        if (user != null) {

            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


    void encriptarPassword(User user, String contraseña) {
        if (user.getPassword() != null) {
            if ((user.getPassword().isEmpty()
                    && user.getPassword().isBlank()) && (!contraseña.isEmpty()
                    && !contraseña.equals(""))) {

                user.setPassword(
                        encriptar_password.encriptarPassword(contraseña));

            } else if ((!user.getPassword().isEmpty()
                    && !user.getPassword().isBlank()) && (!contraseña.isEmpty()
                    && !contraseña.equals(""))) {
                user.setPassword(
                        encriptar_password.encriptarPassword(contraseña));
            }
        }
    }





}
