package com.warcraft.warcraft_rest.race;

import jakarta.validation.constraints.NotNull;

public record RaceDto(
        @NotNull String race_name,
        @NotNull String race_height,
        @NotNull String race_weight) {
}
