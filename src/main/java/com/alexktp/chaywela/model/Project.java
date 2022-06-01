package com.alexktp.chaywela.model;

import com.alexktp.chaywela.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    Long id;

    @Column(unique = true)
    @NotEmpty(message = "A project must have a name")
    String name;

    String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "project_type")
    ProjectType projectType;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

}
