package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

}