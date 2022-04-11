package com.mohamedelghamrawy.jecc.util;

import com.mohamedelghamrawy.jecc.domain.EcdsaSignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class EcdsaTest {
    static Ecdsa ecdsa = new Ecdsa();

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String plaintext = "plaintext";
        byte[] encodedhash = digest.digest(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    static void ecdsaSign() throws NoSuchAlgorithmException {
        EcdsaSignature signature = ecdsa.sign("100", BigInteger.TWO);

        boolean verification = ecdsa.verify("100", signature);

        assertTrue(verification == true);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ecdsaSign();
    }
}