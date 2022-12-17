package sg.oracle.assessment.solution.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sg.oracle.assessment.solution.model.Elements;
import sg.oracle.assessment.solution.model.Fibonacci;
import sg.oracle.assessment.solution.service.FibonacciService;

// Since we need to return Fibonacci sequence up to 100 elements, use BigInteger.
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/fibonacci")
    public ResponseEntity generateSequence(@RequestBody Elements elements) {
        int elementsInt = elements.getElements();
        BigInteger[] fibonacciSequence = fibonacciService.getFibonacciSequence(elementsInt);
        BigInteger[] sortedSequence = fibonacciService.sortSequence(fibonacciSequence);

        Fibonacci fibonacci = new Fibonacci(fibonacciSequence, sortedSequence);

        return ResponseEntity.status(HttpStatus.OK).body(fibonacci);
    }
}
