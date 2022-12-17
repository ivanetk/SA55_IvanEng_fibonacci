package sg.oracle.assessment.solution.service;

import java.math.BigInteger;

public interface FibonacciService {
    BigInteger[] getFibonacciSequence(int elements);
    BigInteger[] sortSequence(BigInteger[] sequence);
}
