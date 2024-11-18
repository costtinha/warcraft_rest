package com.warcraft.warcraft_rest.member;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MemberControl {
    private final MemberService repository;

    public MemberControl(MemberService repository) {
        this.repository = repository;
    }

    @GetMapping("/member")
    public List<MemberResponseDto> findMembers(){
        return repository.findAll();
    }
    @PostMapping("/member")
    public MemberResponseDto saveMember(
           @Valid @RequestBody MemberDto dto
    ){
        return repository.saveMember(dto);
    }

    @GetMapping("/member/{member-id}")
    public MemberResponseDto findMemberById(
            @PathVariable("member-id") int id
    ){
        return repository.findMemberById(id);
    }

    @GetMapping("/memberTotal")
    public List<Member> findMemberTotal(){
        return repository.findMemberTotal();
    }

    @DeleteMapping("/member/{member-id}")
    public void deleteMember(
        @PathVariable("member-id") int id
    ){
        repository.deleteMemberById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var erros = new HashMap<String,String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error ->{
                    var fieldMessage =((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    erros.put(fieldMessage,errorMessage);
                });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }


}
