package desafio.itau.springboot.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TransactionRequest {
    
    @NotNull
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;
}
