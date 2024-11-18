package com.warcraft.warcraft_rest.member;

import com.warcraft.warcraft_rest.clans.Clans;
import com.warcraft.warcraft_rest.race.Race;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public record MemberDto(
        @NotNull String member_name,
        String member_class,
        int age,
        String sex,
        Integer clan_id,
        Integer race_id) {
}
