package com.warcraft.warcraft_rest.member;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.warcraft.warcraft_rest.clans.Clans;
import com.warcraft.warcraft_rest.race.Race;
import jakarta.persistence.*;
@Entity
public class Member {
    @Id
    @GeneratedValue
    private int member_id;

    @Column(
            length = 80
    )
    private String member_name;

    @Column(
            length = 50
    )
    private String member_class;

    private int age;

    private String sex;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "clan_id"
    )
    private Clans clan;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "race_id"
    )
    private Race race;

    public Member(String member_name, String member_class, int age, String sex, Clans clan, Race race) {
        this.member_name = member_name;
        this.member_class = member_class;
        this.age = age;
        this.sex = sex;
        this.clan = clan;
        this.race = race;
    }

    public Member() {
    }


    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_class() {
        return member_class;
    }

    public void setMember_class(String member_class) {
        this.member_class = member_class;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Clans getClan() {
        return clan;
    }

    public void setClan(Clans clan) {
        this.clan = clan;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
