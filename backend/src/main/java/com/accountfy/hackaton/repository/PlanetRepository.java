package com.accountfy.hackaton.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.accountfy.hackaton.entity.Planet;

@Transactional
public interface PlanetRepository extends JpaRepository<Planet, Long> {

	Optional<Planet> findFirstByNameStartsWithIgnoreCaseOrderByNameAsc(String name);

}
