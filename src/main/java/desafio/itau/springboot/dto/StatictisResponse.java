package desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatictisResponse {
 
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public StatictisResponse(DoubleSummaryStatistics stats) {
        this.sum = stats.getSum();  
        this.avg = stats.getAverage();
        this.max = stats.getMax();
        this.min = stats.getMin();
        this.count = stats.getCount();
    }
    
}
