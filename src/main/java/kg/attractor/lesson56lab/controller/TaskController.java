package kg.attractor.lesson56lab.controller;


import kg.attractor.lesson56lab.dto.CreateTaskDTO;
import kg.attractor.lesson56lab.dto.DetailTaskDTO;
import kg.attractor.lesson56lab.dto.GetTaskDTO;
import kg.attractor.lesson56lab.service.TaskService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService ts;

    public TaskController(TaskService ts) {
        this.ts = ts;
    }

    @GetMapping("/name/{name}/all")

    public Iterable<GetTaskDTO> findAll(@ApiIgnore Pageable pageable, @PathVariable("name")String name){
        return ts.getAllTask(pageable,name);
    }

    @PostMapping("/name/{name}")
    public DetailTaskDTO createTask(@RequestBody CreateTaskDTO createTaskDTO, @PathVariable("name")String name){
        return ts.createTask(createTaskDTO,name);
    }

    @GetMapping("/change/id/{id}")
    public DetailTaskDTO changeStatus(@PathVariable("id")String id){
        return ts.changeStatus(id);
    }

    @GetMapping("/id/{id}")
    public DetailTaskDTO getTask(@PathVariable("id")String id){
        return ts.getTask(id);
    }
}
