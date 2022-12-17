package sg.oracle.assessment.solution.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public BigInteger[] getFibonacciSequence(int elements) {
        BigInteger[] sequence = new BigInteger[elements];
        // If one element, return [0]
        if (elements == 1) {
            sequence[0] = BigInteger.valueOf(0);
            return sequence;
        }
        // If two or more elements, return the desired fibonacci sequence
        if (elements >= 2) {
            sequence[0] = BigInteger.valueOf(0);
            sequence[1] = BigInteger.valueOf(1);
            for (int i = 2; i < elements; i++) {
                sequence[i] = sequence[i - 1].add(sequence[i - 2]); 
            }
            return sequence;
        }
        // Return empty int array if elements = 0
        return sequence;
    }

    @Override
    public BigInteger[] sortSequence(BigInteger[] sequence) {
        // Count the number of even and odd elements
        int oddCount = 0;
        int evenCount = 0;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger zero = BigInteger.valueOf(0);
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i].mod(two) == zero) {
                evenCount += 1;
            } else {
                oddCount += 1;
            }
        }
        // Instantiate one even and one odd array with their respective lengths
        BigInteger[] oddArray = new BigInteger[oddCount];
        BigInteger[] evenArray = new BigInteger[evenCount];

        // Fill each array with their respective elements, in descending order
        int oddIndex = 0;
        int evenIndex = 0;
        for (int j = sequence.length - 1; j >= 0; j--) {
            if (sequence[j].mod(two) == zero) {
                evenArray[evenIndex] = sequence[j];
                evenIndex++;
            } else {
                oddArray[oddIndex] = sequence[j];
                oddIndex++;
            }
        }

        // Merge both arrays and return sorted sequence
        BigInteger[] sortedSequence = new BigInteger[sequence.length];
        int oddStartingPos = evenCount;
        System.arraycopy(evenArray, 0, sortedSequence, 0, evenCount);
        System.arraycopy(oddArray, 0, sortedSequence, oddStartingPos, oddCount);

        return sortedSequence;
    }

}
