package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.repository.requirements.ProjectRepository;
import ru.mephi.reqsystem.repository.requirements.SpecificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpecService {

    private final SpecificationRepository specificationRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public SpecService(SpecificationRepository specificationRepository, ProjectRepository projectRepository) {
        this.specificationRepository = specificationRepository;
        this.projectRepository = projectRepository;
    }

    public boolean addSpec(Specification spec) {
        Optional<Project> project = projectRepository.findById(spec.getProject().getId());
        if (!project.isPresent()) {
            return false;
        }
        spec.setProject(project.get());
        Specification specFromDb = specificationRepository.findByVersionAndProject(spec.getVersion(), spec.getProject());
        if (specFromDb != null) {
            return false;
        }
        specificationRepository.save(spec);
        return true;
    }

    public List<Specification> showSpecifications() {
        return specificationRepository.findAll();
    }
}
