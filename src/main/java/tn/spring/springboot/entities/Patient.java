package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
 import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set ;

import java.io.Serializable;
import java.util.List;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@ToString
@Data

public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private Long idPatient;
    private String nomPatient ;
    private int telephone ;
    private Date dateNaissance  ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    @JsonIgnore
    private List<RendezVous> rendezVousSet;

}