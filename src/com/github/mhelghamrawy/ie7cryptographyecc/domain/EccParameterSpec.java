/**
 * EccParameterSpec class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 27.11.21
 */

package com.github.mhelghamrawy.ie7cryptographyecc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class EccParameterSpec {
    @NonNull
    public final BigInteger p;
    @NonNull
    public final BigInteger a;
    @NonNull
    public final BigInteger b;
    @NonNull
    public final EcPoint g;

    public BigInteger n;
    public BigInteger h;

    public static EccParameterSpec TEST_ECC_1 = new EccParameterSpec(
            new BigInteger("17"),
            new BigInteger("2"),
            new BigInteger("2"),
            new EcPoint(new BigInteger("5"), new BigInteger("1")),
            new BigInteger("19"),
            new BigInteger("0")
    );

    public static EccParameterSpec TEST_ECC_2 = new EccParameterSpec(
            new BigInteger("97"),
            new BigInteger("2"),
            new BigInteger("3"),
            new EcPoint(new BigInteger("3"), new BigInteger("6")),
            new BigInteger("5"),
            new BigInteger("5") // wrong
    );

    public static EccParameterSpec TEST_ECC_3 = new EccParameterSpec(
            new BigInteger("23"),
            new BigInteger("1"),
            new BigInteger("4"),
            new EcPoint(new BigInteger("7"), new BigInteger("3"))
    );
}
