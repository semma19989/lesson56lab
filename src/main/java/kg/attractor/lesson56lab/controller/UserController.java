package kg.attractor.lesson56lab.controller;

import com.lesson56lab.task_manager.dto.UserDTO;
import com.lesson56lab.task_manager.service.UserService;
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
