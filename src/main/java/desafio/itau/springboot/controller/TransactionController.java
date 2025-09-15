package desafio.itau.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.TransactionRequest;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.services.TransactionServices;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionServices transactionServices;

    public TransactionController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
        if (request.getDataHora().isAfter(java.time.OffsetDateTime.now()) || request.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionServices.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions() {
        transactionServices.clearTransactions();
        return ResponseEntity.ok().build();
    }
    


    
}
