package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.entities.Specialite;

import java.util.List;

@EnableJpaRepositories

public interface MedecinRepository extends JpaRepository<Medecin,Long>{


   //  @Query("select M from Medecin M inner join Clinique  c where M. ")
    //List<Medecin>  findMedecinByNomClinique(Medecin m );

    public List<Medecin> findByCliniquesIdCliniqueAndSpecialite(Long cliniques_idClinique , Specialite specialite) ;
}
