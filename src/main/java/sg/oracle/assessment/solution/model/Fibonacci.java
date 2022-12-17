package sg.oracle.assessment.solution.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fibonacci {
    private BigInteger[] fibonacci;
    private BigInteger[] sorted;
}
