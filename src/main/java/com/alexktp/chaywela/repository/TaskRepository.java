package com.alexktp.chaywela.repository;

import com.alexktp.chaywela.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
