package kg.attractor.lesson56lab.model;


import kg.attractor.lesson56lab.state.StateContext;
import kg.attractor.lesson56lab.util.Generator;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Random;

@Document(collection = "tasks")
@Data
@Builder
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime endDate;
    @DBRef
    private User user;
    private StateContext status;

    private static LocalDateTime getDate(){
        Random r = new Random();
        return LocalDateTime.of((2020+r.nextInt(2)),
                (4+r.nextInt(5)),(1+r.nextInt(20)),
                (1+r.nextInt(15)),(r.nextInt(50)));
    }

    public static Task addTask(){
        return builder()
                .title(Generator.makeName())
                .description(Generator.makeDescription())
                .endDate(Task.getDate())
                .status(new StateContext())
                .build();
    }
}
