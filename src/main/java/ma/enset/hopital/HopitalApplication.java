package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
                        .dateNaissance(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 30))
                        .malade(false)
                        .score(715)
                        .build()
        );
        patientRepository.save(
                Patient.builder()
                        .nom("Hanane")
                        .dateNaissance(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 25))
                        .malade(true)
                        .score(812)
                        .build()
        );
        patientRepository.save(
                Patient.builder()
                        .nom("Imane")
                        .dateNaissance(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 20))
                        .malade(false)
                        .score(625)
                        .build()
        );
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
