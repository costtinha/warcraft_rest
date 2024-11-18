package com.warcraft.warcraft_rest.affiliation;

import jakarta.validation.constraints.NotNull;

public record AffiliationDto(
        @NotNull String army_name,
        @NotNull String island_name) {
}
