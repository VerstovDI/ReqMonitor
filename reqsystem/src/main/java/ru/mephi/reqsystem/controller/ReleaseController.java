package ru.mephi.reqsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.service.ReleaseService;
import ru.mephi.reqsystem.service.RequirementService;
import ru.mephi.reqsystem.service.SpecService;

import java.util.List;

/**
 * Контроллер для работы с релизами.
 */
@Controller
@RequestMapping("/releases")
public class ReleaseController {

    private final ReleaseService releaseService;
    private List<Release> releases;
    private Specification specification;

    private final RequirementService requirementService;
    private List<Requirement> requirements;

    @Autowired
    public ReleaseController(ReleaseService releaseService, RequirementService requirementService) {
        this.releaseService = releaseService;
        this.releases = releaseService.showReleases();
        this.requirementService = requirementService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add/{spec}")
    public String releases(@PathVariable Specification spec,
                           Model model,
                           @AuthenticationPrincipal User user) {

        specification = spec;
        return "releaseAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addRelease")
    public String addRelease(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "version") Integer version,
            @RequestParam(name = "description") String description,
            Model model
    ) {
        Release release = new Release(version, description, specification);
        boolean savingSpecStatus = releaseService.addRelease(release);
        return "redirect:/specs/showParticularSpec/" + specification.getId();
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/showParticularRelease/{release}")
    public String showParticularSpec (
            @AuthenticationPrincipal User user,
            @PathVariable Release release,
            Model model
    ) {

        requirements = requirementService.showReqForRelease(release);
        model.addAttribute("requirements", requirements);
        model.addAttribute("spec", release.getSpecification());
        return "showParticularRelease";
    }
}
