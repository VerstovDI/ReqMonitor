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

    @Autowired
    public SpecController(SpecService specService, ReleaseService releaseService) {
        this.specService = specService;
        this.specs = specService.showSpecifications();
        this.releaseService = releaseService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String specifications(@RequestParam(required = false, defaultValue = "") String filter,
                               Model model,
                               @AuthenticationPrincipal User user) {

        model.addAttribute("url", "/specs/add");
        model.addAttribute("filter", filter);
        return "specAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addSpec")
    public String addRequirement(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "version") Integer version,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "prjId") Long prjId,
            Model model

    ) {
        Project project = new Project();
        project.setId(prjId);
        Specification specification = new Specification(version, description, project);
        boolean savingSpecStatus = specService.addSpec(specification);
        return "redirect:/specs";
    }

    @RequestMapping(value = { "/show" }, method = RequestMethod.GET)
    public String specsList(Model model) {

        specs = specService.showSpecifications();
        model.addAttribute("specs", specs);

        return "showAllSpecs";
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
        return "showParticularSpec";
    }

}
