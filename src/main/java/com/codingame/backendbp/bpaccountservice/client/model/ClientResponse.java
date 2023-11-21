package com.codingame.backendbp.bpaccountservice.client.model;

public record ClientResponse (
        long id,
        String name,
        String gender,
        int age,
        String address,
        String phone,
        boolean status) {

}
