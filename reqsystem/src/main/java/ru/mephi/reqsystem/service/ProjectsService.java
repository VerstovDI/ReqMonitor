package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.repository.requirements.ProjectRepository;

@Service
public class ProjectsService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectsService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean addProject(Project project) {
        Project projectFromDb = projectRepository.findByName(project.getName());
        if (projectFromDb != null) {
            return false;
        }
        projectRepository.save(project);
        return true;
    }
}
