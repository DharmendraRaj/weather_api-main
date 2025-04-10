package com.klm.weather.controller;

import com.klm.weather.model.Weather;
import com.klm.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherApiRestController {

    private final WeatherService service;

    @Autowired
    public WeatherApiRestController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/fetch/{city}")
    public ResponseEntity<Weather> fetchWeather(@PathVariable String city) {
        Weather data = service.getWeather(city);
        return ResponseEntity.ok(data);
    }

}
