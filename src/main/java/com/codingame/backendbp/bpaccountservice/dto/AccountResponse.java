package com.codingame.backendbp.bpaccountservice.dto;

public record AccountResponse(
    long id,
    long number,
    String type,
    long balance,
    long clientId,
    String clientName,
    boolean status) {

}
