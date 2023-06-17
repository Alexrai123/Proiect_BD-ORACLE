package com.proiect.bazededate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stadion")
public class Stadion {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer capacitate;

    private LocalDate anInfiintare;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "echipa_id", referencedColumnName = "id")
    private Echipa echipa;
}
