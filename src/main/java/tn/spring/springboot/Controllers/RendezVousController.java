package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceMedecin;
import tn.spring.springboot.Services.Interfaces.IServiceRDV;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.entities.RendezVous;
import tn.spring.springboot.entities.Specialite;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/RDV")
public class RendezVousController {


    @Autowired
    IServiceRDV iServiceRDV;


    @PostMapping("/MedecinController/{idMedecin}/{idPatient}")
    @ResponseBody
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv , @PathVariable("idMedecin") Long idMedecin , @PathVariable("idPatient") Long idPatient ) {
            iServiceRDV.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }

//getRendezVousByCliniqueAndSpecialite
//getRendezVousByCliniqueAndSpecialite


    @GetMapping(value = "/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    @ResponseBody
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idClinique") Long idClinique , @PathVariable("specialite") Specialite specialite ) {
        return  iServiceRDV.getRendezVousByCliniqueAndSpecialite(idClinique,specialite) ;
    }


    @GetMapping(value = "/getNbrRendezVousMedecin/{idMedecin}")
    @ResponseBody
    public int getNbrRendezVousMedecin(@PathVariable("idMedecin") Long idMedecin) {
        return  iServiceRDV.getNbrRendezVousMedecin(idMedecin) ;
    }




}
