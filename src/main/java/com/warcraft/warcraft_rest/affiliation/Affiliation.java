package com.warcraft.warcraft_rest.affiliation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.warcraft.warcraft_rest.clans.Clans;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Affiliation {
    @Id
    @GeneratedValue
    private int affiliation_id;
    @Column(
            length = 80
    )
    private String army_name;

    private String island;

    @OneToMany(mappedBy = "affiliation")
    @JsonManagedReference
    private List<Clans> clans;

    public Affiliation(String army_name, String island) {
        this.army_name = army_name;
        this.island = island;
    }

    public Affiliation() {
    }

    public String getIsland() {
        return island;
    }


    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public void setIsland(String island) {
        this.island = island;
    }

    public String getArmy_name() {
        return army_name;
    }

    public void setArmy_name(String army_name) {
        this.army_name = army_name;
    }
}
