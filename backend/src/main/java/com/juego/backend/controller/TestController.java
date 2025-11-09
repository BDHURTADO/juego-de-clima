package com.juego.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.juego.backend.model.WeatherResponse;
import com.juego.backend.services.WeatherService;


@RestController
@RequestMapping("/api/test")
public class TestController{

    @Autowired
    private WeatherService weatherService;

    //public TestController(WeatherService weatherService){  // para inyectar spring al weatherService
    //    this.weatherService = weatherService;
    //    System.out.println("✅ TestController cargado correctamente");
    //}

    @GetMapping("/ping")
        public String ping() {
        return "pong 🟢";
    }

    @GetMapping("/temperature")
    public WeatherResponse getWeatherByCity(@RequestParam String city){
        return weatherService.getWeatherByCity(city);
    }


}
