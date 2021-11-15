/**
 * EcPoint class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 15.11.21
 */

package com.github.mhelghamrawy.ie7cryptographyecc;

import lombok.Getter;

import java.math.BigInteger;
import java.util.Objects;

@Getter
public class EcPoint {
    public static final EcPoint POINT_AT_INFINITY = new EcPoint();

    public final BigInteger xCoordinate;
    public final BigInteger yCoordinate;

    private EcPoint() {
        this.xCoordinate = null;
        this.yCoordinate = null;
    }

    public EcPoint(BigInteger x, BigInteger y) {
        if (x == null || y == null) {
            throw new NullPointerException();
        }

        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EcPoint ecPoint = (EcPoint) o;
        return Objects.equals(xCoordinate, ecPoint.xCoordinate) && Objects.equals(yCoordinate, ecPoint.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
