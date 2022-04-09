package com.mohamedelghamrawy.jecc.util;

import com.mohamedelghamrawy.jecc.domain.EcPoint;
import com.mohamedelghamrawy.jecc.domain.EccParameterSpec;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EcPointArithmeticTest {
    // Declare and initialize BouncyCastle fields
    private static AbstractECMultiplier bouncyCastleMultiplier = new FixedPointCombMultiplier();
    ECNamedCurveParameterSpec bouncyCastleSpec = ECNamedCurveTable.getParameterSpec("secp256k1");
    ECPoint bouncyCastleG = bouncyCastleSpec.getG();

    // Declare and initialize test class fields
    private static EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
    private static Random randomGen = new Random();

    // Random seed obtained from random.org
    BigInteger k = new BigInteger("99DC80C0A63EE5FC0AFC4FC883266F7920C68BF51E5BBA701B7C40FAAA1E7EAB", 16);

    // Declare and initialize table headers
    private static final String header = repeatChar('-', 177);

    @Test
    void scalarMultiply() {
        for (long i = 0; i < 1000; i++) {
            BigInteger ktemp = k.add(BigInteger.valueOf(randomGen.nextInt(Integer.MAX_VALUE)));

            EcPoint result;
            ECPoint bouncyCastleResult;

            // Calculate test results
            result = curve.scalarMultiply(ktemp, curve.getEccSpec().getG());
            bouncyCastleResult = bouncyCastleG.multiply(ktemp);

            // Prepare BouncyCastle test vectors for assertion
            bouncyCastleResult = bouncyCastleResult.normalize();
            String bouncyCastleResultString = String.format("(%s, %s)", bouncyCastleResult.getRawXCoord(), bouncyCastleResult.getRawYCoord()).toUpperCase();

            // Assert test vectors
            assertEquals(result.toString(), bouncyCastleResultString);

            // Prepare and print test vectors
            String test = String.format("| %-20s | %-150s |", ktemp.toString(16).toUpperCase(), result.toString());
            String test2 = String.format("| %-20s | %-150s |", ktemp.toString(16).toUpperCase(), bouncyCastleResultString);
            System.out.printf("%s\n%s\n%s\n", header, test, test2);
        }
    }

    private static final String repeatChar(char c, int length) {
        char[] data = new char[length];
        Arrays.fill(data, c);
        return new String(data);
    }
}