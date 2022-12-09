package tn.spring.springboot.Services.Interfaces;

import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.entities.Medecin;

import java.util.Date;

public interface IServiceMedecin {
    //public Medecin addMedecin (Medecin clinique);
     public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId) ;
    public int retriverevenuMedecin(Long idMedecin , Date startDate , Date endDate) ;

}
