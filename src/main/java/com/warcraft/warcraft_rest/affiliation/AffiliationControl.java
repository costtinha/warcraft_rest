package com.warcraft.warcraft_rest.affiliation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AffiliationControl {
    private final AffiliationService repository;

    public AffiliationControl(AffiliationService repository) {
        this.repository = repository;
    }

    @GetMapping("/affiliation")
    public List<AffiliationResponseDto> findAffiliation(){
        return repository.findAll();
    }

    @PostMapping("/affiliation")
    public AffiliationResponseDto postAffiliation(
           @Valid @RequestBody AffiliationDto dto
    ){
        return repository.save(dto);
    }

    @GetMapping("/affiliation/{affiliation-id}")
    public  AffiliationResponseDto findById(
            @PathVariable("affiliation-id") int id
    ){
        return repository.findByAffiliationId(id);
    }
    @GetMapping("/affiliationTotal")
    public List<Affiliation> findAll(){
        return repository.findTotal();
    }
    @DeleteMapping("/affiliation/{affiliation-id}")
    public void deleteAffiliation(
            @PathVariable("affiliation-id") int id
    ){
        repository.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
