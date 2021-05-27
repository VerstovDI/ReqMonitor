package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.repository.requirements.SpecificationRepository;
import ru.mephi.reqsystem.repository.requirements.ReleaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final SpecificationRepository specificationRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository, SpecificationRepository specificationRepository) {
        this.releaseRepository = releaseRepository;
        this.specificationRepository = specificationRepository;
    }

    public boolean addRelease(Release release) {
        Optional<Specification> specification = specificationRepository.findById(release.getSpecification().getId());
        if (!specification.isPresent()) {
            return false;
        }
        release.setSpecification(specification.get());
        Release releaseFromDb = releaseRepository.findByVersionAndSpecification(release.getVersion(), release.getSpecification());
        if (releaseFromDb != null) {
            return false;
        }
        releaseRepository.save(release);
        return true;
    }

    public List<Release> showReleases() {
        return releaseRepository.findAll();
    }

    public List<Release> showReleasesForSpec(Specification specification) {
        return releaseRepository.findBySpecification(specification);
    }
}
