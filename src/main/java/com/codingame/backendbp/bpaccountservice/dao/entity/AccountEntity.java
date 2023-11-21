package com.codingame.backendbp.bpaccountservice.dao.entity;

import com.codingame.backendbp.bpaccountservice.model.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "account", schema = "public",
                indexes = {@Index(name = "idx_account_number", columnList = "number")},
                uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "type"})})
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long number;

    @NotNull
    private String type;
    private long balance;
    private long clientId;

    @NotNull
    private String clientName;
    private boolean status;

    @OneToOne(mappedBy = "accountEntity")
    private MovementEntity movementEntity;

    public AccountEntity() {
    }

    public AccountEntity(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.type = account.getType();
        this.balance = account.getBalance();
        this.clientId = account.getClientId();
        this.clientName = account.getClientName();
        this.status = account.isStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MovementEntity getMovementEntity() {
        return movementEntity;
    }

    public void setMovementEntity(MovementEntity movementEntity) {
        this.movementEntity = movementEntity;
    }
    
}