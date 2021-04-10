package com.accountfy.hackaton.service;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import com.accountfy.hackaton.dto.Matriz;
import com.accountfy.hackaton.entity.Partida;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PartidaService {
	private static String ASD = "{" + 
 		"	\"map\": [" + 
 		"		[true, true, true, true, true, true, true, true, true, true, true]," + 
 		"		[false, false, true, false, false, false, true, false, false, false, true]," + 
 		"		[true, false, true, false, true, false, true, false, true, true, true]," + 
 		"		[true, false, true, false, true, false, true, false, false, false, true]," + 
 		"		[true, false, true, false, true, false, true, true, true, false, true]," + 
 		"		[true, false, false, false, true, false, false, false, false, false, true]," + 
 		"		[true, true, true, true, true, true, true, true, true, false, true]," + 
 		"		[true, false, false, false, false, false, false, false, false, false, true]," + 
 		"		[true, false, true, true, true, true, true, true, true, true, true]," + 
 		"		[true, false, false, false, false, false, false, false, false, false, true]," + 
 		"		[true, true, true, true, true, true, true, true, true, true, true]" + 
 		"	]," + 
// 		"	\"solution\": [(9, 9), (9, 8), (9, 7), (9, 6), (9, 5), (9, 4), (9, 3), (9, 2), (9, 1), (8, 1), (7, 1), (7, 2), (7, 3), (7, 4), (7, 5), (7, 6), (7, 7), (7, 8), (7, 9), (6, 9), (5, 9), (5, 8), (5, 7), (5, 6), (5, 5), (4, 5), (3, 5), (2, 5), (1, 5), (1, 4), (1, 3), (2, 3), (3, 3), (4, 3), (5, 3), (5, 2), (5, 1), (4, 1), (3, 1), (2, 1), (1, 1)]," + 
 		"	\"mapImage\": \"gif_url\"" + 
 		"}";
	
	private Matriz matrizGerada;

	private PosicaoService posicaoService;
	
	@BeforeEach
	public void teste() throws JsonMappingException, JsonProcessingException {
		posicaoService = new PosicaoService();
		ObjectMapper mappe = new ObjectMapper();
		matrizGerada = mappe.readValue(ASD, Matriz.class);
		Map<Integer, Matriz> map = new HashMap<>();
		map.put(1, matrizGerada);
		ReflectionTestUtils.setField(posicaoService, "matrizPosicao", map);	
	}
	
	@Test
	public void testeMatriz() {
		Partida partida = new Partida();
		
		partida.setId(1l);
		partida.setPosX(9);
		partida.setPosY(9);
		
//		posicaoService.teste(partida);
	}
}
