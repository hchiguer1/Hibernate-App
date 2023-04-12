package ma.enset.tphibernate.repository;

import ma.enset.tphibernate.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAllByMaladeIsTrue();

    //void removeById(Long i);
    @Transactional
    @Modifying
    @Query("update Patient p set p.malade=:mal where p.id=:x")
    void updatePatient(@Param("x") Long c,@Param("mal") Boolean y);

}
