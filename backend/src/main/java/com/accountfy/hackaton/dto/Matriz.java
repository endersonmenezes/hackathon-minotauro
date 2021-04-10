package com.accountfy.hackaton.dto;

import java.util.List;

public class Matriz {

	private List<List<Boolean>> map;
	private List<List<Integer>> solution;
	private String mapImage;

	public List<List<Boolean>> getMap() {
		return map;
	}

	public void setMap(List<List<Boolean>> map) {
		this.map = map;
	}

	public List<List<Integer>> getSolution() {
		return solution;
	}
	
	public void setSolution(List<List<Integer>> solution) {
		this.solution = solution;
	}

	public String getMapImage() {
		return mapImage;
	}

	public void setMapImage(String mapImage) {
		this.mapImage = mapImage;
	}

}
