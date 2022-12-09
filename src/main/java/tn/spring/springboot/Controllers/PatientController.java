package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServicePatient;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.entities.Patient;

@RestController
@RequestMapping("/Patient")
public class PatientController {

    @Autowired
    IServicePatient iServicePatient ;


    //addPatient
    @PostMapping("/add")
    @ResponseBody
    public Patient addPatient(@RequestBody Patient patient) {
       return iServicePatient.addPatient(patient);
    }


}
