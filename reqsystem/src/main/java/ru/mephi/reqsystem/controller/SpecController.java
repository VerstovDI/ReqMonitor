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
import ru.mephi.reqsystem.domain.requirements.*;
import ru.mephi.reqsystem.service.SpecService;
import java.util.List;

/**
 * Контроллер для работы со спецификациями.
 */
@Controller
@RequestMapping("/specs")
public class SpecController {

    private final SpecService specService;
    private List<Specification> specs;

    @Autowired
    public SpecController(SpecService specService) {
        this.specService = specService;
        this.specs = specService.showSpecifications();
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

}
