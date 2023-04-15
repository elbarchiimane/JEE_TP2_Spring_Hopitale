package ma.enset.tp2_hopitale;

import ma.enset.tp2_hopitale.entities.*;
import ma.enset.tp2_hopitale.repositories.ConsultationRepository;
import ma.enset.tp2_hopitale.repositories.MedecinRepository;
import ma.enset.tp2_hopitale.repositories.PatientRepository;
import ma.enset.tp2_hopitale.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2HopitaleApplication /*implements CommandLineRunner*/{

    public static void main(String[] args) {

        SpringApplication.run(Tp2HopitaleApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository){
        return args->{
            Stream.of("hanane","hassnae","habiba")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patient.setScore(10);
                        patientRepository.save(patient);
                    });
            Stream.of("Hassnaoui","Benjelloun","Benis")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail("medecin@gmail.com");
                        medecin.setSpecialite("Dermato");
                        medecinRepository.save(medecin);
                    });
           Patient p= patientRepository.findPatientByNom("hanane");
            Medecin m=medecinRepository.findMedecinByNom("Benjelloun");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.PENDING);
            rendezVous.setMedecin(m);
            rendezVous.setPatient(p);
            rendezVousRepository.save(rendezVous);
            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation...........");
            consultationRepository.save(consultation);
        };
    }

   /* @Override
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

        //cherhcer des patients par mot cle
        System.out.println("Chercher des patients par mot cle");
        List<Patient> patients1= patientRepository.findByNomContains("M");
        patients1.forEach(p->{
           System.out.println(p.toString());
       });

       //Mettre a jour un patient
        patientRepository.updatePatient(Long.valueOf(1),"regragui",false);

        //supprimer un patient
        patientRepository.deleteById(Long.valueOf(2));
    }*/
}
