package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataWypozyczenia;

    private String numerUmowy;
    private LocalDate dataPlanowanegoZwrotu;
    private Double cenaWynajmu;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Samochod samochod;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Klient klient;

    @OneToOne(mappedBy = "wypozyczenie")
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;
}
