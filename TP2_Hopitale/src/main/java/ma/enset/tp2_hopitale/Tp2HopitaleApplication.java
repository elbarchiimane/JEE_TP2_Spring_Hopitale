package ma.enset.tp2_hopitale;

import ma.enset.tp2_hopitale.entities.Patient;
import ma.enset.tp2_hopitale.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2HopitaleApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(Tp2HopitaleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Ajouter des patients sur la base de donnes
        patientRepository.save(new Patient(null,"ALAOUI",new Date(),false,80));
        patientRepository.save(new Patient(null,"IDRISSI",new Date(),true,70));
        patientRepository.save(new Patient(null,"FATHI",new Date(),false,60));
        patientRepository.save(new Patient(null,"ATMANI",new Date(),true,80));

        //afficher tout les patients
        System.out.println("Liste des patients");
        List<Patient> patients=patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });

        //Afficher un patient par Id
        Patient patient=patientRepository.findById(Long.valueOf(3)).get();
        System.out.println("*********************");
        System.out.println(patient);

        //cherhcer des patients
        System.out.println("Chercher des patients par mot cle");
       List<Patient> patients1= patientRepository.findByNomContains("M");
       patients1.forEach(p->{
           System.out.println(p.toString());
       });

       //Mettre a jour un patient
        patientRepository.updatePatient(Long.valueOf(1),"regragui",false);

        //supprimer un patient
        patientRepository.deleteById(Long.valueOf(2));
    }
}
