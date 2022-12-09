package tn.spring.springboot.entities;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set ;

 import java.io.Serializable;


@Entity
@ToString
@Data

public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private Long idMedecin;
    private String nomMedecin ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;
    private int telephone ;
    private int prixConsultation ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Clinique> cliniques ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="medecin")
    private Set<RendezVous> rendezVousSet;
}