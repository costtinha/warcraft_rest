package com.warcraft.warcraft_rest.race;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceService {
    private final RaceRepository repository;
    private final RaceMapper mapper;

    public RaceService(RaceRepository repository, RaceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RaceResponseDto> findRaces(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public RaceResponseDto saveRace(RaceDto dto){
        Race race = mapper.toRace(dto);
        repository.save(race);
        return mapper.toResponseDto(race);


    }

    public  RaceResponseDto findRacesById(int id){
        return mapper.toResponseDto(repository.findById(id).orElse(null));
    }

    public List<Race> findRacesTotal(){
        return repository.findAll();
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }


}
