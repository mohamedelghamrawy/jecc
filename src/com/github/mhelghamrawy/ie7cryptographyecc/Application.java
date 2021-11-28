/**
 * EcScalarMultiplication class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 16.11.21
 */

package com.github.mhelghamrawy.ie7cryptographyecc;

import com.github.mhelghamrawy.ie7cryptographyecc.domain.EcPoint;
import com.github.mhelghamrawy.ie7cryptographyecc.domain.EccParameterSpec;
import com.github.mhelghamrawy.ie7cryptographyecc.util.EcPointArithmetic;

import java.math.BigInteger;

public class Application {

    public static void main(String[] args) {
        EcPointArithmetic curve1 = new EcPointArithmetic(EccParameterSpec.TEST_ECC_2);
        for (long k = 0; k < 20; k++) {
            System.out.println("k = " + k + " " + curve1.scalmult(BigInteger.valueOf(k), new EcPoint(new BigInteger("3"), new BigInteger("6"))));
        }

        EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.TEST_ECC_3);
        System.out.println(curve.doublePoint(new EcPoint(new BigInteger("7"), new BigInteger("3"))));
        System.out.println(curve.addPoint(new EcPoint(new BigInteger("4"), new BigInteger("16")), new EcPoint(new BigInteger("14"), new BigInteger("18"))));

        EcPointArithmetic curve2 = new EcPointArithmetic(EccParameterSpec.TEST_ECC_1);
        for (long k = 0; k < 21; k++) {
            System.out.println("k = " + k + " " + curve2.scalmult(BigInteger.valueOf(k), new EcPoint(new BigInteger("5"), new BigInteger("1"))));
        }
    }
}
