package com.klm.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Id
    private String id;
    private String city;
    private double temperature;
    private LocalDateTime timestamp;
}
