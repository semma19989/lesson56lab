package kg.attractor.lesson56lab.service;

import com.lesson56lab.task_manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserService us;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user  = Optional.ofNullable(us.getUserByMail(s));
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return user.get();
    }
}
