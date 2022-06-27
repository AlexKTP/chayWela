package com.alexktp.chaywela.ressource;

import com.alexktp.chaywela.model.Project;
import com.alexktp.chaywela.model.Response;
import com.alexktp.chaywela.service.implementation.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectRessouce {

    private final ProjectServiceImpl projectService;

    @GetMapping("/list")
    public ResponseEntity<Response> getProjects(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Projects", projectService.getAll(5)))
                        .httpStatus(HttpStatus.OK)
                        .message("Projects retrieved")
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/project/{idProject}")
    public ResponseEntity<Response> getProject(@PathVariable("idProject") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Response", projectService.get(id)))
                        .httpStatus(HttpStatus.OK)
                        .statuscode(HttpStatus.OK.value())
                        .message("Project retrieved")
                        .build()
        );
    }

    @GetMapping("/save")
    public ResponseEntity<Response> saveProject(@RequestBody @Valid Project project){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Project", projectService.create(project)))
                        .message("Project created")
                        .httpStatus(HttpStatus.CREATED)
                        .statuscode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @PostMapping("/search")
    public ResponseEntity<Response> searchProject(@RequestParam(name = "filter") String request){
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Projets", projectService.search(request)))
                        .message("Projets found")
                        .httpStatus(HttpStatus.OK)
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("project/{idProject}")
    public ResponseEntity<Response> deleteProject(@PathVariable("idProject") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Project", projectService.delete(id)))
                        .message("Project deleted")
                        .httpStatus(HttpStatus.OK)
                        .statuscode(HttpStatus.OK.value())
                        .build()
        );
    }

}
