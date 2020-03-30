package kg.attractor.lesson56lab.controller;


import kg.attractor.lesson56lab.dto.UserDTO;
import kg.attractor.lesson56lab.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return us.createUser(userDTO);
    }
}
