package com.warcraft.warcraft_rest.clans;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClansService {
    private final ClansRepository repository;
    private final ClansMapper mapper;

    public ClansService(ClansRepository repository, ClansMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ClansResponseDto> findClans(){
        return repository.findAll()
                .stream()
                .map(mapper::toClansResponseDto)
                .collect(Collectors.toList());
    }

    public ClansResponseDto saveClans(ClansDto dto){
        Clans clans = mapper.toClans(dto);
        return mapper.toClansResponseDto(repository.save(clans));
    }

    public ClansResponseDto findClansById(int id){
        return mapper.toClansResponseDto(repository.findById(id).orElse(null));
    }
    public List<Clans> findClansTotal(){
        return repository.findAll();

    }

    public void deleteClans(int id){
        repository.deleteById(id);
    }
}
