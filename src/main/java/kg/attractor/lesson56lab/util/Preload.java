package kg.attractor.lesson56lab.util;

import com.lesson56lab.task_manager.model.Task;
import com.lesson56lab.task_manager.model.User;
import com.lesson56lab.task_manager.repository.TaskRepository;
import com.lesson56lab.task_manager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Preload {
    Random r = new Random();

    @Bean
    CommandLineRunner initDatabase(TaskRepository tr, UserRepository ur){

        return(args) -> {
            tr.deleteAll();
            ur.deleteAll();

            User user = User.addUser();
            user.setName("admin");
            user.setMail("admin");
            user.setPassword("admin");
            ur.save(user);

            List<User> users = Stream.generate(User::addUser)
                    .limit(20)
                    .collect(Collectors.toList());
            ur.saveAll(users);

            List<Task>tasks = Stream.generate(Task::addTask)
                    .limit(100)
                    .collect(Collectors.toList());

            for (Task task:tasks){
                task.setUser(users.get(r.nextInt(20)));}

            tr.saveAll(tasks);

            System.out.println("done");
        };
    }


}
