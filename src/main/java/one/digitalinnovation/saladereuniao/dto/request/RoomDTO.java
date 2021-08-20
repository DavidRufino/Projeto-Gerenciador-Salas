package one.digitalinnovation.saladereuniao.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private long id;

    @NotEmpty
    private String name;

    private String date;

    @NotEmpty
    private String startHour;

    @NotEmpty
    private String endHour;
}
