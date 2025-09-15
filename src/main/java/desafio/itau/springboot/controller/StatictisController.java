package desafio.itau.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.StatictisResponse;
import desafio.itau.springboot.services.TransactionServices;


@RestController
@RequestMapping("/estatistica")
public class StatictisController {

    private TransactionServices transactionServices;

    public StatictisController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }

    @GetMapping
    public ResponseEntity<StatictisResponse> getStatictis() {
        DoubleSummaryStatistics stats = transactionServices.getStatistics();
        return ResponseEntity.ok(new StatictisResponse(stats));
    }
    
    
}
