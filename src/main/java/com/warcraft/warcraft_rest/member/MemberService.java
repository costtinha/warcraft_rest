package com.warcraft.warcraft_rest.member;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository repository;
    private final  MemberMapper mapper;

    public MemberService(MemberRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MemberResponseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toMemberResponseDto)
                .collect(Collectors.toList());
    }

    public MemberResponseDto saveMember(MemberDto dto){
        Member member = mapper.toMember(dto);
        repository.save(member);
        return mapper.toMemberResponseDto(member);
    }

    public MemberResponseDto findMemberById(int id){
        return mapper.toMemberResponseDto(repository.findById(id).orElse(null));
    }
    public List<Member> findMemberTotal(){
        return repository.findAll();
    }

    public void deleteMemberById(int id){
        repository.deleteById(id);
    }
}
