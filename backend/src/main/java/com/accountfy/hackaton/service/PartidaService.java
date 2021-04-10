package com.accountfy.hackaton.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accountfy.hackaton.dto.PartidaReceived;
import com.accountfy.hackaton.dto.PartidaSended;
import com.accountfy.hackaton.entity.Partida;
import com.accountfy.hackaton.mapper.PartidaMapper;
import com.accountfy.hackaton.repository.PartidaRepository;

@Service
public class PartidaService {

	private final PartidaMapper mapper;

	private final PartidaRepository repository;


	public PartidaService(PartidaMapper mapper, PartidaRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
//
//	public PlanetResponseDTO getById(Long id) {
//		Optional<Planet> planet = repository.findById(id);
//		if (planet.isEmpty()) {
//			throw new EntityNotFoundException("Nenhuma entidade localizada com o ID informado.");
//		}
//		return mapper.toPlanet(planet.get());
//	}
//
//	public PlanetResponseDTO getByName(String name) {
//		Optional<Planet> planet = repository.findFirstByNameStartsWithIgnoreCaseOrderByNameAsc(name);
//		if (planet.isEmpty()) {
//			throw new EntityNotFoundException("Nenhuma entidade localizada com o nome informado.");
//		}
//		return mapper.toPlanet(planet.get());
//	}
//
//	public List<PlanetResponseDTO> findAll() {
//		return repository.findAll().stream().map(mapper::toPlanet).collect(Collectors.toList());
//	}

	@Transactional
	public PartidaSended post(PartidaReceived dto) {
//		Planet planeta = mapper.toPlanet(dto);
//		Long numFilmPlanetAppearances = searchNumFilmPlanetAppearances(planeta.getName());
//		planeta.setNumFilmAppearances(numFilmPlanetAppearances);
//		Planet planetaSaved = repository.save(planeta);
		
		Partida partida = mapper.toPartida(dto);
		Partida saved = repository.save(partida);
		return mapper.toPartida(saved);
	}

//	private Long searchNumFilmPlanetAppearances(String namePlanet) {
//		PlanetStarWarsApiDTO planet = swApiService.getPlanetByName(namePlanet);
//		return planet.getNumFilmAppearances();
//	}
//
//	@Transactional
//	public void deleteById(Long id) {
//		Optional<Planet> planet = repository.findById(id);
//
//		if (planet.isEmpty()) {
//			throw new EntityNotFoundException("Nenhuma entidade localizada com o ID informado.");
//		}
//		repository.delete(planet.get());
//	}
//
//	public PageableStarWarsApiDTO findAllInSwApi(String filter, int page) {
//		return swApiService.findAllPlanets(filter, page);
//	}
}
