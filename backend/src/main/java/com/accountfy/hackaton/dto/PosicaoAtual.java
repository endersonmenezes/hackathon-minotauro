package com.accountfy.hackaton.dto;

import java.io.Serializable;

public class PosicaoAtual implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean frente;
	private Boolean esquerda;
	private Boolean direita;
	private Boolean atras;
	private Integer olhandoPara;
	private String direcao;
	private Boolean venceu;

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

	public Integer getOlhandoPara() {
		return olhandoPara;
	}

	public void setOlhandoPara(Integer olhandoPara) {
		this.olhandoPara = olhandoPara;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public Boolean getVenceu() {
		return venceu;
	}
	
	public void setVenceu(Boolean venceu) {
		this.venceu = venceu;
	}

}
