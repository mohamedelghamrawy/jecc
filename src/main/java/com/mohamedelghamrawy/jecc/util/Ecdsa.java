/**
 * Ecdsa class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 10.04.22
 */

package com.mohamedelghamrawy.jecc.util;

import com.mohamedelghamrawy.jecc.domain.EcPoint;
import com.mohamedelghamrawy.jecc.domain.EccParameterSpec;
import com.mohamedelghamrawy.jecc.domain.EcdsaSignature;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Random;

public class Ecdsa {
    // Declare and initialize class fields
    private static EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
    private static EccParameterSpec spec = curve.getEccSpec();
    private static Random randomGen = new Random();

    EcdsaSignature sign(String message, BigInteger Kpr) throws NoSuchAlgorithmException {
        EcdsaSignature signature = new EcdsaSignature(message);
        signature.setSpec(spec);

        // Calculate and set public key
        EcPoint Kpub = curve.scalarMultiply(Kpr, spec.g);
        signature.setKpub(Kpub);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashMessage = digest.digest(message.getBytes());
        message.getBytes(StandardCharsets.UTF_8);
        BigInteger numberMessage = new BigInteger(hexFromBinary(hashMessage), 16);
        BigInteger randNum = BigInteger.valueOf(randomGen.nextInt(Integer.MAX_VALUE));

        EcPoint randomSignPoint = curve.scalarMultiply(randNum, spec.g);

        BigInteger r = randomSignPoint.getXCoordinate().mod(spec.p);
        BigInteger s = (numberMessage.add(r.multiply(Kpr)))
                .multiply(randNum)
                .modInverse(spec.p)
                .mod(spec.p);

        signature.setR(r);
        signature.setS(s);

        System.out.println(signature);

        return signature;
    }

    boolean verify(String plaintext, EcdsaSignature signature) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashMessage = digest.digest(signature.getMessage().getBytes());
        BigInteger hash = new BigInteger(hexFromBinary(hashMessage), 16);

        BigInteger w = signature.getS().modInverse(spec.p);
        BigInteger u1 = hash.multiply(signature.getS()).modInverse(spec.p);
        BigInteger u2 = signature.getR().multiply(signature.getS()).modInverse(spec.p);

        EcPoint v = curve.pointAdd(curve.scalarMultiply(u1, spec.g), curve.scalarMultiply(u2, signature.getKpub()));

        if(v.getXCoordinate().equals(signature.getR().mod(spec.p))) {return true;}
        else {return false;}
    }

    public static String hexFromBinary(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
