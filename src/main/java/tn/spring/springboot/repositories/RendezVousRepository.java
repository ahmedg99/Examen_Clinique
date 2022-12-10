package tn.spring.springboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.entities.RendezVous;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    //@Query("SELECT R FROM RendezVous R WHERE R.medecin.specialite =:specialite  )
    //public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) ;
    @Query("SELECT count(R) FROM RendezVous R WHERE R.medecin.idMedecin =:idmedecin")
    public int countAllByMedecin(Long idmedecin) ;


    @Query("SELECT T FROM RendezVous T WHERE T.dateRDV > current_date ")
    List<RendezVous> findRdvAfterSystemDate();

    @Query("SELECT T FROM RendezVous T WHERE T.dateRDV BETWEEN :startDate AND :endDate and T.medecin.idMedecin=:idmedecin ")
    List<RendezVous> findRendezVousByDateRDVBetweentwodates(Long idmedecin , Date startDate , Date endDate) ;



    List<RendezVous> findByMedecin(Medecin medecin) ;


}
