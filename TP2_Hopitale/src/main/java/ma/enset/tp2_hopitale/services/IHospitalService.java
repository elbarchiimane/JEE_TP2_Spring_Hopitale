package ma.enset.tp2_hopitale.services;

import ma.enset.tp2_hopitale.entities.Consultation;
import ma.enset.tp2_hopitale.entities.Medecin;
import ma.enset.tp2_hopitale.entities.Patient;
import ma.enset.tp2_hopitale.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRDV(RendezVous rendezVous);

}
