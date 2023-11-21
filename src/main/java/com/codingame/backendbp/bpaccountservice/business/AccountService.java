package com.codingame.backendbp.bpaccountservice.business;

import com.codingame.backendbp.bpaccountservice.dto.AccountResponse;
import com.codingame.backendbp.bpaccountservice.exception.NotFoundException;
import com.codingame.backendbp.bpaccountservice.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codingame.backendbp.bpaccountservice.dao.AccountRepository;
import com.codingame.backendbp.bpaccountservice.dao.entity.AccountEntity;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(entity -> mapToAccountResponse(entity))
                .collect(Collectors.toList());
    }

    public AccountResponse getAccountById(Long id) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(id);
        if (accountEntity.isPresent()) {
            return mapToAccountResponse(accountEntity.get());
        } else {
            return null;
        }
    }

    public AccountResponse saveAccount(Account account) {
        AccountEntity accountEntity = accountRepository.save(new AccountEntity(account));
        return mapToAccountResponse(accountEntity);
    }

    public AccountResponse updateAccount(Long id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            AccountEntity accountEntity = accountRepository.save(new AccountEntity(account));
            return mapToAccountResponse(accountEntity);
        } else {
            throw new NotFoundException("Account not found with id: " + id);
        }
    }

    public AccountResponse patchAccount(Long id, Account account) {
        return accountRepository.findById(id)
                .map(accountFound -> {
                    if (account.getNumber() != null) {
                        accountFound.setNumber(account.getNumber());
                    }
                    if (account.getType() != null) {
                        accountFound.setType(account.getType());
                    }
                    if (account.getBalance() != null) {
                        accountFound.setBalance(account.getBalance());
                    }
                    if (account.isStatus() != null) {
                        accountFound.setStatus(account.isStatus());
                    }

                    AccountEntity accountEntity = accountRepository.save(accountFound);
                    return mapToAccountResponse(accountEntity);
                })
                .orElseThrow(() -> new NotFoundException("Numero de Cuenta no encontrado con ID: " + id));
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    private AccountResponse mapToAccountResponse(AccountEntity accountEntity) {
        return new AccountResponse(
                accountEntity.getId(),
                accountEntity.getNumber(),
                accountEntity.getType(),
                accountEntity.getBalance(),
                accountEntity.getClientId(),
                accountEntity.getClientName(),
                accountEntity.isStatus());
    }

}
