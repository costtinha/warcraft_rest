package com.warcraft.warcraft_rest.affiliation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliationRepository extends JpaRepository<Affiliation, Integer> {
}
