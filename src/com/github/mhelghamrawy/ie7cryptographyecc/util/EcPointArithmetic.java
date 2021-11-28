/**
 * EcScalarMultiplication class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 16.11.21
 */

package com.github.mhelghamrawy.ie7cryptographyecc.util;

import com.github.mhelghamrawy.ie7cryptographyecc.domain.EcPoint;
import com.github.mhelghamrawy.ie7cryptographyecc.domain.EccParameterSpec;

import java.math.BigInteger;

public class EcPointArithmetic {
    private final EccParameterSpec EccSpec;

    public EcPointArithmetic(EccParameterSpec EccParamSpec) {
        this.EccSpec = EccParamSpec;
    }

    public EcPoint scalmult(BigInteger k, EcPoint P){
        /*
            Using T = P, we were getting arithmetic errors due to operations with null, so we decided to start at
            the point at infinity and modulo k. Thus, we make use of the cyclic nature of kP without involving
            the point at infinity in any algebraic operations.
        */
        EcPoint T = EcPoint.POINT_AT_INFINITY;
        k = k.mod(EccSpec.n);

        /*
            Convert k (private key) to its binary representation using array of bytes
            with each element byte containing only one bit
        */
        int bitLength = k.bitLength();
        byte[] biarray = new byte[bitLength];

        for(int i=0;i<bitLength;i++){
            biarray[i] = k.mod(BigInteger.TWO).byteValue();
            k = k.divide(BigInteger.TWO);
        }

        // Double-and-add algorithm
        for(int i = bitLength-1;i >= 0;i--){
            T = doublePoint(T);
            if(biarray[i] == 0b00000001)
                T = addPoint(T, P);
        }

        return T;
    }

    public EcPoint addPoint(EcPoint P, EcPoint Q) {
        if (P.equals(Q)) { return doublePoint(P);}
        else if (P.equals(EcPoint.POINT_AT_INFINITY)) { return Q;}
        else if (Q.equals(EcPoint.POINT_AT_INFINITY)) { return P;}

        BigInteger slope = (P.getYCoordinate().subtract(Q.getYCoordinate()))
                .multiply(P.getXCoordinate().subtract(Q.getXCoordinate()).modInverse(EccSpec.p))
                .mod(EccSpec.p);

        BigInteger Rx = (slope.modPow(BigInteger.TWO, EccSpec.p)
                .subtract(P.getXCoordinate())).subtract(Q.getXCoordinate())
                .mod(EccSpec.p);

        BigInteger Ry = Q.getYCoordinate().negate()
                .add(slope.multiply(Q.getXCoordinate().subtract(Rx)))
                .mod(EccSpec.p);

        return new EcPoint(Rx, Ry);
    }

    public EcPoint doublePoint(EcPoint P) {
        if (P.equals(EcPoint.POINT_AT_INFINITY)) { return P;}

        BigInteger slope = (P.getXCoordinate().pow(2)).multiply(new BigInteger("3")).add(EccSpec.a)
                .multiply((P.getYCoordinate().multiply(BigInteger.TWO)).modInverse(EccSpec.p));

        BigInteger Rx = slope.pow(2)
                .subtract(P.getXCoordinate().multiply(BigInteger.TWO))
                .mod(EccSpec.p);

        BigInteger Ry = (P.getYCoordinate().negate())
                .add(slope.multiply(P.getXCoordinate().subtract(Rx)))
                .mod(EccSpec.p);

        return new EcPoint(Rx, Ry);
    }
}
