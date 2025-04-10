package com.klm.weather.service;

import com.klm.weather.model.Weather;
import com.klm.weather.repository.mongo.WeatherMongoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherMongoRepository repository;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplateBuilder builder, WeatherMongoRepository repository) {
        this.restTemplate = builder.build();
        this.repository = repository;
    }

    public Weather getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
        Map<String, Object> weatherInfo = weatherList.get(0);

        Weather weather = new Weather(
                null,
                city,
                ((Number) main.get("temp")).doubleValue(),
                LocalDateTime.now()
        );

        return repository.save(weather);
    }

}