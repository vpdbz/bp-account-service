package com.codingame.backendbp.bpaccountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingame.backendbp.bpaccountservice.dao.entity.MovementEntity;

public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
    
}
