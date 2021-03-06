package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByName(String name);


}
