package com.warcraft.warcraft_rest.race;

import org.springframework.stereotype.Service;

@Service
public class RaceMapper {
    public RaceResponseDto toResponseDto(Race race){
        return new RaceResponseDto(race.getRace_name(), race.getRace_height(), race.getRace_weight());
    }

    public Race toRace(RaceDto dto){
        return new Race(dto.race_name(), dto.race_height(), dto.race_weight());
    }
}
