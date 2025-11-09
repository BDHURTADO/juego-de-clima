package com.juego.backend.model;

import lombok.Data;
import java.util.List;
import lombok.Builder;

@Data
@Builder
public class GameData {
    private String cityName;
    private double tempeatureCelcius;
    private String weatherCondition;
    private List<monster> monters;
}

