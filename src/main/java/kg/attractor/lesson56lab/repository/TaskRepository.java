package kg.attractor.lesson56lab.repository;


import kg.attractor.lesson56lab.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface TaskRepository extends PagingAndSortingRepository<Task,String> {
    Task findTaskById(String id);
}
