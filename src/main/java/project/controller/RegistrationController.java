package project.controller;

import java.security.Principal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.model.User;
import project.service.RegistrationService;

@Data
@RequiredArgsConstructor
@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/index")
    public ModelAndView index(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("index");
        if(principal != null) {
            modelAndView.addObject("login", principal.getName());
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration(@RequestParam(required = false, name = "admin") boolean admin) {
        ModelAndView modelAndView = new ModelAndView("registration");
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@RequestBody @ModelAttribute("user") User user) {
        registrationService.registration(user);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
