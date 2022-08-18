package com.alexktp.chaywela.ressource;

import com.alexktp.chaywela.model.Response;
import com.alexktp.chaywela.model.Task;
import com.alexktp.chaywela.service.implementation.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskRessource {

    private final TaskServiceImpl taskService;

    @GetMapping("/list")
    public ResponseEntity<Response> getTasks(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", taskService.getAll(50)))
                        .httpStatus(HttpStatus.OK)
                        .message("Tasks retrieved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTask(@Valid @RequestBody Task task){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", taskService.create(task)))
                        .httpStatus(HttpStatus.OK)
                        .message("task saved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/task/{idTask}")
    public ResponseEntity<Response> getTask(@PathVariable("idTask") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", taskService.get(id)))
                        .httpStatus(HttpStatus.OK)
                        .message("Tasks retrieved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{idTask}")
    public ResponseEntity<Response> deleteTask(@PathVariable("idTask")Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("objList", taskService.delete(id)))
                        .httpStatus(HttpStatus.OK)
                        .message("Tasks deleted")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }
}
