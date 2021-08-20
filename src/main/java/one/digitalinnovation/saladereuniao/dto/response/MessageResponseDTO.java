package one.digitalinnovation.saladereuniao.dto.response;

import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.saladereuniao.entity.Room;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
    private Room object;
}