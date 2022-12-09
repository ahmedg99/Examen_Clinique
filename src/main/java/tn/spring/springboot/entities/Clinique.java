package tn.spring.springboot.entities;


  import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@ToString
@Data

public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private Long idClinique;
    private String nomClinique ;
    private String adresse ;
    private int telephone ;

    @ManyToMany( mappedBy = "cliniques", cascade = CascadeType.ALL)
    private Set<Medecin> medecins ;

}