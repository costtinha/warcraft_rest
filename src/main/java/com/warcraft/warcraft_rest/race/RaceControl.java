package com.warcraft.warcraft_rest.race;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class RaceControl {

    private final RaceService repository;

    public RaceControl(RaceService repository) {
        this.repository = repository;
    }


    @GetMapping("/race")
    public List<RaceResponseDto> findRaces(){
        return repository.findRaces();
    }

    @PostMapping("/race")
    public RaceResponseDto saveRace(
            @Valid @RequestBody RaceDto dto
    ){
        return repository.saveRace(dto);
    }

    @GetMapping("/race/{race-id}")
    public RaceResponseDto findRaceById(
            @PathVariable("race-id") int id
    ){
        return repository.findRacesById(id);
    }

    @GetMapping("/raceTotal")
    public List<Race> findRacesTotal(){
        return repository.findRacesTotal();
    }

    @DeleteMapping("/race/{race-id}")
    public void deleteById(
            @PathVariable("race-id") int id
    ){
        repository.deleteById(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldname= ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldname,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
