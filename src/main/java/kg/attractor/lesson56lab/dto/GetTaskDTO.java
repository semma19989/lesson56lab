package kg.attractor.lesson56lab.dto;


import kg.attractor.lesson56lab.model.Task;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class GetTaskDTO {
    private String id;
    private String title;
    private String status;
    private LocalDateTime endDate;
    private String userId;

    public static GetTaskDTO getTaskDTO(Task task){
        return builder()
                .id(task.getId())
                .title(task.getTitle())
                .status(task.getStatus().getName())
                .endDate(task.getEndDate())
                .userId(task.getUser().getId())
                .build();
    }

}
