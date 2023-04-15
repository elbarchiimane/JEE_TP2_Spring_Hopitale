package ma.enset.tp2_hopitale.repositories;

import ma.enset.tp2_hopitale.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository  extends JpaRepository<Medecin,Long> {
    Medecin findMedecinByNom(String nom);
}
