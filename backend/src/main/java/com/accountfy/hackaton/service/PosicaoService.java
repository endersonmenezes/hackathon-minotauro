package com.accountfy.hackaton.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.accountfy.hackaton.dto.Matriz;
import com.accountfy.hackaton.dto.PosicaoAtual;
import com.accountfy.hackaton.entity.Partida;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PosicaoService {

	private static String ASD = "{\n" + 
			"  \"map\": [\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      false,\n" + 
			"      true\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true,\n" + 
			"      true\n" + 
			"    ]\n" + 
			"  ],\n" + 
			"  \"mapImage\": \"gifUrl\"\n" + 
			"}";
	
	private final Map<Integer, Matriz> matrizPosicao = new HashMap<>();
	
	public void inicializa(Long idPartida) {
		ObjectMapper mappe = new ObjectMapper();
		Matriz matrizGerada;
		try {
			matrizGerada = mappe.readValue(ASD, Matriz.class);
			matrizPosicao.put(idPartida.intValue(), matrizGerada);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Partida realizaMovimentoDoJogador(Partida partida, Integer escolha) {
		Matriz matriz = matrizPosicao.get(partida.getId().intValue());
		
		Integer olhandoPara = partida.getOlhandoPara();

		Pair<Integer, Integer> a = obtemPosicaoDaEscolha(olhandoPara, escolha, partida.getPosX(), partida.getPosY());
		
		Boolean teste = obtemStatusDaPosicaoEscolhidaNoCaminho(matriz, a);
		
		if(teste) {
			throw new RuntimeException("Movimento impossivel");
		}

		
		int posX = posicaoMudou(partida.getPosX(), a.getFirst());
		int posY = posicaoMudou(partida.getPosY(), a.getSecond());
		
		if(posX != 0) {
			if(posX > 0) {
				partida.setOlhandoPara(3);
			}
			else if(posX < 0) {
				partida.setOlhandoPara(2);
			}
		}
		else if(posY != 0) {
			if(posY > 0) {
				partida.setOlhandoPara(4);
			}
			else if(posY < 0) {
				partida.setOlhandoPara(1);
			}
		}
		
		
		partida.setPosX(a.getFirst());
		partida.setPosY(a.getSecond());
		partida.setQtdeJogadas(partida.getQtdeJogadas()+1);
			
		return partida;
	}
	
	public int posicaoMudou(Integer posAntiga, Integer posAtual) {
		return posAtual-posAntiga;
	}
	
	public PosicaoAtual obtemPosicaoAtualDoJogador(Partida partida) {
		Matriz matriz = matrizPosicao.get(partida.getId().intValue());
		
		PosicaoAtual posicao = new PosicaoAtual();
		
		Pair<Integer, Integer> cordFrente = obtemPosicaoDaEscolha(partida.getOlhandoPara(), 1, partida.getPosX(), partida.getPosY());
		posicao.setFrente(!obtemStatusDaPosicaoEscolhidaNoCaminho(matriz, cordFrente));
		
		Pair<Integer, Integer> cordEsquerda = obtemPosicaoDaEscolha(partida.getOlhandoPara(), 2, partida.getPosX(), partida.getPosY());
		posicao.setEsquerda(!obtemStatusDaPosicaoEscolhidaNoCaminho(matriz, cordEsquerda));

		Pair<Integer, Integer> cordDireita = obtemPosicaoDaEscolha(partida.getOlhandoPara(), 3, partida.getPosX(), partida.getPosY());
		posicao.setDireita(!obtemStatusDaPosicaoEscolhidaNoCaminho(matriz, cordDireita));

		Pair<Integer, Integer> corTras = obtemPosicaoDaEscolha(partida.getOlhandoPara(), 4, partida.getPosX(), partida.getPosY());
		posicao.setAtras(!obtemStatusDaPosicaoEscolhidaNoCaminho(matriz, corTras));

		return posicao;
	}

	private Boolean obtemStatusDaPosicaoEscolhidaNoCaminho(Matriz matriz, Pair<Integer, Integer> cordFrente) {
		try {
			return matriz.getMap().get(cordFrente.getSecond()).get(cordFrente.getFirst());
		} catch (Exception e) {
			return false;
		}
	}

	public Pair<Integer, Integer> obtemPosicaoDaEscolha(Integer olhandoPara, Integer escolha, Integer posX, Integer posY) {

		Integer posRetornoX = posX.intValue();
		Integer posRetornoY = posY.intValue();
		if (olhandoPara == 1) {
			if (escolha == 1) {
				posRetornoY = posY-1;
			} else if (escolha == 2) {
				posRetornoX = posX-1;
			} else if (escolha == 3) {
				posRetornoX = posX+1;
			} else if (escolha == 4) {
				posRetornoY = posY+1;
			}
		} else if (olhandoPara == 2) {
			if (escolha == 1) {
				posRetornoX = posX-1;
			}
			else if (escolha == 2) {
				posRetornoY = posY+1;
			}
			else if (escolha == 3) {
				posRetornoY = posY-1;
			}
			else if (escolha == 4) {
				posRetornoX = posX+1;
			}
		} else if (olhandoPara == 3) {
			if (escolha == 1) {
				posRetornoX = posX+1;
			}
			else if (escolha == 2) {
				posRetornoY = posY-1;
			}
			else if (escolha == 3) {
				posRetornoY = posY+1;
			}
			else if (escolha == 4) {
				posRetornoX = posX-1;
			}
		} else if (olhandoPara == 4) {
			if (escolha == 1) {
				posRetornoY = posY+1;
			}
			else if (escolha == 2) {
				posRetornoX = posX+1;
			}
			else if (escolha == 3) {
				posRetornoX = posX-1;
			}
			else if (escolha == 4) {
				posRetornoY = posY-1;
			}
		}
		
		return Pair.of(posRetornoX, posRetornoY);
	}

}
