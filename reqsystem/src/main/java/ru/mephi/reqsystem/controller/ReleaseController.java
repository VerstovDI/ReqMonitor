package ru.mephi.reqsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.service.ReleaseService;
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

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
        this.releases = releaseService.showReleases();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String releases(@RequestParam(required = false, defaultValue = "") String filter,
                                 Model model,
                                 @AuthenticationPrincipal User user) {

        model.addAttribute("url", "/releases/add");
        model.addAttribute("filter", filter);
        return "releaseAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addRelease")
    public String addRequirement(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "version") Integer version,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "specId") Long specId,
            Model model

    ) {
        Specification specification = new Specification();
        specification.setId(specId);
        Release release = new Release(version, description, specification);
        boolean savingSpecStatus = releaseService.addRelease(release);
        return "redirect:/releases";
    }

    @RequestMapping(value = { "/show" }, method = RequestMethod.GET)
    public String releasesList(Model model) {

        releases = releaseService.showReleases();
        model.addAttribute("releases", releases);

        return "showAllReleases";
    }
}
