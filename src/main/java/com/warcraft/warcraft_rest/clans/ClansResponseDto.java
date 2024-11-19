package com.warcraft.warcraft_rest.clans;

import com.warcraft.warcraft_rest.affiliation.Affiliation;
import jakarta.persistence.criteria.CriteriaBuilder;

public record ClansResponseDto(String clan_name, String zone, Integer affiliation) {
}
