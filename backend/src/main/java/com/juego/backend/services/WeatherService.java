package com.juego.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.juego.backend.model.WeatherResponse;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;  //simplifica la realización de solicitudes HTTP (como GET, POST, PUT, DELETE)


    public WeatherService(RestTemplate restTemplate) {  //hacer llamadas http
        this.restTemplate = restTemplate;
    }

    @Param //para consultar nombre de la ciudad
    @Return //objeto de weatherResponse
    public WeatherResponse getWeatherByCity(String cityName) {
        String fullUrl = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("q", cityName)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .queryParam("lang", "es")
                .toUriString();

        try {
            return restTemplate.getForObject(fullUrl, WeatherResponse.class);
        } catch (Exception e) {
            System.err.println("error al obtener el clima para "+cityName + ": "+e.getMessage());
            return null;
        }
    }

    
}
