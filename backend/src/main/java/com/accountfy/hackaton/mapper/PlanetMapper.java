package com.accountfy.hackaton.mapper;

import org.mapstruct.Mapper;

import com.accountfy.hackaton.dto.PlanetRequestDTO;
import com.accountfy.hackaton.dto.PlanetResponseDTO;
import com.accountfy.hackaton.entity.Planet;

@Mapper(componentModel="spring")
public interface PlanetMapper {

	public Planet toPlanet(PlanetResponseDTO dto);
	
	public PlanetResponseDTO toPlanet(Planet planet);
	
	public Planet toPlanet(PlanetRequestDTO dto);
	
}
