/**
 * EcScalarMultiplication class implements
 *
 * @author mohamedelghamrawy
 * @version 1.0
 * @since 16.11.21
 */

package com.mohamedelghamrawy.jecc;

import com.mohamedelghamrawy.jecc.domain.EccParameterSpec;
import com.mohamedelghamrawy.jecc.util.EcPointArithmetic;

import java.math.BigInteger;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
        Random randomGen = new Random();

        for (long i = 0; i < 20; i++) {
            long k = randomGen.nextInt(1000000000);
            System.out.println(String.format("|%-20s|", BigInteger.valueOf(k).toString(16).toUpperCase()) + curve.scalarMultiply(BigInteger.valueOf(k), curve.getEccSpec().getG()));
        }
    }
}
