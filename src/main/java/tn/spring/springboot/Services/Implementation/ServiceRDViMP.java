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
        Clinique clinique = cliniqueRepository.findById(idClinique).get() ;
        return rendezVousRepository.findAll() ;



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
/*
        List<Medecin> liste = medecinRepository.findAll();

        List<Medecin> liste2 = null;
                for (int i = 0 ; i<liste.size();i++) {
                    for(int j=0 ; j<liste.get(i).getCliniques().size(); j++) {
                        if(liste.get(i).getCliniques().get(j).getNomClinique().equals("Taoufik") && (liste.get(i).getSpecialite().equals("Caediologue"))) {
                            assert liste2 != null;
                            liste2.add(liste.get(i));
                        }

                    }
                }


        List<RendezVous> liste3 = null;
                for (int x= 0 ; x<liste2.size();x++) {
                    liste3.add((RendezVous) liste2.get(x).getRendezVousList());
                }
                return liste3 ;

    }
    */



