package com.accountfy.hackaton.dto;

import java.util.List;
import java.util.Objects;

public class PlanetStarWarsApiDTO {

	private String name;
	private String climate;
	private String terrain;
	private List<String> films;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public List<String> getFilms() {
		return films;
	}
	
	public void setFilms(List<String> films) {
		this.films = films;
	}

	public Long getNumFilmAppearances() {
		return Objects.nonNull(films) ? Long.valueOf(films.size()) : 0;
	}

}
