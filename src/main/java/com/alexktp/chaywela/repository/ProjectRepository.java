package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Project;
import com.alexktp.chaywela.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByName(String name);
    ArrayList<Project> findByUser(User user);

}
