package com.accountfy.hackaton.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accountfy.hackaton.dto.PageableStarWarsApiDTO;
import com.accountfy.hackaton.dto.PlanetRequestDTO;
import com.accountfy.hackaton.dto.PlanetResponseDTO;
import com.accountfy.hackaton.dto.PlanetStarWarsApiDTO;
import com.accountfy.hackaton.entity.Planet;
import com.accountfy.hackaton.exception.EntityNotFoundException;
import com.accountfy.hackaton.mapper.PlanetMapper;
import com.accountfy.hackaton.repository.PlanetRepository;

@Service
public class PlanetService {

	private final PlanetMapper mapper;

	private final PlanetRepository repository;

	private final StarWarsApiClientService swApiService;

	public PlanetService(PlanetMapper mapper, PlanetRepository repository, StarWarsApiClientService swApiService) {
		this.mapper = mapper;
		this.repository = repository;
		this.swApiService = swApiService;
	}

	public PlanetResponseDTO getById(Long id) {
		Optional<Planet> planet = repository.findById(id);
		if (planet.isEmpty()) {
			throw new EntityNotFoundException("Nenhuma entidade localizada com o ID informado.");
		}
		return mapper.toPlanet(planet.get());
	}

	public PlanetResponseDTO getByName(String name) {
		Optional<Planet> planet = repository.findFirstByNameStartsWithIgnoreCaseOrderByNameAsc(name);
		if (planet.isEmpty()) {
			throw new EntityNotFoundException("Nenhuma entidade localizada com o nome informado.");
		}
		return mapper.toPlanet(planet.get());
	}

	public List<PlanetResponseDTO> findAll() {
		return repository.findAll().stream().map(mapper::toPlanet).collect(Collectors.toList());
	}

	@Transactional
	public PlanetResponseDTO post(PlanetRequestDTO dto) {
		Planet planeta = mapper.toPlanet(dto);
		Long numFilmPlanetAppearances = searchNumFilmPlanetAppearances(planeta.getName());
		planeta.setNumFilmAppearances(numFilmPlanetAppearances);
		Planet planetaSaved = repository.save(planeta);
		return mapper.toPlanet(planetaSaved);
	}

	private Long searchNumFilmPlanetAppearances(String namePlanet) {
		PlanetStarWarsApiDTO planet = swApiService.getPlanetByName(namePlanet);
		return planet.getNumFilmAppearances();
	}

	@Transactional
	public void deleteById(Long id) {
		Optional<Planet> planet = repository.findById(id);

		if (planet.isEmpty()) {
			throw new EntityNotFoundException("Nenhuma entidade localizada com o ID informado.");
		}
		repository.delete(planet.get());
	}

	public PageableStarWarsApiDTO findAllInSwApi(String filter, int page) {
		return swApiService.findAllPlanets(filter, page);
	}
}
