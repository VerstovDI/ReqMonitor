package ru.mephi.reqsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.service.ProjectsService;
import ru.mephi.reqsystem.service.ReleaseService;
import ru.mephi.reqsystem.service.RequirementService;
import ru.mephi.reqsystem.service.SpecService;

import java.util.List;

/**
 * Основной контроллер, обслуживающий главную страницу приложения.
 */
@Controller
public class MainController {

    // Тут подвязываем требуемые сервисы, репозитории и т.д.

    // пишем методы по типу public String ...(@RequestParam или просто model)
    // Аннотируем методы в зависимости от их назначения. GetMapping/PostMapping/....

    // Начальная приветственная страница

    private final ProjectsService projectsService;
    private final SpecService specService;
    private final ReleaseService releaseService;
    private final RequirementService requirementService;

    @Autowired
    public MainController(ProjectsService projectsService, SpecService specService, ReleaseService releaseService, RequirementService requirementService) {
        this.projectsService = projectsService;
        this.specService = specService;
        this.releaseService = releaseService;
        this.requirementService = requirementService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model,
                       @AuthenticationPrincipal User user) {
        model.addAttribute("something", "Hello, again!");
        model.addAttribute("url", "/main");
        model.addAttribute("filter", filter);
        return "main";
    }

    /**
     * Страница для работы с требованиями
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/requirements")
    public String requirements(  Model model,
                       @AuthenticationPrincipal User user) {
        return "requirements";
    }


    //Страница для работы с проектами
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/projects")
    public String projects(  Model model,
                                 @AuthenticationPrincipal User user) {
        List<Project> projects = projectsService.showProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specs")
    public String specs(  Model model,
                             @AuthenticationPrincipal User user) {
        List<Specification> specifications = specService.showSpecifications();
        model.addAttribute("specs", specifications);
        return "specs";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/releases")
    public String releases(  Model model,
                          @AuthenticationPrincipal User user) {
        List<Release> releases = releaseService.showReleases();
        model.addAttribute("releases", releases);
        return "releases";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin-monitor")
    public String adminMonitor(@AuthenticationPrincipal User user) {
        return "redirect:http://localhost:8080/actuator";
    };


    // Мб основа этой штуки понадобится потом
    /*private void saveFile(Message message, MultipartFile file) throws IOException {
        if (file != null & !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString(); // создаем уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            message.setFileName(resultFileName);
        }
        messageRepo.save(message);
    }*/
}
