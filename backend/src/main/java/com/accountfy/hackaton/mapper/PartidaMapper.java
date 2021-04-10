package com.accountfy.hackaton.mapper;

import org.mapstruct.Mapper;

import com.accountfy.hackaton.dto.PartidaReceived;
import com.accountfy.hackaton.dto.PartidaSended;
import com.accountfy.hackaton.entity.Partida;

@Mapper(componentModel="spring")
public interface PartidaMapper {

	public Partida toPartida(PartidaReceived dto);
	
	public PartidaSended toPartida(Partida partida);
}
