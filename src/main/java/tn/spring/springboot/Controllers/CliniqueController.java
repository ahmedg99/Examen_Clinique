package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceClinique;
import tn.spring.springboot.entities.Clinique;

@RestController
@RequestMapping("/Clinique")
public class CliniqueController {


        @Autowired
        IServiceClinique iServiceClinique ;


    @PostMapping("/add")
    @ResponseBody
    public void addGare(@RequestBody Clinique clinique) {
        iServiceClinique.addClinique(clinique);
    }




}
