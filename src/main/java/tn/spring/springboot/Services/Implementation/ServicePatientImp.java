package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServicePatient;
import tn.spring.springboot.entities.Patient;
import tn.spring.springboot.repositories.PatientRepository;

@Service
@Slf4j
public class ServicePatientImp  implements IServicePatient {

    @Autowired
    PatientRepository patientRepository ;

    @Override
    public Patient addPatient(Patient patient) {
      log.info("patient ajouté");
    return patientRepository.save(patient) ;
    }
}
