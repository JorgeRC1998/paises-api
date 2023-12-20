package com.capacitacion.docker2023.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capacitacion.docker2023.entity.PaisEntity;

public interface PaisesDao extends JpaRepository<PaisEntity, Long> {

}
