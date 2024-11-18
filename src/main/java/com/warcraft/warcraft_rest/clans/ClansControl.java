package com.warcraft.warcraft_rest.clans;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ClansControl {
    private final ClansService repository;

    public ClansControl(ClansService repository) {
        this.repository = repository;
    }

    @GetMapping("/clans")
    public List<ClansResponseDto> findClans(){
        return repository.findClans();
    }
    @PostMapping("/clans")
    public ClansResponseDto saveClans(
            @Valid @RequestBody ClansDto dto
            ){
        return repository.saveClans(dto);
    }

    @GetMapping("/clans/{clans-id}")
    public ClansResponseDto findClansById(
            @PathVariable("clans-id") int id
    ){
        return repository.findClansById(id);
    }

    @GetMapping("/clansTotal")
    public List<Clans> findClansTotal(){
        return repository.findClansTotal();
    }

    @DeleteMapping("/clans/{clans-id}")
    public void deleteById(
            @PathVariable("clans-id") int id
    ){
        repository.deleteClans(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var erros = new HashMap<String,String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error ->{
                    var fieldName =((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    erros.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

}
