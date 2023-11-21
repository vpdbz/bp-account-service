package com.codingame.backendbp.bpaccountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingame.backendbp.bpaccountservice.dao.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    
}
