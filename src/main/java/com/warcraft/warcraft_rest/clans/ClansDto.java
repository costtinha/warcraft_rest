package com.warcraft.warcraft_rest.clans;

import com.warcraft.warcraft_rest.affiliation.Affiliation;
import jakarta.validation.constraints.NotNull;

public record ClansDto(
        @NotNull String clan_name,
        @NotNull String zone,
        @NotNull Integer affiliation_id) {
}
