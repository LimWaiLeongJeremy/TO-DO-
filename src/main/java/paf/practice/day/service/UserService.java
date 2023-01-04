package paf.practice.day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.practice.day.model.User;
import paf.practice.day.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User insertUser(
                String username, 
                String password, 
                String email, 
                String date, 
                String string) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDate(date);
        user.setPhone(string);
        System.out.println(user.toString());
        int status = userRepo.insertUser(user);
        user.setStatus(status);

        return user;
    }
    
}

