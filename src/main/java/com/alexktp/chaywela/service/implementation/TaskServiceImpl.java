package com.alexktp.chaywela.service.implementation;

import com.alexktp.chaywela.model.Task;
import com.alexktp.chaywela.repository.TaskRepository;
import com.alexktp.chaywela.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;

    @Override
    public Task create(Task task) {
        log.info("Creating a task: {}", task.getId());
        return taskRepo.save(task);
    }

    @Override
    public Task get(Long id) {
        log.info("Fetching a task by ID: {}", id);
        return taskRepo.findById(id).get();
    }

    @Override
    public Task update(Task task) {
        log.info("Updating a task: {}", task.getId());
        return taskRepo.save(task);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting a task by ID: {}", id);
        taskRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Collection<Task> getAll(int limit) {
        log.info("Fetching all tasks");
        return taskRepo.findAll();
    }
}
