package edu.unc.conae.lcd.demo.bootstrap;

import edu.unc.conae.lcd.demo.models.entities.Drone;
import edu.unc.conae.lcd.demo.repositories.DroneRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Log4j2
public class BootStrapData implements CommandLineRunner {
    private final DroneRepository droneRepository;

    public BootStrapData(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Drones Data...");

        Drone d1 = Drone.builder()
                .timestamp(Instant.ofEpochSecond(1693166608))
                .droneName("Paul").state("Idle")
                .batery(100)
                .lat(-31.43359111363939)
                .lng(-64.19383232300841)
                .message("Paul is idle... he's actually playing bass")
                .build();

        Drone d2 = Drone.builder()
                .timestamp(Instant.ofEpochSecond(1693166608))
                .droneName("George").state("Flying")
                .batery(86)
                .lat(-31.43359111363939)
                .lng(-64.19383232300841)
                .message("George is on a mission... he's actually playing guitar")
                .build();

        droneRepository.save(d1);
        droneRepository.save(d2);

        log.info("Drones Saved: " + droneRepository.count());
    }
}
