package com.alexktp.chaywela.ressource;

import com.alexktp.chaywela.model.Response;
import com.alexktp.chaywela.model.User;
import com.alexktp.chaywela.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRessource {

    private final UserServiceImpl userService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllUsers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", userService.getAll(50)))
                        .message("All users retrieved")
                        .statuscode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", userService.create(user)))
                        .httpStatus(HttpStatus.OK)
                        .message("User saved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<Response> saveUser(@PathVariable("idUser") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", userService.get(id)))
                        .httpStatus(HttpStatus.OK)
                        .message("User retrieved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<Response> deleteUser(@PathVariable("idUser") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", userService.delete(id)))
                        .httpStatus(HttpStatus.OK)
                        .message("User deleted")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }
}
