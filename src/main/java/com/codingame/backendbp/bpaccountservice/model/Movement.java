package com.codingame.backendbp.bpaccountservice.model;

import java.time.LocalDateTime;

import com.codingame.backendbp.bpaccountservice.dto.MovementRequest;

public class Movement {
    private long id;
    private long accountId;
    private long initialBalance;
    private long amount;
    private LocalDateTime date;
    private Account account;

    public Movement() {
    }

    public Movement(MovementRequest movementRequest) {
        this.amount = movementRequest.amount();
        this.date = movementRequest.date();
        this.account = new Account();
        this.account.setType(movementRequest.type());
        this.account.setNumber(movementRequest.number());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(long initialBalance) {
        this.initialBalance = initialBalance;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
