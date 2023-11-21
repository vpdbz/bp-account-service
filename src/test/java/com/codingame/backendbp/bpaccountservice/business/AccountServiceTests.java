package com.codingame.backendbp.bpaccountservice.business;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import com.codingame.backendbp.bpaccountservice.business.AccountService;
import com.codingame.backendbp.bpaccountservice.dao.AccountRepository;
import com.codingame.backendbp.bpaccountservice.dao.entity.AccountEntity;
import com.codingame.backendbp.bpaccountservice.dto.AccountResponse;

class AccountServiceTest {

  AccountRepository repository;
  AccountService service;

  @BeforeEach
  void setup() {
    repository = Mockito.mock(AccountRepository.class);
    service = new AccountService(repository); 
  }

  @Test
  void getAllaccounts() {
    // Mock findAll response
    Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new AccountEntity()));
    
    // Call service
    List<AccountResponse> result = service.getAllAccounts();
    
    // Assertions
    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void getaccountById() {
    // Mock findById response for valid id
    Mockito.when(repository.findById(1L))
      .thenReturn(Optional.of(new AccountEntity()));

    // Mock findById response for invalid id 
    Mockito.when(repository.findById(2L))
      .thenReturn(Optional.empty());

    // Call service
    AccountResponse result1 = service.getAccountById(1L);
    AccountResponse result2 = service.getAccountById(2L);

    // Assertions 
    assertNotNull(result1);
    assertNull(result2);
  }

  // Tests for save, update, delete account
}