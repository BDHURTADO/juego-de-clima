package com.juego.backend.model;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {

    private List<WeatherDetail> weather;
    private Main main;
    private String name; // ciudad

    @Data
    public static class Main {
        private double temp;
        private int humidity;
    }

    @Data
    public static class WeatherDetail {
        private String main;
        private String description;
    }
}
