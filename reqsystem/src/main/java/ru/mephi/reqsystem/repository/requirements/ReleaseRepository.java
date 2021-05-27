package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Specification;

import java.util.List;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
    Release findByVersionAndSpecification(Integer version, Specification specification);
    List<Release> findBySpecification(Specification specification);
}
