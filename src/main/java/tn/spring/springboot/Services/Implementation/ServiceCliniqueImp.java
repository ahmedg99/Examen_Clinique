package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceClinique;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.repositories.CliniqueRepository;

@Service
@Slf4j
public class ServiceCliniqueImp implements IServiceClinique {

    @Autowired
     CliniqueRepository cliniqueRepository ;


    @Override
    public Clinique addClinique(Clinique clinique) {
        log.info("cliniqie ajouté ");
        return cliniqueRepository.save(clinique);
    }
}
