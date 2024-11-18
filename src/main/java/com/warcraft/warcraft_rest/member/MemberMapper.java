package com.warcraft.warcraft_rest.member;
import com.warcraft.warcraft_rest.clans.Clans;
import com.warcraft.warcraft_rest.race.Race;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {
    public MemberResponseDto toMemberResponseDto(Member member){

        return new MemberResponseDto(member.getMember_name(),
                member.getMember_class(),
                member.getAge(),
                member.getSex());
    }

    public Member toMember(MemberDto dto){
        Race race = new Race();
        race.setRace_id(dto.race_id());
        Clans clans = new Clans();
        clans.setClan_id(dto.clan_id());
        return new Member(dto.member_name(),
                dto.member_class(),
                dto.age(),
                dto.sex(),
                clans,
                race
        );

    }
}
