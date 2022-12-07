package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    private LocalDateTime dataZwrotu;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Wypozyczenie wypozyczenie;
}
