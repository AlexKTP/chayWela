package com.alexktp.chaywela.model;

import com.alexktp.chaywela.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "A task must have a description")
    String description;

    LocalDateTime startTime;
    LocalDateTime finishTime;

    Status status;

    Long duration;

    Integer difficulty;
    Integer progress;

    Long estimatedTime;

    @NotEmpty(message = "A task is related to a project")
    Long refProject;

}
