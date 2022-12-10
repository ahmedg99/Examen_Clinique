package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceRDV;
import tn.spring.springboot.entities.*;
import tn.spring.springboot.repositories.CliniqueRepository;
import tn.spring.springboot.repositories.MedecinRepository;
import tn.spring.springboot.repositories.PatientRepository;
import tn.spring.springboot.repositories.RendezVousRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceRDViMP  implements IServiceRDV {


    @Autowired
    RendezVousRepository rendezVousRepository ;
    @Autowired
    MedecinRepository  medecinRepository;
    @Autowired
    PatientRepository patientRepository ;
    @Autowired
    CliniqueRepository cliniqueRepository ;


    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {

        Medecin medecin = medecinRepository.findById(idMedecin).get()  ;
        Patient patient = patientRepository.findById(idPatient).get() ;
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rendezVousRepository.save(rdv);
        log.info("rdb ajouté");
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {

        List<Medecin> listemed =  medecinRepository.findByCliniquesIdCliniqueAndSpecialite(idClinique,specialite) ;
        List<RendezVous> listerdv = new ArrayList<RendezVous>();
        for (int i= 0 ; i<listemed.size() ; i++) {

             listerdv.addAll(rendezVousRepository.findByMedecin( listemed.get(i))) ;

        }
            System.out.println(listerdv);
    return  listerdv ;

    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin = medecinRepository.findById(idMedecin).get()  ;
        return rendezVousRepository.countAllByMedecin(medecin.getIdMedecin());

    }

    @Override
    public void retrieveRendezVous() {
        List<RendezVous> liste = rendezVousRepository.findRdvAfterSystemDate();
        for(int i=0 ; i< liste.size();i++) {
            log.info(String.valueOf(liste.get(i)));
        }
  }

    }




