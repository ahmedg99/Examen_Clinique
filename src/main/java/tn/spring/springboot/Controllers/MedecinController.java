package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceMedecin;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.entities.Medecin;

import java.util.Date;

@RestController
@RequestMapping("/Medecin")
public class MedecinController {


    @Autowired
    IServiceMedecin iServiceMedecin ;


    @PostMapping("/addMedecinAndAssignToClinique/{idClinique}")
    @ResponseBody
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin , @PathVariable("idClinique") Long idClinique ) {
         return  iServiceMedecin.addMedecinAndAssignToClinique(medecin,idClinique);
    }


    @GetMapping(value = "/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    @ResponseBody
    public int getRevenuMedecin (
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate

    )  {
        return  iServiceMedecin.retriverevenuMedecin(idMedecin,startDate,endDate) ;
    }

}
