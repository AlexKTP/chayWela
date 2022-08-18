package com.alexktp.chaywela.service.implementation;

import com.alexktp.chaywela.model.Project;
import com.alexktp.chaywela.repository.ProjectRepository;
import com.alexktp.chaywela.service.ProjetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements ProjetService {

    private final ProjectRepository projectRepo;

    @Override
    public Project create(Project project) {
        log.info("Saving new project:{}", project.getName());
        return projectRepo.save(project);
    }

    @Override
    public Project get(Long id) {
        log.info("Fetching project by id: {}", id);
        return projectRepo.findById(id).get();
    }

    @Override
    public Project update(Project project) {
        log.info("Updating project: {}", project.getName());
        return projectRepo.save(project);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting project: {}", id);
        projectRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Collection<Project> getAll(int limit) {
        log.info("Retrieving all projects");
        Collection<Project> projects = projectRepo.findAll();
        return projects;
    }


    @Override
    public Collection<Project> search(String request) {
        log.info("Fetching projects by request: {}", request);
        Collection result = new ArrayList();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(request);
        boolean isNumberOnly = matcher.find();
        if(isNumberOnly) {
            Long id = Long.parseLong(request);
            result.add(projectRepo.findById(id));
            return result;
        } else {
            result.addAll(projectRepo.findByNameLike(request));
        }

        return result;
    }
}
