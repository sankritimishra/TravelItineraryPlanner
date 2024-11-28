package org.example.Controllers;

import org.example.DTOs.UserDetailsDTO;
import org.example.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/info/{userId}")
    public UserDetailsDTO getUserDetailsByUserId(@PathVariable("userId") Long userId){
        return userService.userDetails(userId);
    }
    @PostMapping("/user/addUserDetails")
    public void addUserDetails(@RequestBody UserDetailsDTO body){
        userService.addDetails(body);
    }
    @PostMapping("/user/updateDetails/{userId}")
    public void updateUserDetails(@PathVariable("userId") Long userId, @RequestBody UserDetailsDTO body){
        userService.updateDetails(userId, body);
    }

    @DeleteMapping("/user/deleteInfo/{userId}")
    public void deleteUserDetails(@PathVariable("userId") Long userId){
        userService.deleteDetails(userId);
    }
}
