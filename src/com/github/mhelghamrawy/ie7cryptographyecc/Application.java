package com.github.mhelghamrawy.ie7cryptographyecc;

import java.math.BigInteger;

public class Application {

    public static void main(String[] args) {
        EcPoint point1 = new EcPoint(new BigInteger("1"), new BigInteger("2"));
        EcPoint point2 = new EcPoint(new BigInteger("1"), new BigInteger("3"));

        System.out.println(point1.equals(point2));
    }
}
