package ma.enset.tp2_hopitale.repository;

import ma.enset.tp2_hopitale.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNomContains(String mc);
    @Modifying
    @Transactional
    @Query("update Patient p set  p.nom=:nom, p.malade=:malade WHERE p.id=:id ")
    void updatePatient(@Param("id") Long id, @Param("nom") String nom, @Param("malade") boolean malade);
}
