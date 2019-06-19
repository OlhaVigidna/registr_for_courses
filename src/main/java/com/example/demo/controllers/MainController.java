package com.example.demo.controllers;

import com.example.demo.dao.ApplicationDAO;
import com.example.demo.dao.UserDao;
import com.example.demo.models.Application;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * Created by okten28 on 6/19/19.
 */

@Controller
@AllArgsConstructor
public class MainController {

    private DateCustomerEditor dateCustomerEditor;
    private ApplicationDAO applicationDAO;
    private UserDao userDao;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/saveApplication")
    public String save(User user, Application application){
        userDao.save(user);
//        System.out.println(user);
        application.setUser(user);
        applicationDAO.save(application);
        System.out.println(user);
        System.out.println(application);

        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, dateCustomerEditor);
        System.out.println("!!!!!");
    }
}
