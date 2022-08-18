package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("SELECT p FROM Project p WHERE p.name LIKE CONCAT('%',:name,'%') OR p.description LIKE CONCAT('%',:name,'%') ")
    List<Project> findProjectsByRequest(@Param("name") String name);


}
