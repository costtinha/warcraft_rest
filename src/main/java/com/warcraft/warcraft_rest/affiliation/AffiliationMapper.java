package com.warcraft.warcraft_rest.affiliation;

import org.springframework.stereotype.Service;

@Service
public class AffiliationMapper {

    public AffiliationResponseDto toResponseDto(Affiliation affiliation){
        return new AffiliationResponseDto(affiliation.getArmy_name());
    }

    public Affiliation toAffiliation(AffiliationDto dto){
        return new Affiliation(dto.army_name(), dto.island_name());

    }
}
