package com.tuyennguyen.supeo.forum.controller;

import com.tuyennguyen.supeo.forum.entity.User;
import com.tuyennguyen.supeo.forum.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/user");

        try {
            // set title
            model.addAttribute("title", "Danh Sách User");
            // set page
            model.addAttribute("page", "user");

            //set list
            List<User> listUser = userService.findAll();
            model.addAttribute("listUser", listUser);
        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @GetMapping("/user/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/user/them");

        try {
            // set title
            model.addAttribute("title", "User Thêm");
            // set page
            model.addAttribute("page", "user-edit");
        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/user/edit/" + id);

        try {
            // set title
            model.addAttribute("title", "User Edit");
            // set page
            model.addAttribute("page", "user-edit");

            User obj = userService.findById(id).get();
            model.addAttribute("user", obj);

        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @PostMapping("/user/update")
    public RedirectView update(@ModelAttribute("obj") User obj, Model model) {
        // log info
        log.debug("Go to: /admin/user/update/" + obj.getUserId());

        try {
            // set title
            model.addAttribute("title", "Danh Sách User");
            // set page
            model.addAttribute("page", "user");

            // save obj
            userService.save(obj);

            //set list
            List<User> listUser = userService.findAll();
            model.addAttribute("listUser", listUser);
        } catch (Exception e) {

        }

        return new RedirectView("/admin/user");
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/user/delelte/" + id);

        try {
            // set title
            model.addAttribute("title", "Danh Sách User");
            // set page
            model.addAttribute("page", "user");

            // delete obj
            userService.deleteById(id);

            //set list
            List<User> listUser = userService.findAll();
            model.addAttribute("listUser", listUser);
        } catch (Exception e) {

        }

        return "admin/admin";
    }

}
