package com.accountfy.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.accountfy.hackaton.entity.Partida;

@Transactional
public interface PartidaRepository extends JpaRepository<Partida, Long> {


}
