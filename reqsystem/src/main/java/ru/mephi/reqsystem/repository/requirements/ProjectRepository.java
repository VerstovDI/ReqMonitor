package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
}
