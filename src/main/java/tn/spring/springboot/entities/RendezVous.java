package tn.spring.springboot.entities;

  import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@ToString
@Data

public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private Long idRDV;
    private Date dateRDV ;
    private String remaque ;

    @ManyToOne
    Medecin medecin;

    @ManyToOne
    Patient patient;

}