package com.warcraft.warcraft_rest.race;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.warcraft.warcraft_rest.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Race {
    @Id
    @GeneratedValue
    private int race_id;

    private String race_name;

    private String race_height;
    private  String race_weight;

    @OneToMany(mappedBy = "race")
    @JsonManagedReference
    private List<Member> members;


    public Race(String race_name, String race_height, String race_weight) {
        this.race_name = race_name;
        this.race_height = race_height;
        this.race_weight = race_weight;
    }

    public Race() {
    }


    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public String getRace_height() {
        return race_height;
    }

    public void setRace_height(String race_height) {
        this.race_height = race_height;
    }

    public String getRace_weight() {
        return race_weight;
    }

    public void setRace_weight(String race_weight) {
        this.race_weight = race_weight;
    }
}
