package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(
                Patient.builder()
                        .nom("Mohammed")
                        .dateNaissance(new Date())
                        .malade(false)
                        .score(34)
                        .build()
        );
        patientRepository.save(
                Patient.builder()
                        .nom("Hanane")
                        .dateNaissance(new Date())
                        .malade(false)
                        .score(4321)
                        .build()
        );
        patientRepository.save(
                Patient.builder()
                        .nom("Imane")
                        .dateNaissance(new Date())
                        .malade(false)
                        .score(34)
                        .build()
        );
    }
}
