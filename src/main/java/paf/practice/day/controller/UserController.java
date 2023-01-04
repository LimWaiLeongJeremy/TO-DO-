package paf.practice.day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import paf.practice.day.model.User;
import paf.practice.day.service.UserService;

@Controller
@RequestMapping (path = "/user")
public class UserController {
    @Autowired
    private UserService userSrv;

    @PostMapping
    public String register(Model model, @RequestBody MultiValueMap<String, String> form) {

        User user = userSrv.insertUser(
                        form.getFirst("username"), 
                        form.getFirst("password"), 
                        form.getFirst("email"), 
                        form.getFirst("dob"), 
                        form.getFirst("phone"));
        

        if (user.getStatus() == 0) {
            System.out.println("Error, cannot create user");
            return "error";
        }
        
        model.addAttribute("username", user.getUsername());

        return "created";
    }
}
