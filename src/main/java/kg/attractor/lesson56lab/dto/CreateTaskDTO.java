package kg.attractor.lesson56lab.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CreateTaskDTO {
    private String title;
    private String description;
    private LocalDateTime endDate;
}
