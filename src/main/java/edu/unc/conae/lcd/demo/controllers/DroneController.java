package edu.unc.conae.lcd.demo.controllers;

import edu.unc.conae.lcd.demo.models.entities.Drone;
import edu.unc.conae.lcd.demo.services.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(DroneController.BASE_URL)
public class DroneController {
    public static final String BASE_URL = "api/v1/drones";

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get the information of all Drones")
    public ResponseEntity<List<Drone>> getAllDrones() {
        List<Drone> drones = droneService.findAllDrones();
        log.info("GetAllDrones: " + drones);
        return ResponseEntity.ok().body(drones);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get the information of a Drone by its ID")
    @ResponseStatus(HttpStatus.OK)
    public @Nullable ResponseEntity<Drone> getDroneById(@PathVariable Long id) {
        Drone drone = droneService.findDroneById(id);
        log.info("GetDroneById: " + drone);
        return ResponseEntity.ok().body(drone);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save a new entity of Drone")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Drone created"
            , content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Drone.class)
            , examples = {@ExampleObject(value = "1", name = "ID of the Drone created")})})})
    public ResponseEntity<Long> saveDrone(@RequestBody Drone drone) {
        Drone savedDrone = droneService.saveDrone(drone);
        log.info("Drone Id: " + savedDrone + " saved");
        return ResponseEntity.ok().body(savedDrone.getId());
    }
}
