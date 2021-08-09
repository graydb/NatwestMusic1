package com.project.mymusic.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.mymusic.model.User;
import com.project.mymusic.service.UserService;
@Controller
@RequestMapping("/users")
public class UserController {
@Autowired
 private UserService userService;
@GetMapping
 public String index(Model model) {
List<User> users = userService.searchAll();
model.addAttribute("users", users);
return "user/index";
 }
@GetMapping("/addUser")
 public String add(User user, Model model) {
this.userService.create(user);
return "user/addUser";
 }
@GetMapping("/editUser/{id}")
 public String edit(@PathVariable("id") Long id, Model model) {
User user = this.userService.searchById(id);
 model.addAttribute("user", user);
 return "user/editUser";
 }
@GetMapping("/deleteUser/{id}")
 public String delete(@PathVariable("id") Long id, Model model) {
this.userService.delete(id);
return index(model);
 }
@PostMapping("/saveUser")
 public String save(@Valid User user, BindingResult result, Model model) {
if (result.hasErrors()) {
 return add(user, model);
 }
if (user.getId() != 0) {
this.userService.update(user);
 } else {
this.userService.create(user);
 }
return index(model);
 }
}
