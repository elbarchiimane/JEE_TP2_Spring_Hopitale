package ma.enset.tp2_hopitale.services;
import ma.enset.tp2_hopitale.entities.Consultation;
import ma.enset.tp2_hopitale.entities.Medecin;
import ma.enset.tp2_hopitale.entities.Patient;
import ma.enset.tp2_hopitale.entities.RendezVous;
import ma.enset.tp2_hopitale.repositories.ConsultationRepository;
import ma.enset.tp2_hopitale.repositories.MedecinRepository;
import ma.enset.tp2_hopitale.repositories.PatientRepository;
import ma.enset.tp2_hopitale.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
}
