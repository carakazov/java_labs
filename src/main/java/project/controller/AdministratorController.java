package project.controller;

import java.security.Principal;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.model.User;
import project.service.UserService;

@RestController
@RequestMapping("/admin")
@Data
@Accessors(chain = true)
public class AdministratorController {
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView list(Principal principal) {
        List<User> users = userService.getAll();
        users.removeIf(item -> item.getLogin().equals(principal.getName()));
        return new ModelAndView("userList").addObject("list", users);
    }

    @GetMapping("/delete/{login}")
    public ModelAndView delete(@PathVariable(name = "login") String login) {
        userService.delete(login);
        return new ModelAndView("redirect:/admin/list");
    }
}
