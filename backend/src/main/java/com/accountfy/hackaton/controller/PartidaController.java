package com.accountfy.hackaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountfy.hackaton.dto.PartidaReceived;
import com.accountfy.hackaton.dto.PartidaSended;
import com.accountfy.hackaton.service.PartidaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/partida")
public class PartidaController {

	private final PartidaService service;

	public PartidaController(PartidaService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	@ApiResponse(responseCode = "200", description = "Planeta encontrado e retornado com sucesso.")
	@ApiResponse(responseCode = "400", description = "Planeta não encontrado no banco de dados.")
	@Operation(summary = "Busca um planeta através de seu ID.")
	public ResponseEntity<Void> getById(
			@PathVariable("id") @Parameter(description = "ID do planeta a ser buscado.") Long id) {
//		PlanetResponseDTO planet = service.getById(id);
//		return ResponseEntity.ok(planet);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<PartidaSended> post(@RequestBody PartidaReceived partida) {
		PartidaSended partidaSended = service.post(partida);
		return ResponseEntity.ok(partidaSended);
	}
}
