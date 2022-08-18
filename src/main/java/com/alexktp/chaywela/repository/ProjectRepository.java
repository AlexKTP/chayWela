package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("select p from Project p where p.name like '%name%' OR p.description like '%name%'")
    List<Project> findByNameLike(@Param("name") String name);


}
