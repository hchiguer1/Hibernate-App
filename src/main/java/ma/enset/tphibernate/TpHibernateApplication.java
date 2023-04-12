package ma.enset.tphibernate;

import ma.enset.tphibernate.entities.Patient;
import ma.enset.tphibernate.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpHibernateApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(TpHibernateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Achraf",new Date(1945,11,25),true,4));
        patientRepository.save(new Patient(null,"Ayoub",new Date(1999,8,02),false,1));
        patientRepository.save(new Patient(null,"Chaimaa",new Date(2002,10,10),true,5));
        patientRepository.save(new Patient(null,"Wafaa",new Date(2006,1,16),false,7));
        List<Patient> patients=patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("-------------------");
        Patient p1=patientRepository.findById(Long.valueOf(1L)).get();
        System.out.println(p1.toString());
        System.out.println("-------------------");
        List<Patient> patients1=patientRepository.findAllByMaladeIsTrue();
        patients1.forEach(p2->{
            System.out.println(p2.toString());
        });
        System.out.println("-------------------");
        patientRepository.updatePatient(Long.valueOf(1),false);
        List<Patient> patients3=patientRepository.findAll();
        patients3.forEach(p5->{
            System.out.println(p5.toString());
        });
        System.out.println("-------------------");
        patientRepository.deleteById(Long.valueOf(7));
        List<Patient> patients4=patientRepository.findAll();
        patients4.forEach(p5->{
            System.out.println(p5.toString());
        });


    }
}
