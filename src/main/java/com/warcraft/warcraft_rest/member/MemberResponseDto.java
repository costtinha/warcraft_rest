package com.warcraft.warcraft_rest.member;

import com.warcraft.warcraft_rest.race.Race;

public record MemberResponseDto(String member_name, String member_class, int age, String sex) {
}
