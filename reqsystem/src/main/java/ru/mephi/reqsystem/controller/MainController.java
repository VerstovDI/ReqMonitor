package ru.mephi.reqsystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mephi.reqsystem.domain.administration.User;

/**
 * Основной контроллер, обслуживающий главную страницу приложения.
 */
@Controller
public class MainController {

    // Тут подвязываем требуемые сервисы, репозитории и т.д.

    // пишем методы по типу public String ...(@RequestParam или просто model)
    // Аннотируем методы в зависимости от их назначения. GetMapping/PostMapping/....

    // Начальная приветственная страница
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
        return "projects";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specs")
    public String specs(  Model model,
                             @AuthenticationPrincipal User user) {
        return "specs";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/releases")
    public String releases(  Model model,
                          @AuthenticationPrincipal User user) {
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
