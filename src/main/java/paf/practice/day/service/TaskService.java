package paf.practice.day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import paf.practice.day.model.Task;
import paf.practice.day.model.User;
import paf.practice.day.repository.TaskRepository;
import paf.practice.day.repository.UserRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private UserRepository userRepo;

    public boolean insertTask(
            String username, 
            String password, 
            String task, 
            String priority, 
            String completeBy, 
            String assignTo) {

        User user = new User();
        Task t = new Task();

        user.setUsername(username);
        user.setPassword(password);
        t.setTask(task);
        t.setPriority(priority);
        t.setCompleteBy(completeBy);
        t.setAssignTo(assignTo);
       
        if (authenticate(user)) {
            taskRepo.insertTask(t);
            return true;
        }else {
            return false;
        }

    }

    private Boolean authenticate (User user) {
        SqlRowSet rs = userRepo.authenticate(user);
        if (rs.next()) {
            return rs.getBoolean("auth_state");
        }
        return false;
    }
}
