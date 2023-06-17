package com.proiect.bazededate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jucator")

public class Jucator {

    @Id
    @GeneratedValue
    private Integer id;

    private String nume;

    private String prenume;

    private String pozitie;

    private String tara_origine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "echipa_id", referencedColumnName = "id")
    private Echipa echipa_id;
}
