/**
 * EcScalarMultiplication class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 16.11.21
 */

package com.github.mhelghamrawy.ie7cryptographyecc;

import com.github.mhelghamrawy.ie7cryptographyecc.domain.EccParameterSpec;
import com.github.mhelghamrawy.ie7cryptographyecc.util.EcPointArithmetic;

import java.math.BigInteger;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
        Random randomGen = new Random();   
     //   long k = 457061701;
        
       // System.out.println( BigInteger.valueOf(k).toString(16).toUpperCase() + curve.scalarMultiply(BigInteger.valueOf(k), curve.getEccSpec().getG()));

		
		  for (long i = 0; i < 100; i++) {
			  long k = randomGen.nextInt(1000000000);
			  System.out.println(String.format("|%-20s|",
			  BigInteger.valueOf(k).toString(16).toUpperCase()) +
			  curve.scalarMultiply(BigInteger.valueOf(k), curve.getEccSpec().getG()));
		 }
		 
    }
}
