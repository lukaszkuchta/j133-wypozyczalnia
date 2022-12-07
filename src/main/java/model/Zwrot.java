package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zwrot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notatka;
    private LocalDateTime dataZwrotu;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Wypozyczenie wypozyczenie;
}
