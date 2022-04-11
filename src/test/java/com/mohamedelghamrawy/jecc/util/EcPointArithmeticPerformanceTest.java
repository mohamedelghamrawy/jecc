package com.mohamedelghamrawy.jecc.util;

import com.mohamedelghamrawy.jecc.domain.EcPoint;
import com.mohamedelghamrawy.jecc.domain.EccParameterSpec;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class EcPointArithmeticPerformanceTest {
    // Declare and initialize test class fields
    private static EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
    private static Random randomGen = new Random();

    // Random seed obtained from random.org
    BigInteger k = new BigInteger("99DC80C0A63EE5FC0AFC4FC883266F7920C68BF51E5BBA701B7C40FAAA1E7EAB", 16);

    // Results
    File csvFile;
    FileWriter fileWriter;
    List<Long> results;

    @BeforeEach
    void setUp() throws IOException {
        csvFile = new File("results.csv");
        fileWriter = new FileWriter(csvFile);
        results = new LinkedList();
    }

    @AfterEach
    void tearDown() throws IOException {
        fileWriter.close();
    }

    @Test
    void scalarMultiplyPerformance() throws IOException {
        for (long i = 0; i < 10000; i++) {
            BigInteger ktemp = k.add(BigInteger.valueOf(randomGen.nextInt(Integer.MAX_VALUE)));

            // Calculate test result
            Stopwatch timer = Stopwatch.createStarted();
            EcPoint result = curve.scalarMultiply(ktemp, curve.getEccSpec().getG());
            timer.stop();

            // Print test result
            String test = String.format("| %-20s | %-150s |", ktemp.toString(16).toUpperCase(),
                    result.toString());
            System.out.println(test + timer);

            // Append test result to linked list
            results.add(timer.elapsed(TimeUnit.NANOSECONDS));

            // Save test result to CSV file
            StringBuilder line = new StringBuilder();
            line.append(ktemp.toString(16).toUpperCase());
            line.append(',');
            line.append(result.getXCoordinate().toString(16).toUpperCase());
            line.append(',');
            line.append(result.getXCoordinate().toString(16).toUpperCase());
            line.append(',');
            line.append(timer.elapsed(TimeUnit.NANOSECONDS));
            line.append("\n");
            fileWriter.write(line.toString());
        }

        OptionalDouble resultsMean = results.stream().mapToDouble(Long::doubleValue).average();

        if(!resultsMean.isPresent()) {
            throw new AssertionError("Results mean could not be calculated");
        }
        else {
            // Assert that average time taken is less than 17ms
            assertTrue(resultsMean.getAsDouble() < 18000000, "Average time taken is more than 18ms");
        }
    }

    private static final String repeatChar(char c, int length) {
        char[] data = new char[length];
        Arrays.fill(data, c);
        return new String(data);
    }
}