package com.accountfy.hackaton.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountfy.hackaton.dto.PartidaReceived;
import com.accountfy.hackaton.dto.PartidaSended;
import com.accountfy.hackaton.dto.PosicaoAtual;
import com.accountfy.hackaton.service.PartidaService;

@RestController
@RequestMapping("/partida")
public class PartidaController {

	private final PartidaService service;

	public PartidaController(PartidaService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PosicaoAtual> getById(@PathVariable("id") Long id) {

		return ResponseEntity.ok(service.get(id));
	}
	
	@GetMapping("/{id}/{escolha}")
	public ResponseEntity<PosicaoAtual> mudaPosicao(@PathVariable("id") Long id, @PathVariable("escolha") Integer escolha){
		

		return ResponseEntity.ok(service.trocaPosicao(id, escolha));
	}

	@PostMapping
	public ResponseEntity<PartidaSended> post(@RequestBody PartidaReceived partida) {
		PartidaSended partidaSended = service.post(partida);
		return ResponseEntity.ok(partidaSended);
	}
}
