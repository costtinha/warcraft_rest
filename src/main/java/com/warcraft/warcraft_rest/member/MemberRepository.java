package com.warcraft.warcraft_rest.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Integer> {
}
