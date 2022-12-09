package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceMedecin;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.repositories.CliniqueRepository;
import tn.spring.springboot.repositories.MedecinRepository;
import tn.spring.springboot.repositories.RendezVousRepository;

import java.util.Date;

@Service
@Slf4j
public class ServiceMedecin implements IServiceMedecin {

    @Autowired
    MedecinRepository medecinRepository ;
    @Autowired
    CliniqueRepository cliniqueRepository ;
    @Autowired
    RendezVousRepository rendezVousRepository ;


    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).get();
        medecinRepository.save(medecin);
        clinique.getMedecins().add(medecin);
        cliniqueRepository.save(clinique);

        log.info("Le medecin : " + medecin.getNomMedecin() + "ajouté et affecté au clinique" + clinique.getNomClinique() );
        return medecin;
    }

    @Override
    public int retriverevenuMedecin(Long idMedecin , Date startDate , Date endDate) {
        Medecin m = medecinRepository.findById(idMedecin).get();
        int  countrdvvymedecin =  rendezVousRepository.findRendezVousByDateRDVBetweentwodates(idMedecin, startDate ,endDate).size();
        int sumrevenue =  countrdvvymedecin*m.getPrixConsultation();
        return sumrevenue ;
    }
}
