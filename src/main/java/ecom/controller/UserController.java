package ecom.controller;

import ecom.domain.ChangePassword;
import ecom.domain.ForgotPassword;
import ecom.domain.SignIn;
import ecom.domain.User;
import ecom.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(BookController.class.getName());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        //Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("users", userService.list());
        //model.addAttribute("loggedInUser", loggedInUser);
        return "user/list";
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("sign-up", new User());
        return "user/sign-up";
    }

    @RequestMapping("/store-up")
    public String storeSignUp(@Valid @ModelAttribute("sign-up") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/sign-up";
        }
        else if (userService.checkUser(user)) {
            return "user/sign-up";
        }
        else {
            user.setCreatedOn(LocalDate.now());
            userService.create(user);
            return "redirect:/users/sign-in";
        }
    }

    @RequestMapping("/portal")
    public String portal(Model model) {
        return "portal/welcome";
    }

    @RequestMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user-in", new SignIn());
        return "user/sign-in";
    }

    @RequestMapping("/store-in")
    public String storeSignIn(@Valid @ModelAttribute("user-in") SignIn signIn, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/sign-in";
        }
        else if(!userService.logIn((signIn))) {
            return "user/sign-in";
        }
        else {
            return "redirect:/users/portal";
        }
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam("userId") Long userId, Model model) throws SQLException {
        model.addAttribute("user", userService.userGet(userId));

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing UserService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing UserRepository");

        //logger.debug("Debug." + userId);
        logger.info("Info." + userId);
        logger.warning("Warning" + "studentId must be long type");

        return "user/edit";
    }

    @RequestMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        else {
            user.setCreatedOn(LocalDate.now());
            userService.update(user);
            return "redirect:/users/list";
        }
    }

    @RequestMapping("/sign-out")
    public String signOut(Model model) {
        return "redirect:/users/sign-in";
    }

    @RequestMapping("/forgot-password")
    public String forgotPassword(Model model) {
        model.addAttribute("forgot-password", new ForgotPassword());
        return "user/forgot-password";
    }

    @RequestMapping("/store-forgotPassword")
    public String storeForgotPassword(@Valid @ModelAttribute("forgot-password") ForgotPassword forgotPassword, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/forgot-password";
        }
        else if(!userService.searchUserForForgotPassword((forgotPassword))) {
            logger.warning("Warning" + "Maybe return false");
            return "user/forgot-password";
        }
        else {
            userService.updatePasswordForForgotPassword(forgotPassword);
            return "redirect:/users/sign-in";
        }
    }

    @RequestMapping("/change-password")
    public String changePassword(Model model) {
        model.addAttribute("change-password", new ChangePassword());
        return "user/change-password";
    }

    @RequestMapping("/store-changePassword")
    public String storeChangePassword(@Valid @ModelAttribute("change-password") ChangePassword changePassword, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/change-password";
        }
        else if(!userService.searchUserForChangePassword((changePassword))) {
            return "user/change-password";
        }
        else {
            userService.updatePasswordForChangePassword(changePassword);
            return "redirect:/users/sign-in";
        }
    }
}
