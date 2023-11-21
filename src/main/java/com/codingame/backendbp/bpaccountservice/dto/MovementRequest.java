package com.codingame.backendbp.bpaccountservice.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public record MovementRequest(
        @Range(min = 1, message = "El numero es obligatorio") @JsonProperty("numero") long number,
        @JsonFormat(pattern = "dd-MM-yyyy") @JsonProperty("fecha") LocalDateTime date,
        @NotBlank(message = "El tipo de cuenta es obligatorio") @JsonProperty("tipo") String type,
        @JsonProperty("movimiento") long amount) {

}
