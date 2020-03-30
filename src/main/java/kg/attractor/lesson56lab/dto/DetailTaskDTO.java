package kg.attractor.lesson56lab.dto;


import kg.attractor.lesson56lab.model.Task;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DetailTaskDTO {
    private String id;
    private String title;
    private String description;
    private LocalDateTime endDate;
    private String userId;
    private String status;

    public static DetailTaskDTO from(Task task){
        return builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .endDate(task.getEndDate())
                .userId(task.getUser().getId())
                .status(task.getStatus().getName())
                .build();
    }
}
