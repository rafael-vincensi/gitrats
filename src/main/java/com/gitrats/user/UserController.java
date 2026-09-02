package com.gitrats.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User findUserId(@RequestParam UUID id){
        return userService.findUserId(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody UUID id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam UUID id){
        userService.deleteUser(id);
    }
}
