package ma.enset.tp2_hopitale.web;
import ma.enset.tp2_hopitale.entities.Patient;
import ma.enset.tp2_hopitale.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    PatientRepository patientRepository;
   @GetMapping("/patients")
    List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
