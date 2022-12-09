package tn.spring.springboot.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.HashCodeExclude;

import javax.persistence.*;
import java.util.List ;

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

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "medecins")
    @JsonIgnore
    private List<Clinique> cliniques ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="medecin")
    @JsonIgnore
    private List<RendezVous> rendezVousList;
}