package edu.unc.conae.lcd.demo.services;

import edu.unc.conae.lcd.demo.models.entities.Drone;
import org.springframework.lang.Nullable;

import java.util.List;
public interface DroneService {
    @Nullable
    Drone findDroneById(Long id);
    List<Drone> findAllDrones();

    Drone saveDrone(Drone drone);
}
