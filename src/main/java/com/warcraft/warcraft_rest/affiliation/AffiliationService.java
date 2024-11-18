package com.warcraft.warcraft_rest.affiliation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AffiliationService {
    private final AffiliationRepository repository;
    private final AffiliationMapper mapper;

    public AffiliationService(AffiliationRepository repository, AffiliationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AffiliationResponseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public AffiliationResponseDto save(AffiliationDto dto){
        Affiliation affiliation = mapper.toAffiliation(dto);
        repository.save(affiliation);
        return mapper.toResponseDto(affiliation);

    }

    public AffiliationResponseDto findByAffiliationId(int id){
        return mapper.toResponseDto(repository.findById(id).orElse(null));
   }

   public List<Affiliation> findTotal(){
        return repository.findAll();
   }

   public void deleteById(int id){
        repository.deleteById(id);
   }


}
