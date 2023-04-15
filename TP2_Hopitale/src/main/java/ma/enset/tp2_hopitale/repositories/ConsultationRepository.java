package ma.enset.tp2_hopitale.repositories;

import ma.enset.tp2_hopitale.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
