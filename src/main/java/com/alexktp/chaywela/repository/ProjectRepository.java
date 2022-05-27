package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Project;
import com.alexktp.chaywela.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
