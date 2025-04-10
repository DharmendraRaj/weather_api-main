package com.klm.weather.repository.mongo;

import com.klm.weather.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherMongoRepository extends MongoRepository<Weather, String> {

}
