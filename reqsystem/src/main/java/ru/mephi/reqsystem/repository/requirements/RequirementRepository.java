package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Requirement;

import javax.management.relation.Relation;
import java.util.List;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    Requirement findByTitle(String title);
    Requirement findByTitleAndDescriptionAndRelease(String title, String description, Release release);
    List<Requirement> findByRelease(Release release);
}
