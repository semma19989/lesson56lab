package kg.attractor.lesson56lab.repository;

import kg.attractor.lesson56lab.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findUserByName(String name);
    User findUserByMail(String mail);
}
