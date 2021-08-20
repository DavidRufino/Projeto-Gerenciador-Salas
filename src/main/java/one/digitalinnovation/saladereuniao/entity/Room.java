package one.digitalinnovation.saladereuniao.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate date;

    @Column(nullable = false)
    private String startHour;

    @Column(nullable = false)
    private String endHour;
}
