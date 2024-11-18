package com.warcraft.warcraft_rest.clans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.warcraft.warcraft_rest.member.Member;
import com.warcraft.warcraft_rest.affiliation.Affiliation;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clans {
    @Id
    @GeneratedValue
    private int clan_id;
    @Column(
            length = 50
    )
    private String clan_name;
    @Column(
            length = 50
    )
    private String zone;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name= "affiliation_id"
    )
    private Affiliation affiliation;

    @OneToMany(mappedBy = "clan")
    @JsonManagedReference
    private List<Member> members;



    public Clans(String clan_name, String zone, Affiliation affiliation) {
        this.clan_name = clan_name;
        this.zone = zone;
        this.affiliation = affiliation;
    }

    public Clans() {
    }



    public int getClan_id() {
        return clan_id;
    }

    public void setClan_id(int clan_id) {
        this.clan_id = clan_id;
    }

    public String getClan_name() {
        return clan_name;
    }

    public void setClan_name(String clan_name) {
        this.clan_name = clan_name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }
}
