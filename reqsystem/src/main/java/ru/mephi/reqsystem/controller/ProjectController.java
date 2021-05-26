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
import ru.mephi.reqsystem.service.ProjectsService;
import java.util.Date;
import java.util.List;

/**
 * Контроллер для работы с проектами.
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectsService projectsService;
    private final List<Project> projects;

    @Autowired
    public ProjectController(ProjectsService projectsService) {
        this.projectsService = projectsService;
        this.projects = projectsService.showProjects();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String projects(@RequestParam(required = false, defaultValue = "") String filter,
                               Model model,
                               @AuthenticationPrincipal User user) {

        model.addAttribute("url", "/projects/add");
        model.addAttribute("filter", filter);
        return "projectsAdd";
    }

    @RequestMapping(value = { "/show" }, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("projects", projects);
        System.out.println(projects);

        return "showAllProjects";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addProject")
    public String addProject(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "prjName") String prjName,
            @RequestParam(name = "founder") String founder,
            Model model

    ) {

        Date date = new Date();

        Project project = new Project(prjName, date, founder);

        boolean savingProject = projectsService.addProject(project);
        return "redirect:/projects";
    }

}
