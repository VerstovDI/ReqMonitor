package ru.mephi.reqsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.*;
import ru.mephi.reqsystem.repository.requirements.ReleaseRepository;
import ru.mephi.reqsystem.service.ReleaseService;
import ru.mephi.reqsystem.service.SpecService;
import java.util.List;

/**
 * Контроллер для работы со спецификациями.
 */
@Controller
@RequestMapping("/specs")
public class SpecController {

    private final SpecService specService;
    private final ReleaseService releaseService;
    private List<Specification> specs;
    private List<Release> releases;
    private Project project;

    @Autowired
    public SpecController(SpecService specService, ReleaseService releaseService) {
        this.specService = specService;
        this.specs = specService.showSpecifications();
        this.releaseService = releaseService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add/{project}")
    public String specifications(@PathVariable Project project,
                               Model model,
                               @AuthenticationPrincipal User user) {
        this.project = project;
        return "specAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addSpec")
    public String addRequirement(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "version") Integer version,
            @RequestParam(name = "description") String description,
            Model model

    ) {
        Specification specification = new Specification(version, description, project);
        boolean savingSpecStatus = specService.addSpec(specification);
        return "redirect:/projects/showParticularProject/" + project.getId();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/showParticularSpec/{spec}")
    public String showParticularSpec (
            @AuthenticationPrincipal User user,
            @PathVariable Specification spec,
            Model model
    ) {

        releases = releaseService.showReleasesForSpec(spec);
        model.addAttribute("releases", releases);
        model.addAttribute("project", spec.getProject());
        return "showParticularSpec";
    }

}
