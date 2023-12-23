package com.bank.cubos.domain.DTO;

import java.math.BigDecimal;

public record ClienteDTO(String nome, String sobreNome, BigDecimal participacao) {
}
