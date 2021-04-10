package com.accountfy.hackaton.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TB_PARTIDA")
public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@CreationTimestamp
	@Column(name = "CREATION_DATE", updatable = false, nullable = false)
	private Date creationDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", nullable = false)
	private Date updateDate;

	@Column(name = "NOME_JOGADOR")
	private String nomeJogador;

	@Column(name = "QTDE_JOGADAS")
	private Integer qtdeJogadas;

	@Column(name = "QTDE_JOGADAS_MINIMO")
	private Integer qtdeJogadasMinimo;

	@Column(name = "DIFICULDADE")
	private Integer dificuldade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public Integer getQtdeJogadas() {
		return qtdeJogadas;
	}

	public void setQtdeJogadas(Integer qtdeJogadas) {
		this.qtdeJogadas = qtdeJogadas;
	}

	public Integer getQtdeJogadasMinimo() {
		return qtdeJogadasMinimo;
	}

	public void setQtdeJogadasMinimo(Integer qtdeJogadasMinimo) {
		this.qtdeJogadasMinimo = qtdeJogadasMinimo;
	}

	public Integer getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Integer dificuldade) {
		this.dificuldade = dificuldade;
	}

}
