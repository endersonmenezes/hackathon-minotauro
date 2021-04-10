package com.accountfy.hackaton.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accountfy.hackaton.dto.Matriz;
import com.accountfy.hackaton.dto.PartidaReceived;
import com.accountfy.hackaton.dto.PartidaSended;
import com.accountfy.hackaton.dto.PosicaoAtual;
import com.accountfy.hackaton.entity.Partida;
import com.accountfy.hackaton.mapper.PartidaMapper;
import com.accountfy.hackaton.repository.PartidaRepository;

@Service
public class PartidaService {

	private final PartidaMapper mapper;

	private final PartidaRepository repository;

	private final PosicaoService posicaoService;

	public PartidaService(PartidaMapper mapper, PartidaRepository repository, PosicaoService posicaoService) {
		this.mapper = mapper;
		this.repository = repository;
		this.posicaoService = posicaoService;
	}

	@Transactional
	public PartidaSended post(PartidaReceived dto) {
		Partida partida = mapper.toPartida(dto);

		
		Partida saved = repository.save(partida);
		if(Objects.isNull(saved.getPosX())){
			Matriz matriz = posicaoService.obtemMatrizDaPartida(saved);
			int posicaoInicial = matriz.getMap().size()-2;
			saved.setPosX(posicaoInicial);
			saved.setPosY(posicaoInicial);
			saved.setQtdeJogadasMinimo(matriz.getSolution().size());
			saved.setQtdeJogadas(0);
			saved.setOlhandoPara(1);
			
		}
		return mapper.toPartida(saved);
	}
	
	public PosicaoAtual get(Long idPartida) {
		Partida partida = repository.findById(idPartida).orElseThrow(() -> new RuntimeException("Partida não localizada."));
		repository.save(partida);
		return posicaoService.obtemPosicaoAtualDoJogador(partida);
	}
	
	public PosicaoAtual trocaPosicao(Long idPartida, Integer escolha) {
		Partida partida = repository.findById(idPartida).orElseThrow(() -> new RuntimeException("Partida não localizada."));
		
		Partida alterada = posicaoService.realizaMovimentoDoJogador(partida, escolha);
		
		repository.save(alterada);
		
		System.out.println("Movendo personagem");
		System.out.println("Pos X: " + partida.getPosX());
		System.out.println("Pos Y: " + partida.getPosY());
		System.out.println("Olhando para: " + partida.getOlhandoPara());
		System.out.println("Escolha: " + escolha);

		return posicaoService.obtemPosicaoAtualDoJogador(partida);
	}
}
