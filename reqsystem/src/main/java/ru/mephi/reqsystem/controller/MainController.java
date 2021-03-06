package ru.mephi.reqsystem.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.mephi.reqsystem.domain.User;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

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

    /*@PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageble) throws IOException {
        message.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            saveFile(message, file);
        }

        model.addAttribute("message", null);
        Page<MessageDto> page = messageRepo.findAll(pageble, user);
        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
        Iterable<Message> messageRepoAll = messageRepo.findAll();
        model.addAttribute("messages", messageRepoAll);
        return "main";
    }*/

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
