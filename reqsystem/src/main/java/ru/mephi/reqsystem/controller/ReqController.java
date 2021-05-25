package ru.mephi.reqsystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.*;
import ru.mephi.reqsystem.repository.requirements.*;
import ru.mephi.reqsystem.service.RequirementService;

import java.sql.Time;
import java.util.Date;

/**
 * Контроллер для работы с требованиями.
 */
@Controller
@RequestMapping("/requirements")
public class ReqController {
    private final RequirementService requirementService;
    private final ReleaseRepository releaseRepository;
    private final SpecificationRepository specificationRepository;
    private final RequirementVerificationRepository requirementVerificationRepository;
    private final RequirementPriorityRepository requirementPriorityRepository;
    private final RequirementStatusRepository requirementStatusRepository;
    Logger logger = LogManager.getLogger(ReqController.class);

    @Autowired
    public ReqController(RequirementService requirementService, ReleaseRepository releaseRepository
            , SpecificationRepository specificationRepository, RequirementVerificationRepository requirementVerificationRepository, RequirementPriorityRepository requirementPriorityRepository, RequirementStatusRepository requirementStatusRepository) {
        this.requirementService = requirementService;
        this.releaseRepository = releaseRepository;
        this.specificationRepository = specificationRepository;
        this.requirementVerificationRepository = requirementVerificationRepository;
        this.requirementPriorityRepository = requirementPriorityRepository;
        this.requirementStatusRepository = requirementStatusRepository;
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
        model.addAttribute("releases",releaseRepository.findAll());
        model.addAttribute("url", "/requirements/add");
        model.addAttribute("filter", filter);
        return "requirementsAdd";
    }

    //TODO смотреть login /RegistrtionContoller
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addReq")
    public String addRequirement(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "artType") String artType,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "loc") String loc,
            @RequestParam(name = "origin")  String origin,
            @RequestParam(name = "limitTime") String limitTimeString,
            @RequestParam(name = "selectedRelease") Release release,
            Model model

    ) {
        String[] splitTime = limitTimeString.split(":");
        Time limitTime = new Time(Integer.parseInt(splitTime[0]),Integer.parseInt(splitTime[1]),0);
    Date date=new Date();
        RequirementVerification requirementVerification = requirementVerificationRepository
                .findById(1l).get();
        RequirementPriority requirementPriority =requirementPriorityRepository.findById(1l).get();
        RequirementStatus requirementStatus=requirementStatusRepository.findById(1l).get();
        boolean savingStatus = requirementService.addRequirement(new Requirement(title, artType, description, limitTime, loc, origin
                , date, release, requirementVerification, requirementPriority, requirementStatus));
        return "redirect:/requirements";
    }


    /*    @PreAuthorize("isAuthenticated()")    TODO не распознает маппинг
    @PostMapping("/addReq")
    public String addRequirement (
            @AuthenticationPrincipal User user

    ) {
        logger.info("I get post request ");
        //userService.updateProfile(user, password);
        return "redirect:/";
    }
         */
}
