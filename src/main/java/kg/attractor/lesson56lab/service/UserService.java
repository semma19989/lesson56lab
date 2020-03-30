package kg.attractor.lesson56lab.service;

import com.lesson56lab.task_manager.dto.UserDTO;
import com.lesson56lab.task_manager.model.User;
import com.lesson56lab.task_manager.repository.UserRepository;
import com.lesson56lab.task_manager.util.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public User getUserByMail(String mail){
        return ur.findUserByMail(mail);
    }

    public UserDTO createUser(UserDTO userDTO){
        User user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .mail(userDTO.getMail())
                .pass(SecurityConfig.encoder().encode(userDTO.getPass()))
                .build();
        ur.save(user);
        return UserDTO.from(user);
    }
}
