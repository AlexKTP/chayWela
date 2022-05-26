package com.alexktp.chaywela.service;

import com.alexktp.chaywela.model.Task;

import java.util.Collection;

public interface TaskService {

    Task create(Task task);
    Task get(Long id);
    Task update(Task task);
    Boolean delete(Long id);
    Collection<Task> getAll(int limit);

}
