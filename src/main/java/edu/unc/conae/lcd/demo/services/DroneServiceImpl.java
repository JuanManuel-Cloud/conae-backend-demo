package edu.unc.conae.lcd.demo.services;

import edu.unc.conae.lcd.demo.models.entities.Drone;
import edu.unc.conae.lcd.demo.repositories.DroneRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository; // Dependency Injection
    }

    @Override
    public @Nullable Drone findDroneById(Long id) {
        return droneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Drone> findAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drone saveDrone(Drone drone) {
        return droneRepository.save(drone);
    }
}
