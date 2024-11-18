package com.warcraft.warcraft_rest.clans;

import com.warcraft.warcraft_rest.affiliation.Affiliation;
import org.springframework.stereotype.Service;

@Service
public class ClansMapper {

    public ClansResponseDto toClansResponseDto(Clans clans){
        return new ClansResponseDto(clans.getClan_name(), clans.getZone());
    }

    public Clans toClans(ClansDto dto){
        Affiliation affiliation = new Affiliation();
        affiliation.setAffiliation_id(dto.affiliation_id());
        return new Clans(dto.clan_name(), dto.zone(), affiliation);
    }

}
