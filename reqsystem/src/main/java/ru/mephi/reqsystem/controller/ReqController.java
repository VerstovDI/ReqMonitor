package ru.mephi.reqsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mephi.reqsystem.domain.administration.Role;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.service.RequirementService;
import ru.mephi.reqsystem.service.UserService;

/**
 * Контроллер для работы с требованиями.
 */
@Controller
@RequestMapping("/requirements")
public class ReqController {
    private final RequirementService requirementService;

    @Autowired
    public ReqController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }
    // Тут подвязываем требуемые сервисы, репозитории и т.д.

    // пишем методы по типу public String ...(@RequestParam или просто model)
    // Аннотируем методы в зависимости от их назначения. GetMapping/PostMapping/....

    //Страница для работы с требованиями
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String requirements(@RequestParam(required = false, defaultValue = "") String filter,
                               Model model,
                               @AuthenticationPrincipal User user) {
        model.addAttribute("url", "/requirements/add");
        model.addAttribute("filter", filter);
        return "requirementsAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PostMapping("/add")
    public String addRequirement (
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String art_type,
            @RequestParam String description
    ) {
        //userService.updateProfile(user, password);
        return "redirect:/requirements";
    }

}
