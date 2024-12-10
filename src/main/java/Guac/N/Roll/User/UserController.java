package Guac.N.Roll.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        User user = userService.authenticate(email, password);
        if (user != null) {
            // Check if the user is suspended
            if (user.isSuspended()) {
                model.addAttribute("error", "Your account is currently suspended. Please contact support.");
                return "login";
            }

            // Check if the user is banned
            if (user.isBanned()) {
                model.addAttribute("error", "Your account has been banned. Please contact support.");
                return "login";
            }


            session.setAttribute("loggedInUser", user);

            if ("admin@gmail.com".equalsIgnoreCase(email)) {
                return "redirect:/admin/home";
            } else if ("provider@gmail.com".equalsIgnoreCase(email)) {
                return "redirect:/provider/home";
            } else if ("distributor@gmail.com".equalsIgnoreCase(email)) {
                return "redirect:/distributor/home";
            } else {
                return "redirect:/user/home";
            }
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }


    @GetMapping("/home")
    public String showUserHomePage(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/user/login";
        }

        model.addAttribute("user", loggedInUser);
        return "home";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}
