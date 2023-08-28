package edu.unc.conae.lcd.demo.models.entities;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;
    @Schema(name = "timestamp", example = "2023-08-27T20:03:28Z")
    private Instant timestamp;
    @Schema(name = "droneName", example = "Paul")
    private String droneName;
    @Schema(name = "state", example = "Flying")
    private String state;
    @Schema(name = "batery", example = "54")
    private Integer batery;
    @Schema(name = "lat", example = "-31.43359111363939")
    private Double lat;
    @Schema(name = "lng", example = "-64.19383232300841")
    private Double lng;
    @Schema(name = "message", example = "Paul is on a mission... he's actually playing bass")
    private String message;

    public Drone() {

    }
}
