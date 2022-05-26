package com.alexktp.chaywela.service;

import com.alexktp.chaywela.model.Project;

import java.util.Collection;

public interface ProjetService {

    Project create(Project project);
    Project get(Long id);
    Project update(Project project);
    Boolean delete(Long id);
    Collection<Project> getAll(int limit);

}
