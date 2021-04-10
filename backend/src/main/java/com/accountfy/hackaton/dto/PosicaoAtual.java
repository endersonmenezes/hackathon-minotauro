package com.accountfy.hackaton.dto;

import java.io.Serializable;

public class PosicaoAtual implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean frente;
	private Boolean esquerda;
	private Boolean direita;
	private Boolean atras;

	public Boolean getFrente() {
		return frente;
	}

	public void setFrente(Boolean frente) {
		this.frente = frente;
	}

	public Boolean getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Boolean esquerda) {
		this.esquerda = esquerda;
	}

	public Boolean getDireita() {
		return direita;
	}

	public void setDireita(Boolean direita) {
		this.direita = direita;
	}

	public Boolean getAtras() {
		return atras;
	}

	public void setAtras(Boolean atras) {
		this.atras = atras;
	}

}
