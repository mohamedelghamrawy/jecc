package com.mohamedelghamrawy.jecc.util;

import com.mohamedelghamrawy.jecc.domain.EcPoint;
import com.mohamedelghamrawy.jecc.domain.EccParameterSpec;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class EcPointArithmeticPerformanceTest {
    // Declare and initialize test class fields
    private static EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
    private static Random randomGen = new Random();

    // Random seed obtained from random.org
    BigInteger k = new BigInteger("99DC80C0A63EE5FC0AFC4FC883266F7920C68BF51E5BBA701B7C40FAAA1E7EAB", 16);

    // Results CSV
    File csvFile;
    FileWriter fileWriter;

    @BeforeEach
    void setUp() throws IOException {
        csvFile = new File("results.csv");
        fileWriter = new FileWriter(csvFile);
    }

    @AfterEach
    void tearDown() throws IOException {
        fileWriter.close();
    }

    @Test
    void scalarMultiply() {
        for (long i = 0; i < 10000; i++) {
            BigInteger ktemp = k.add(BigInteger.valueOf(randomGen.nextInt(Integer.MAX_VALUE)));

            // Calculate test results
            Stopwatch timer = Stopwatch.createStarted();
            EcPoint result = curve.scalarMultiply(ktemp, curve.getEccSpec().getG());
            timer.stop();

            String test = String.format("| %-20s | %-150s |", ktemp.toString(16).toUpperCase(),
                    result.toString());

            System.out.println(test + timer);

            // Save test results
            StringBuilder line = new StringBuilder();
            line.append(ktemp.toString(16).toUpperCase());
            line.append(',');
            line.append(result.getXCoordinate().toString(16).toUpperCase());
            line.append(',');
            line.append(result.getXCoordinate().toString(16).toUpperCase());
            line.append(',');
            line.append(timer.elapsed(TimeUnit.NANOSECONDS));
        }
    }

    private static final String repeatChar(char c, int length) {
        char[] data = new char[length];
        Arrays.fill(data, c);
        return new String(data);
    }
}