package tn.spring.springboot.Services.Interfaces;

import tn.spring.springboot.entities.RendezVous;
import tn.spring.springboot.entities.Specialite;

import java.util.List;

public interface IServiceRDV {
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) ;
    public int getNbrRendezVousMedecin(Long idMedecin) ;
    public void retrieveRendezVous();
}
