package com.alexktp.chaywela.model;

import com.alexktp.chaywela.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @NotEmpty(message = "A task must have a title")
    String title;

    String description;

    LocalDateTime startTime;
    LocalDateTime finishTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    Status status;

    Long duration;

    Integer difficulty;
    Integer progress;

    Long estimatedTime;

    @OneToOne
    @JoinColumn(name = "project_id")
    Project project;

}
