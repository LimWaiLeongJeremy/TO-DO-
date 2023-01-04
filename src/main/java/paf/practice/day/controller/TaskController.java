package paf.practice.day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import paf.practice.day.service.TaskService;

@Controller
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskService taskSrv;

    @PostMapping
    public String task(@RequestBody MultiValueMap<String, String> form, Model model) {

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String task = form.getFirst("task");
        String priority = form.getFirst("priority");
        String completeBy = form.getFirst("completeBy");
        String assignTo = form.getFirst("username");
        
        if (!taskSrv.insertTask(username, password, task, priority, completeBy, assignTo)) {
            System.out.println("Authentication failed");
            return "auth_fail";
        }
        
        model.addAttribute("task", task);
        model.addAttribute("priority", priority);
        model.addAttribute("completeBy", completeBy);
        
        return "task_created";
    }
    
}
